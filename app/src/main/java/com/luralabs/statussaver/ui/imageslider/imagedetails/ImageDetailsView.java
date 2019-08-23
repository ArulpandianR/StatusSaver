package com.luralabs.statussaver.ui.imageslider.imagedetails;


import com.luralabs.statussaver.ui.base.MvpView;

public interface ImageDetailsView extends MvpView {
    void displayLoadingAnimation(boolean status);
    void displayImageSavedMsg();
    void displayDeleteSuccessMsg();
}
