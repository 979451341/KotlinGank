package com.example.lilingzhi.mygank.bean


data class BaseBean(var error:Boolean,var results:List<DataBean>)

data class DataBean(var desc:String,var images:List<String>,var url:String,var who:String)