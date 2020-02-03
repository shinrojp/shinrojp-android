package com.shinro.shinrojp_android.api;

import com.shinro.shinrojp_android.utils.Constants;

public class ApiUtil extends Constants {

    public static FeedService getFeedApiService(boolean isAuthorization, String token) {
        return RetrofitClient.getClient(BASE_URL_FEED, isAuthorization, token).create(FeedService.class);
    }

}
