package com.shinro.shinrojp_android.bases;

public class BaseContract {

    public interface View<T extends Presenter> {
        void setPresenter(T presenter);
    }

    public interface Presenter {
        void start();
        void stop();
    }

}
