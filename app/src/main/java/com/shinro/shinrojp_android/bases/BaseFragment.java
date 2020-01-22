package com.shinro.shinrojp_android.bases;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import io.reactivex.disposables.CompositeDisposable;

public class BaseFragment extends Fragment {

    private CompositeDisposable disposable = new CompositeDisposable();

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
            transaction.addToBackStack(backStateName);
            transaction.commit();
        }
    }

}
