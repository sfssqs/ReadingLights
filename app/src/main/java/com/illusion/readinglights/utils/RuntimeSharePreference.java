package com.illusion.readinglights.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class RuntimeSharePreference {
    private static final String TAG = "RuntimeSharePreference";

    public static final String FLAG_IS_OPEN_LONG_LIGHT = "long_light_flag";

    private static final String SHARED_PATH = "app_info";

    private static RuntimeSharePreference sInstance;
    private SharedPreferences sharedPreferences;

    private RuntimeSharePreference(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PATH, Context.MODE_PRIVATE);
    }

    public static RuntimeSharePreference getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new RuntimeSharePreference(context);
        }

        return sInstance;
    }

    public void putInt(String key, int value) {
        Editor edit = sharedPreferences.edit();
        edit.putInt(key, value);
        edit.apply();
    }

    public int getInt(String key) {
        return sharedPreferences.getInt(key, 0);
    }

    public void putString(String key, String value) {
        Editor edit = sharedPreferences.edit();
        edit.putString(key, value);
        edit.apply();
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, null);
    }

    public void putBoolean(String key, boolean value) {
        Editor edit = sharedPreferences.edit();
        edit.putBoolean(key, value);
        edit.apply();
    }

    public boolean getBoolean(String key, boolean defValue) {
        return sharedPreferences.getBoolean(key, defValue);
    }

    public int getInt(String key, int defValue) {
        return sharedPreferences.getInt(key, defValue);
    }

    public void remove(String key) {
        Editor edit = sharedPreferences.edit();
        edit.remove(key);
        edit.apply();
    }
}
