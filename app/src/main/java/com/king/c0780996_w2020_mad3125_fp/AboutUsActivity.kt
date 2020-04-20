package com.king.c0780996_w2020_mad3125_fp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import androidx.annotation.RequiresApi
import java.io.IOException
import java.nio.charset.StandardCharsets

class AboutUsActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)

        val myWebView: WebView = findViewById(R.id.aboutUsWebView)

        val mActionBar = supportActionBar
        mActionBar!!.hide()
        val assetManager = this.assets

        try {
            val inputStream = assetManager.open("aboutus.html")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            val content = String(buffer, StandardCharsets.UTF_8)
            Log.d("DATA", content)
            myWebView?.loadData(content, "text/html", "utf-8")
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}