package com.illusion.readinglights.utils;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.os.PowerManager;
import android.view.WindowManager;

public class ScreenUtils {
    public static final String WAKE_LOCK_TAG = "ReadingLight:MyWakeLockTag";

    public static void keepScreenOn(Activity activity) {
        boolean isKeepScreenOn = RuntimeSharePreference.getInstance(activity)
                .getBoolean(RuntimeSharePreference.FLAG_IS_OPEN_LONG_LIGHT, true);

        if (isKeepScreenOn) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        } else {
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }
    }

    @Deprecated
    public static void openWakeLock(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService(Service.POWER_SERVICE);

        PowerManager.WakeLock wakeLock = powerManager.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK,
                WAKE_LOCK_TAG);
        wakeLock.setReferenceCounted(false);
        wakeLock.acquire();
    }

    @Deprecated
    public static void closeWakeLock(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService(Service.POWER_SERVICE);

        PowerManager.WakeLock wakeLock =
                powerManager.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, WAKE_LOCK_TAG);
        wakeLock.setReferenceCounted(false);
        wakeLock.release();
    }
}
