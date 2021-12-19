package com.example.semesta.apihelper;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserService {

    @FormUrlEncoded
    @POST("login")
    Call<ResObj> login(@Field("email") String email, @Field("password") String password
    );

}
