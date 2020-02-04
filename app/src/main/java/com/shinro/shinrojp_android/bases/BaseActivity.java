package com.shinro.shinrojp_android.bases;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.shashank.sony.fancytoastlib.FancyToast;
import com.shinro.shinrojp_android.utils.ProgressDialogUtils;

import io.reactivex.disposables.CompositeDisposable;

public class BaseActivity extends AppCompatActivity {

    private CompositeDisposable disposable = new CompositeDisposable();
    private ProgressDialog progressDialog;

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

    /**
     * Load fragment to container
     *
     * @param containerId R.id.
     * @param fragment fragment
     */
    protected void loadFragmentToContainer(int containerId, Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(containerId, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    protected void removeFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.remove(fragment);
        transaction.commit();
    }

    /**
     * Add fragment
     *
     * @param containerId R.id.
     * @param fragment fragment
     */
    protected void addFragment(int containerId, Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(containerId, fragment);
        transaction.addToBackStack(backStateName);
        transaction.commit();
    }

    /**
     * Replace fragment
     *
     * @param containerId R.id.
     * @param fragment fragment
     */
    protected void replaceFragment(int containerId, Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(containerId, fragment);
        transaction.addToBackStack(backStateName);
        transaction.commit();
    }

    /**
     * Pop fragment
     */
    protected Boolean popFragment() {
        int countStack = getSupportFragmentManager().getBackStackEntryCount();
        if (countStack > 1) {
            getSupportFragmentManager().popBackStack();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onBackPressed() {
        if (!popFragment()){
            super.onBackPressed();
        }
    }

    protected void navigateActivity(Class classname) {
        Intent intent = new Intent(this, classname);
        startActivity(intent);
    }

    protected void navigateActivity(Class classname, int option) {
        Intent intent = new Intent(this, classname);
        intent.setFlags(option);
        startActivity(intent);
    }

    protected void navigateActivity(Class classname, String k, int v, int option) {
        Intent intent = new Intent(this, classname);
        intent.putExtra(k, v);
        intent.setFlags(option);
        startActivity(intent);
    }

    protected void navigateActivityForResult(Class classname, int request_code) {
        Intent intent = new Intent(this, classname);
        startActivityForResult(intent, request_code);
    }

    protected void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    //FancyToast
    protected void showToast(String message) {
        FancyToast.makeText(this, message, FancyToast.LENGTH_SHORT, FancyToast.DEFAULT,true).show();
    }

    protected void showSuccessToast(String message) {
        FancyToast.makeText(this, message ,FancyToast.LENGTH_SHORT, FancyToast.SUCCESS,true).show();
    }

    protected void showInfoToast(String message) {
        FancyToast.makeText(this, message, FancyToast.LENGTH_SHORT, FancyToast.INFO,true).show();
    }

    protected void showWarningToast(String message) {
        FancyToast.makeText(this, message, FancyToast.LENGTH_SHORT, FancyToast.WARNING,true).show();
    }

    protected void showErrorToast(String message) {
        FancyToast.makeText(this, message, FancyToast.LENGTH_SHORT, FancyToast.ERROR,true).show();
    }

    protected void showConfusingToast(String message) {
        FancyToast.makeText(this, message, FancyToast.LENGTH_SHORT, FancyToast.CONFUSING,true).show();
    }

    protected void showCustomToastWithParam(String message, int duration, int type, boolean icon) {
        FancyToast.makeText(this, message, duration, type, icon).show();
    }

    protected void showCustomImageToastWithParam(String message, int duration, int type, int image, boolean icon) {
        FancyToast.makeText(this, message, duration, type, image, icon).show();
    }

    protected void showCustomToastWithoutIcon(String message, int duration, int type, int image) {
        FancyToast.makeText(this, message, duration, type, image, false);
    }

    protected void onShowLoading() {
        onHideLoading();
        progressDialog = ProgressDialogUtils.showLoadingDialog(this);
    }

    protected void onHideLoading() {
        if(progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            //progressDialog.cancel();
        }
    }

}
