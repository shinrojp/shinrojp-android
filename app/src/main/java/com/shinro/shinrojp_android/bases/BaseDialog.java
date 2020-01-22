package com.shinro.shinrojp_android.bases;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.shinro.shinrojp_android.utils.AppLogger;

public class BaseDialog {

    private Context mContext;

    private AlertDialog.Builder dialogBuilder;

    private AlertDialog dialog;

    public BaseDialog(Context mContext) {
        this.mContext = mContext;
        dialogBuilder = new AlertDialog.Builder(mContext);
    }

    /**
     * Set title
     */
    protected BaseDialog setTitle(int titleId) {
        dialogBuilder.setTitle(titleId);
        return this;
    }

    /**
     * Set title
     */
    protected BaseDialog setTitle(CharSequence title) {
        if (title == null) {
            return this;
        }
        dialogBuilder.setTitle(title);
        return this;
    }

    /**
     * Set message
     */
    protected BaseDialog setMessage(int messageId) {
        dialogBuilder.setMessage(messageId);
        return this;
    }

    /**
     * Set message
     */
    protected BaseDialog setMessage(CharSequence message) {
        if (message == null) {
            return this;
        }
        dialogBuilder.setMessage(message);
        return this;
    }

    /**
     * Set Positive Button
     */
    protected BaseDialog setPositiveButton(int textId, DialogInterface.OnClickListener listener) {
        dialogBuilder.setPositiveButton(textId, listener);
        return this;
    }

    /**
     * Set Positive Button
     */
    protected BaseDialog setPositiveButton(CharSequence text, DialogInterface.OnClickListener listener) {
        dialogBuilder.setPositiveButton(text, listener);
        return this;
    }

    /**
     * Set Negative Button
     */
    protected BaseDialog setNegativeButton(int textId, DialogInterface.OnClickListener listener) {
        dialogBuilder.setNegativeButton(textId, listener);
        return this;
    }

    /**
     * Set Negative Button
     */
    protected BaseDialog setNegativeButton(CharSequence text, DialogInterface.OnClickListener listener) {
        dialogBuilder.setNegativeButton(text, listener);
        return this;
    }

    /**
     * Set Cancelable
     */
    protected BaseDialog setCancelable(Boolean cancelable) {
        if (cancelable == null) {
            return this;
        }
        dialogBuilder.setCancelable(cancelable);
        return this;
    }

    /**
     * Show
     */
    protected AlertDialog showDialog() {
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
    protected void dismissDialog() {
        try {
            dialog.dismiss();
        } catch (Exception e) {
            AppLogger.e(e);
        }
    }

}
