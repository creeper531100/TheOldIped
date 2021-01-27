package com.example.thenewipad.function

import android.annotation.SuppressLint
import android.util.Base64
import android.util.Base64.encodeToString
import java.security.SignatureException
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import javax.net.ssl.*

/* 這邊請不要管他!!!!
 * 這個不是我寫的
 * Kotlin分析比較快 */

object HMAC_SHA1 {
    @Throws(SignatureException::class)
    open fun Signature(xData: String, AppKey: String): String? {
        return try {
            val signingKey = SecretKeySpec(AppKey.toByteArray(charset("UTF-8")), "HmacSHA1")
            val mac = Mac.getInstance("HmacSHA1")
            mac.init(signingKey)
            val rawHmac = mac.doFinal(xData.toByteArray(charset("UTF-8")))
            var result = encodeToString(rawHmac, Base64.DEFAULT) //這行要改成這樣，不然就只能在 Andorid 8.0 才能使用
            result = result.replace("\n", "") // 要加這一行，不然會認證失敗
            result
        } catch (e: java.lang.Exception) {
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