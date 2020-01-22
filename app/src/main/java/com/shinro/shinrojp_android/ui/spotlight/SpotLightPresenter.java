package com.shinro.shinrojp_android.ui.spotlight;

public class SpotLightPresenter implements SpotLightContract.Presenter {

    private SpotLightContract.View mView;

    public SpotLightPresenter(SpotLightContract.View mView) {
        this.mView = mView;
    }

}
