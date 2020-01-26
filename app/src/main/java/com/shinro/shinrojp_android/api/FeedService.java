package com.shinro.shinrojp_android.api;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FeedService {

    /**
     * Get data from services
    */

    @GET("/api/user")
    void getUserById(@Query("user_id") int user_id);

}
