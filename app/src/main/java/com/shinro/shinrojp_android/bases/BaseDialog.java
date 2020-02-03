package com.shinro.shinrojp_android.bases;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.shinro.shinrojp_android.utils.AppLogger;

public class BaseDialog {

    private Context mContext;

    private MaterialAlertDialogBuilder dialogBuilder;

    private AlertDialog dialog;

    public BaseDialog(Context mContext) {
        this.mContext = mContext;
        dialogBuilder = new MaterialAlertDialogBuilder(mContext);
    }

    /**
     * Set title
     */
    public BaseDialog setTitle(int titleId) {
        dialogBuilder.setTitle(titleId);
        return this;
    }

    /**
     * Set title
     */
    public BaseDialog setTitle(CharSequence title) {
        if (title == null) {
            return this;
        }
        dialogBuilder.setTitle(title);
        return this;
    }

    /**
     * Set message
     */
    public BaseDialog setMessage(int messageId) {
        dialogBuilder.setMessage(messageId);
        return this;
    }

    /**
     * Set message
     */
    public BaseDialog setMessage(CharSequence message) {
        if (message == null) {
            return this;
        }
        dialogBuilder.setMessage(message);
        return this;
    }

    /**
     * Set Positive Button
     */
    public BaseDialog setPositiveButton(int textId, DialogInterface.OnClickListener listener) {
        dialogBuilder.setPositiveButton(textId, listener);
        return this;
    }

    /**
     * Set Positive Button
     */
    public BaseDialog setPositiveButton(CharSequence text, DialogInterface.OnClickListener listener) {
        dialogBuilder.setPositiveButton(text, listener);
        return this;
    }

    /**
     * Set Negative Button
     */
    public BaseDialog setNegativeButton(int textId, DialogInterface.OnClickListener listener) {
        dialogBuilder.setNegativeButton(textId, listener);
        return this;
    }

    /**
     * Set Negative Button
     */
    public BaseDialog setNegativeButton(CharSequence text, DialogInterface.OnClickListener listener) {
        dialogBuilder.setNegativeButton(text, listener);
        return this;
    }

    /**
     * Set Neutral Button
     */
    public BaseDialog setNeutralButton(int textId, DialogInterface.OnClickListener listener) {
        dialogBuilder.setNeutralButton(textId, listener);
        return this;
    }

    /**
     * Set Neutral Button
     */
    public BaseDialog setNeutralButton(CharSequence text, DialogInterface.OnClickListener listener) {
        dialogBuilder.setNeutralButton(text, listener);
        return this;
    }

    /**
     * Set Cancelable
     */
    public BaseDialog setCancelable(Boolean cancelable) {
        if (cancelable == null) {
            return this;
        }
        dialogBuilder.setCancelable(cancelable);
        return this;
    }

    /**
     * Show
     */
    public AlertDialog showDialog() {
        try {
            dialog = dialogBuilder.show();
            return dialog;
        } catch (Exception e) {
            AppLogger.e(e);
            return null;
        }
    }

    /**
     * Dismiss
     */
    public void dismissDialog() {
        try {
            dialog.dismiss();
        } catch (Exception e) {
            AppLogger.e(e);
        }
    }

}
