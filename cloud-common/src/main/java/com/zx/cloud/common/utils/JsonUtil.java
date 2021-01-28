package com.zx.cloud.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;

import java.io.Reader;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Json转换工具(线程安全)
 * @author zhaoxuan
 * @date 2021-01-22 15:14
 **/
public class JsonUtil {
    /**
     * 使用ThreadLocal创建对象，防止出现线程安全问题
     */
    private static final ThreadLocal<Gson> GSON_THREAD_LOCAL= ThreadLocal.withInitial(()-> new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .registerTypeAdapter(LocalDateTime.class, (JsonSerializer<LocalDateTime>) (src, typeOfSrc, context) -> new JsonPrimitive(src.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))))
            .registerTypeAdapter(LocalDate.class, (JsonSerializer<LocalDate>) (src, typeOfSrc, context) -> new JsonPrimitive(src.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))))
            .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext) -> {
                String datetime = json.getAsJsonPrimitive().getAsString();
                return LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            }).registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (json, type, jsonDeserializationContext) -> {
                String datetime = json.getAsJsonPrimitive().getAsString();
                return LocalDate.parse(datetime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }).create());

    private JsonUtil(){

    }

    /**
     * 对象转JSON
     * @param object 对象
     * @param <T> 对象的泛型
     * @return  JSON字符串
     */
    public static <T> String encode(final T object){
        String result=null;
        try {
            result = GSON_THREAD_LOCAL.get().toJson(object);
        }finally {
            GSON_THREAD_LOCAL.remove();
        }


        return result;
    }

    /**
     * JSON转对象
     * @param json  JSON字符串
     * @param clazz 对象类型
     * @param <T>   泛型
     * @return  转换后的对象
     */
    public static  <T> T decode(final String json,final Class<T> clazz){
       T result=null;
       try {
           result = GSON_THREAD_LOCAL.get().fromJson(json, clazz);
       }finally {
           GSON_THREAD_LOCAL.remove();
       }
        return result;
    }

    /**
     * JSON转指定泛型对象
     * @param reader  字符流
     * @param clazz   对象类型
     * @param <T>   泛型
     * @return  转换后的对象
     */
    public static <T> T decode(final Reader reader,final Class<T> clazz){
        T result=null;
        try {
            result = GSON_THREAD_LOCAL.get().fromJson(reader,clazz);
        }finally {
            GSON_THREAD_LOCAL.remove();
        }
        return result;
    }

    /**
     * JSON转指定泛型对象
     * @param json  JSON字符串
     * @param typeOfT   泛型对象
     * @param <T>   泛型
     * @return  转换后的对象
     */
    public static <T> T decode(final String json,Type typeOfT){
        T result=null;
        try {
            result = GSON_THREAD_LOCAL.get().fromJson(json,typeOfT);
        }finally {
            GSON_THREAD_LOCAL.remove();
        }
        return result;
    }

    /**
     * JSON转指定泛型对象
     * @param reader  字符流
     * @param typeOfT   泛型对象
     * @param <T>   泛型
     * @return  转换后的对象
     */
    public static <T> T decode(final Reader reader,final Type typeOfT){
        T result=null;
        try {
            result = GSON_THREAD_LOCAL.get().fromJson(reader,typeOfT);
        }finally {
            GSON_THREAD_LOCAL.remove();
        }
        return result;
    }



}
