package com.shinro.shinrojp_android.bases;

import androidx.fragment.app.DialogFragment;

import io.reactivex.disposables.CompositeDisposable;

public class BaseDialogFragment extends DialogFragment {

    private CompositeDisposable disposable = new CompositeDisposable();

    @Override
    public void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }

}
