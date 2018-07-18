package com.example.lilingzhi.mygank

import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.view.MenuItem
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        var url= intent.getStringExtra("url")
        wv.loadUrl(url)
        wv.webChromeClient=wvChromeClient
        wv.webViewClient=wvClient
        var webSetting:WebSettings=wv.settings
        webSetting.javaScriptEnabled=true
        webSetting.setSupportZoom(true)
        webSetting.builtInZoomControls=true

        var actionBar: ActionBar?=supportActionBar
        actionBar?.title="在activity、fragment的使用"
        actionBar?.setHomeButtonEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onDestroy() {
        super.onDestroy()
        wv.destroy()
    }

    var wvClient:WebViewClient=object :WebViewClient(){


    }

    var wvChromeClient:WebChromeClient=object :WebChromeClient(){

        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            if(newProgress<100){
                pb.setProgress(newProgress)
            }else{
                pb.visibility=View.GONE
            }
        }
    }



    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            android.R.id.home -> this.finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
