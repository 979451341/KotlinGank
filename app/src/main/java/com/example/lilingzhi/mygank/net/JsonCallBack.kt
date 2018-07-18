package com.example.lilingzhi.mygank.net

import com.example.lilingzhi.mygank.bean.BaseBean
import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import com.lzy.okgo.callback.AbsCallback
import com.lzy.okgo.model.Response
import com.lzy.okgo.request.base.Request

import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

import okhttp3.ResponseBody

/**
 * 创建人: xieyushang
 * 时间: 2017-12-05 10:32
 */

open class JsonCallBack<T> : AbsCallback<T>() {

    var type: Type? = null
    var clazz: Class<T>? = null

    override fun onSuccess(response: Response<T>) {

    }

    override fun onStart(request: Request<T, out Request<*, *>>?) {
        super.onStart(request)
    }

    //@Throws(Throwable::class)
    override fun convertResponse(response: okhttp3.Response): T? {

        val genType = javaClass.genericSuperclass
        val params = (genType as ParameterizedType).actualTypeArguments

/*        val type = params[0] as? ParameterizedType ?: throw IllegalAccessException("没有填写泛型参数")

        val rawType = type.rawType
        val typeAragument = type.actualTypeArguments[0]*/

        val body = response.body() ?: return null
        val gson = Gson()
        val jsonReader = JsonReader(body.charStream())
        //if (rawType !== BaseBean::class.java) {
            val data = gson.fromJson<T>(jsonReader, BaseBean::class.java)
            response.close()
            return data
/*        } else {
            return null*/

            /*            if (typeAragument == Void.class){
                SimpleResponse simpleResponse = gson.fromJson(jsonReader,SimpleResponse.class);
                response.close();
                return (T)simpleResponse.toMyResponse();
            }else {
                MyResponse myResponse = gson.fromJson(jsonReader,type);
                response.close();
                if(myResponse.code ==100){//TOKEN失效
                    SPUtils.put(MyApplication.getContext(), SpConfig.IS_LOGIN,false);
                }
                return (T) myResponse;
            }*/
        //}
    }

    override fun onError(response: Response<T>) {
        super.onError(response)
    }


}