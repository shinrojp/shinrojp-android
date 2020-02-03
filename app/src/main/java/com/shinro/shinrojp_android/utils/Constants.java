package com.shinro.shinrojp_android.utils;

import com.shinro.shinrojp_android.BuildConfig;

public class Constants {

    public static final int SPLASH_TIME_OUT  = 3000;

    //Database and Preference
    public static final String PREF_NAME = "shinrojp_pref";

    public static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public static final int PRIVATE_MODE = 0;

    public static final String DB_NAME = "shinrojp";

    //Retrofit
    public static final String BASE_URL_FEED = BuildConfig.BASE_URL;

    public static final String NHK_API_KEY = BuildConfig.NHK_API_KEY;

    //Api Option
    public static final long READ_TIMEOUT = 60;

    public static final int WRITE_TIMEOUT = 60;

    public static final int CONNECT_TIMEOUT = 60;




}
