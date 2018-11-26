package com.example.home_pc.requestapp.api;

import com.example.home_pc.requestapp.entity.GeneralResponse;

import java.util.List;

import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface Api {

    @GET("/public-api/users")
    Observable<GeneralResponse> getAllUsers(@Header("Authorization") String accessToken);

    @GET("/public-api/users")
    Observable<GeneralResponse> getUserById(@Header("authorization") String accessToken, @Query("userId") String userId);

    @DELETE("/public-api/users")
    Observable<GeneralResponse> deleteUser(@Header("Authorization") String accessToken, @Query("userId") String userId);

    @POST("/public-api/users")
    Observable<GeneralResponse> createUser
            (@Header("Authorization") String accessToken,
             @Field("first_name") String firstName,
             @Field("last_name") String lastName,
             @Field("email") String email,
             @Field("gender") String userId);

    @PATCH("public-api/users/")
    Observable<GeneralResponse> updateUser
            (@Header("Authorization") String accessToken,
             @Query("userId") String userId,
             @Field("first_name") String firstName,
             @Field("last_name") String lastName);

}
