package com.zzw.componentbase.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建人: xieyushang
 * 时间: 2017-12-21 19:37
 */

public class MapUtils {

    /**
     * 实体类转换成map,不支持复合对象转换
     * @param bean
     * @param <T>
     * @return
     */
    public static <T> Map bean2Map(T bean){
        Gson gson = new Gson();
        String jsonString = gson.toJson(bean);
        Map<String,Object> map = gson.fromJson(jsonString, new TypeToken<HashMap<String,Object>>(){}.getType());
        return map;
    }



}
