package com.example.thenewipad.function

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import java.security.SignatureException
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import java.util.*
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import javax.net.ssl.*

/* 這邊請不要管他!!!!
 * 這個不是我寫的
 * Kotlin分析比較快 */

internal object HMAC_SHA1 {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Throws(SignatureException::class)
    fun Signature(xData: String, AppKey: String): String {
        return try {
            val encoder = Base64.getEncoder()
            // get an hmac_sha1 key from the raw key bytes
            val signingKey = SecretKeySpec(AppKey.toByteArray(charset("UTF-8")), "HmacSHA1")

            // get an hmac_sha1 Mac instance and initialize with the signing key
            val mac = Mac.getInstance("HmacSHA1")
            mac.init(signingKey)

            // compute the hmac on input data bytes
            val rawHmac = mac.doFinal(xData.toByteArray(charset("UTF-8")))
            encoder.encodeToString(rawHmac)
        } catch (e: Exception) {
            throw SignatureException("Failed to generate HMAC : " + e.message)
        }
    }
}

internal object SslUtils {
    @Throws(Exception::class)
    private fun trustAllHttpsCertificates() {
        val trustAllCerts = arrayOfNulls<TrustManager>(1)
        val tm: TrustManager = miTM()
        trustAllCerts[0] = tm
        val sc = SSLContext.getInstance("SSL")
        sc.init(null, trustAllCerts, null)
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.socketFactory)
    }

    /**
     * 忽略HTTPS请求的SSL证书，必须在openConnection之前调用
     * @throws Exception
     */
    @Throws(Exception::class)
    fun ignoreSsl() {
        val hv = HostnameVerifier { urlHostName, session ->
            println("Warning: URL Host: " + urlHostName + " vs. " + session.peerHost)
            true
        }
        trustAllHttpsCertificates()
        HttpsURLConnection.setDefaultHostnameVerifier(hv)
    }

    internal class miTM : TrustManager, X509TrustManager {
        override fun getAcceptedIssuers(): Array<X509Certificate>? {
            return null
        }

        @SuppressLint("TrustAllX509TrustManager")
        @Throws(CertificateException::class)
        override fun checkServerTrusted(certs: Array<X509Certificate>, authType: String) {
            return
        }

        @SuppressLint("TrustAllX509TrustManager")
        @Throws(CertificateException::class)
        override fun checkClientTrusted(certs: Array<X509Certificate>, authType: String) {
            return
        }
    }
}