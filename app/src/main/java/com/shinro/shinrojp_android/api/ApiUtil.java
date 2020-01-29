package com.shinro.shinrojp_android.api;

import com.shinro.shinrojp_android.utils.Constants;

public class ApiUtil extends Constants {

    public static FeedService getApiFeedService getFeedApiService(boolean isAuthorization) {
        return RetrofitClient.getClient(BASE_URL, isAuthorization).create(FeedService.class);
    }

}
