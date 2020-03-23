package com.shinro.shinrojp_android.utils;

import android.app.Activity;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.bases.BaseDialog;

import static com.shinro.shinrojp_android.utils.Constants.SWIPE_MAX_OFF_PATH;
import static com.shinro.shinrojp_android.utils.Constants.SWIPE_MIN_DISTANCE;
import static com.shinro.shinrojp_android.utils.Constants.SWIPE_THRESHOLD_VELOCITY;

public class SwipeDetector extends GestureDetector.SimpleOnGestureListener {

    private Activity mActivity;

    public SwipeDetector(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

//        // Check movement along the Y-axis. If it exceeds SWIPE_MAX_OFF_PATH,
//        // then dismiss the swipe.
//        if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
//            return false;
//
//        // Swipe from left to right.
//        // The swipe needs to exceed a certain distance (SWIPE_MIN_DISTANCE)
//        // and a certain velocity (SWIPE_THRESHOLD_VELOCITY).
//        if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
//            BaseDialog dialog = new BaseDialog(mActivity);
//            dialog.setMessage(mActivity.getString(R.string.dialog_exit_app_title))
//                    .setPositiveButton(mActivity.getString(R.string.dialog_exit_app_positive_button), (dialog1, which) -> mActivity.finish())
//                    .setNegativeButton(mActivity.getString(R.string.dialog_exit_app_negative_button), (dialog2, which) -> dialog.dismissDialog())
//                    .setCancelable(true)
//                    .showDialog();
//            return true;
//        }
        return false;
    }

}
