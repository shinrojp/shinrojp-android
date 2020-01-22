package com.shinro.shinrojp_android.utils;

import timber.log.Timber;

public class AppLogger {

    public static void d(String s, Object...object) {
        Timber.d(s, object);
    }

    public static void d(Throwable throwable, String s, Object...object) {
        Timber.d(throwable, s, object);
    }

    public static void d(Throwable throwable) {
        Timber.d(throwable);
    }

    public static void i(String s, Object...object) {
        Timber.i(s, object);
    }

    public static void i(Throwable throwable, String s, Object...object) {
        Timber.i(throwable, s, object);
    }

    public static void i(Throwable throwable) {
        Timber.i(throwable);
    }

    public static void w(String s, Object...object) {
        Timber.w(s, object);
    }

    public static void w(Throwable throwable, String s, Object...object) {
        Timber.w(throwable, s, object);
    }

    public static void w(Throwable throwable) {
        Timber.w(throwable);
    }

    public static void e(String s, Object...object) {
        Timber.e(s, object);
    }

    public static void e(Throwable throwable, String s, Object...object) {
        Timber.e(throwable, s, object);
    }

    public static void e(Throwable throwable) {
        Timber.e(throwable);
    }

}
