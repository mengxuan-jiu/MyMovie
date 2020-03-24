package com.bw.movie.util;

import com.bw.movie.Api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @包名 com.bw.movie.util
 * @MengXuanmengxuan
 * @日期2020/3/23
 * @项目名MxMove
 * @类名NetUtil
 **/
public class NetUtil {

    private final Api mApi;

    private static final class PNetUtil{
        private static final NetUtil NET_UTIL= new NetUtil();

    }

    public static NetUtil getInstance() {
        return PNetUtil.NET_UTIL;
    }

    public NetUtil() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .writeTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mobile.bwstudent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

                .build();
        mApi = retrofit.create(Api.class);
    }

    public Api getmApi() {
        return mApi;
    }
}
