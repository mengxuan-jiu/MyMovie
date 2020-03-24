package com.bw.movie;

import com.bw.movie.band.Registered;
import com.bw.movie.band.SendOutEmailCode;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @包名 com.bw.movie
 * @MengXuanmengxuan
 * @日期2020/3/23
 * @项目名MxMove
 * @类名Api
 **/
public interface Api {
    @FormUrlEncoded
    @POST("movieApi/user/v2/sendOutEmailCode")
    Observable<SendOutEmailCode>SendOutEmailCode(@Field("email") String email);//发送电子邮件代码

    @FormUrlEncoded
    @POST("movieApi/user/v2/register")
    Observable<Registered>Registered(@Field("email") String nickName, @Field("email")
            String pwd, @Field("email")String email, @Field("email") String code);//注册
}
