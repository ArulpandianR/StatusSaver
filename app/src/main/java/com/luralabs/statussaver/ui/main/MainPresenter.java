package com.luralabs.statussaver.ui.main;

import com.luralabs.statussaver.ui.base.BasePresenter;

import javax.inject.Inject;

public class MainPresenter extends BasePresenter<MainView> {

    private static final String TAG = MainPresenter.class.getSimpleName();

    @Inject
    public MainPresenter() {
    }

    void loadWelcomeMessage() {
        getMvpView().displayWelcomeMessage("Hello world!");
    }

    void setLoadingAnimation(boolean status) {
        getMvpView().displayLoadingAnimation(status);
    }

    void loadRecentAndSavedPics() {
        getMvpView().displayRecentAndSavedPics();
    }

}
