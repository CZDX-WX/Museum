package com.czdxwx.museum.data.network.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;

    // 获取 Retrofit 实例
    public static Retrofit getClient(String baseUrl) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl) // 服务器 URL
                    .addConverterFactory(GsonConverterFactory.create()) // JSON 转换器
                    .build();
        }
        return retrofit;
    }
}
