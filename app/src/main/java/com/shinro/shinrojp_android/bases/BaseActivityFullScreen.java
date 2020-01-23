package com.shinro.shinrojp_android.bases;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.disposables.CompositeDisposable;

public class BaseActivityFullScreen extends AppCompatActivity {

    private CompositeDisposable disposable = new CompositeDisposable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }

    public void hideStatusBar() {
        if(Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            //getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
            supportRequestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
            getActionBar().hide();
        }else{
            View decorView = getWindow().getDecorView();
            // Hide the status bar.
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
            //getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
            supportRequestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
            getSupportActionBar().hide();
        }
    }

    protected void navigateActivity(Class classname) {
        Intent intent = new Intent(this, classname);
        startActivity(intent);
    }

    protected void navigateActivityForResult(Class classname, int request_code) {
        Intent intent = new Intent(this, classname);
        startActivityForResult(intent, request_code);
    }

    protected void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
