package com.luralabs.statussaver.ui.main;


import com.luralabs.statussaver.ui.base.MvpView;

public interface MainView extends MvpView {
    void displayWelcomeMessage(String msg);
    void displayLoadingAnimation(boolean status);
    void displayRecentAndSavedPics();
}
