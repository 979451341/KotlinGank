package com.example.lilingzhi.mygank

import android.app.Application
import android.content.Context
import android.os.Handler
import com.bumptech.glide.Glide
import com.lzy.okgo.OkGo
import com.lzy.okgo.cache.CacheMode

class MyApp():Application(){

    lateinit var context: Context

    lateinit var handler: Handler
    override fun onCreate() {
        super.onCreate()

        context=this
        handler=Handler()

        okgoInit()



    }

    fun okgoInit(){

        OkGo.getInstance().init(this)
                .setCacheMode(CacheMode.NO_CACHE)
                .setRetryCount(0)



    }

}