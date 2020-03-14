package com.shinro.shinrojp_android.bases;

import android.app.ProgressDialog;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.shashank.sony.fancytoastlib.FancyToast;
import com.shinro.shinrojp_android.utils.ProgressDialogUtils;

import io.reactivex.disposables.CompositeDisposable;

public class BaseFragment extends Fragment {

    private CompositeDisposable disposable = new CompositeDisposable();
    private ProgressDialog progressDialog;

    @Override
    public void onDestroy() {
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
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(containerId, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
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
        if(getActivity() != null) {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(containerId, fragment);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.addToBackStack(backStateName);
            transaction.commit();
        }
    }

    /**
     * Add fragment
     *
     * @param containerId R.id.
     * @param fragment fragment
     */
    protected void addFragment(int containerId, Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        if(getActivity() != null) {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(containerId, fragment);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.addToBackStack(backStateName);
            transaction.commit();
        }
    }

    /**
     * Replace fragment from fragment
     *
     * @param fragment fragment
     */
    protected void replaceFragmentFromFragment(Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        int containerId = ((ViewGroup) getView().getParent()).getId();
        if(getActivity() != null) {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(containerId, fragment);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.addToBackStack(backStateName);
            transaction.commit();
        }
    }

    /**
     * Show progress dialog
     */
    protected void onShowLoading() {
        onHideLoading();
        progressDialog = ProgressDialogUtils.showLoadingDialog(getContext());
    }

    /**
     * Hide progress dialog
     */
    protected void onHideLoading() {
        if(progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            //progressDialog.cancel();
        }
    }
    protected void navigateActivity(Class classname) {
        Intent intent = new Intent(getActivity(), classname);
        startActivity(intent);
    }

}
