package com.shinro.shinrojp_android.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.bases.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onShowLoading();

        onHideLoading();
    }
}
