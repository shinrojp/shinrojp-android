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
     * Set title for dialog
     * @param titleId
     * @return
     */
    public BaseDialog setTitle(int titleId) {
        dialogBuilder.setTitle(titleId);
        return this;
    }

    /**
     * Set title for dialog
     * @param title
     * @return
     */
    public BaseDialog setTitle(CharSequence title) {
        if (title == null) {
            return this;
        }
        dialogBuilder.setTitle(title);
        return this;
    }

    /**
     * Set message for dialog
     * @param messageId
     * @return
     */
    public BaseDialog setMessage(int messageId) {
        dialogBuilder.setMessage(messageId);
        return this;
    }

    /**
     * Set message for dialog
     * @param message
     * @return
     */
    public BaseDialog setMessage(CharSequence message) {
        if (message == null) {
            return this;
        }
        dialogBuilder.setMessage(message);
        return this;
    }

    /**
     * Set positive button for dialog
     * @param textId
     * @param listener
     * @return
     */
    public BaseDialog setPositiveButton(int textId, DialogInterface.OnClickListener listener) {
        dialogBuilder.setPositiveButton(textId, listener);
        return this;
    }

    /**
     * Set positive button for dialog
     * @param text
     * @param listener
     * @return
     */
    public BaseDialog setPositiveButton(CharSequence text, DialogInterface.OnClickListener listener) {
        dialogBuilder.setPositiveButton(text, listener);
        return this;
    }

    /**
     * Set negative button for dialog
     * @param textId
     * @param listener
     * @return
     */
    public BaseDialog setNegativeButton(int textId, DialogInterface.OnClickListener listener) {
        dialogBuilder.setNegativeButton(textId, listener);
        return this;
    }

    /**
     * Set negative button for dialog
     * @param text
     * @param listener
     * @return
     */
    public BaseDialog setNegativeButton(CharSequence text, DialogInterface.OnClickListener listener) {
        dialogBuilder.setNegativeButton(text, listener);
        return this;
    }

    /**
     * Set neutral button for dialog
     * @param textId
     * @param listener
     * @return
     */
    public BaseDialog setNeutralButton(int textId, DialogInterface.OnClickListener listener) {
        dialogBuilder.setNeutralButton(textId, listener);
        return this;
    }

    /**
     * Set neutral button for dialog
     * @param text
     * @param listener
     * @return
     */
    public BaseDialog setNeutralButton(CharSequence text, DialogInterface.OnClickListener listener) {
        dialogBuilder.setNeutralButton(text, listener);
        return this;
    }

    /**
     * Set cancelable for dialog
     * @param cancelable
     * @return
     */
    public BaseDialog setCancelable(Boolean cancelable) {
        if (cancelable == null) {
            return this;
        }
        dialogBuilder.setCancelable(cancelable);
        return this;
    }

    /**
     * Show dialog
     * @return
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
     * Dismiss dialog
     */
    public void dismissDialog() {
        try {
            dialog.dismiss();
        } catch (Exception e) {
            AppLogger.e(e);
        }
    }

}
