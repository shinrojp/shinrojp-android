package com.shinro.shinrojp_android.bases;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class BaseActivity extends AppCompatActivity {

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
    }

    // TODO: 1/22/2020
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

    protected void navigateActivityForResult(Class classname, int request_code) {
        Intent intent = new Intent(this, classname);
        startActivityForResult(intent, request_code);
    }

    protected void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
