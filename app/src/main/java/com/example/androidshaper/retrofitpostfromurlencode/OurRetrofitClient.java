package com.example.androidshaper.retrofitpostfromurlencode;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface OurRetrofitClient {

    @FormUrlEncoded
    @POST("posts")
    Call<ObjectClass> createUser(@Field("userId") int userId,@Field("body") String body,@Field("title") String title);
}
