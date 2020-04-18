package com.shinro.shinrojp_android.api;


import com.shinro.shinrojp_android.models.LoginResponse;
import com.shinro.shinrojp_android.models.ServerResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserService {

 //Register a new account
    @POST("/register")
    @FormUrlEncoded
    Observable<ServerResponse> register(@Field("userAlias") String name,
                                        @Field("userEmail") String email,
                                        @Field("userPassword1") String password,
                                        @Field("userPassword2") String re_password
    );
    //Login
    @POST("/login")
    @FormUrlEncoded
    Observable<LoginResponse> login(@Field("login_username") String username,
                                    @Field("login_password") String password
    );

}
