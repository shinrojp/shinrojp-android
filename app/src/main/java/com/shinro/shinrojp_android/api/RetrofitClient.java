package com.shinro.shinrojp_android.api;

import com.shinro.shinrojp_android.bases.MainApplication;
import com.shinro.shinrojp_android.utils.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient extends Constants {

    public static Retrofit getClient(String baseUrl, boolean isAuthorization, String token) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder().addInterceptor((Interceptor) chain -> {
            Request original = chain.request();
            if(isAuthorization && !token.trim().isEmpty()) {
                Request.Builder builder = original.newBuilder()
                                            .header("Authorization", "Bearer " + token)
                                            .method(original.method(), original.body());
                Request request = builder.build();
                return chain.proceed(request);
            } else {
                Request.Builder builder = original.newBuilder().method(original.method(), original.body());
                Request request = builder.build();
                return chain.proceed(request);
            }
        });
        //Timeout
        OkHttpClient client = httpClient
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(new MainApplication().self().getGson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }

}
