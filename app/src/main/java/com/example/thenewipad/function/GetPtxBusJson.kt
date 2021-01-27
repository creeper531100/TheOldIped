package com.example.thenewipad.function

import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.icu.util.TimeZone
import android.os.Build
import androidx.annotation.RequiresApi
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.ProtocolException
import java.net.URL
import java.security.SignatureException
import java.util.*
import java.util.zip.GZIPInputStream


/* 這邊請不要管他!!!!
 * 這個不是我寫的
 * Kotlin分析比較快 */


open class GetPtxBusJson() {
    @kotlin.jvm.JvmField
    var response = ""

    fun request(url: String): String {
        var connection: HttpURLConnection? = null
        val APPID = "8af3b6907d5c443d90b6bd2f18361c15"
        val APPKey = "6f5mGu2y_kH-MaeZ2NKlS0_MDzI"
        val xdate = serverTime
        val SignDate = "x-date: $xdate"
        var respond = ""
        var Signature = ""
        try {
            Signature = HMAC_SHA1.Signature(SignDate, APPKey).toString()
        } catch (e1: SignatureException) {
            e1.printStackTrace()
        }
        val sAuth = ("hmac username=\"" + APPID + "\", algorithm=\"hmac-sha1\", headers=\"x-date\", signature=\""
                + Signature + "\"")
        try {
            val url = URL(url)
            if ("https".equals(url.protocol, ignoreCase = true)) {
                SslUtils.ignoreSsl()
            }
            connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            connection.setRequestProperty("Authorization", sAuth)
            connection.setRequestProperty("x-date", xdate)
            connection.setRequestProperty("Accept-Encoding", "gzip")
            connection.doInput = true
            //connection.setDoOutput(true);
            respond = connection.responseCode.toString() + " " + connection.responseMessage
            val `in`: BufferedReader

            // 判斷來源是否為gzip
            `in` = if ("gzip" == connection.contentEncoding) {
                val reader = InputStreamReader(GZIPInputStream(connection.inputStream))
                BufferedReader(reader)
            } else {
                val reader = InputStreamReader(connection.inputStream)
                BufferedReader(reader)
            }
            // 返回的數據已經過解壓
            val buffer = StringBuffer()
            // 讀取回傳資料
            var line = ""
            while (`in`.readLine().also { line = it } != null) {
                response += """
                    $line
                    """.trimIndent()
            }
        } catch (e: ProtocolException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return response
    }
    companion object {
        // 取得當下UTC時間
        val serverTime: String
            get() {
                val calendar = Calendar.getInstance()
                val dateFormat = SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US)
                dateFormat.timeZone = TimeZone.getTimeZone("GMT")
                return dateFormat.format(calendar.time)
            }
    }
}