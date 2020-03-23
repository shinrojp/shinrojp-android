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

    public static final String BASE_URL_LEARN = BuildConfig.BASE_URL_LEARN;

    public static final String NHK_API_KEY = BuildConfig.NHK_API_KEY;

    //Api Option
    public static final long READ_TIMEOUT = 60;

    public static final int WRITE_TIMEOUT = 60;

    public static final int CONNECT_TIMEOUT = 60;

    public static final String SYSTEM_DATE = CommonUtils.getSystemDate();

    //BaseActivity
    public static final int SWIPE_MIN_DISTANCE = 120;

    public static final int SWIPE_MAX_OFF_PATH = 250;

    public static final int SWIPE_THRESHOLD_VELOCITY = 200;

}
