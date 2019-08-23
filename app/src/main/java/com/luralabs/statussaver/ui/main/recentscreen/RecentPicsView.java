package com.luralabs.statussaver.ui.main.recentscreen;

import com.luralabs.statussaver.data.model.ImageModel;
import com.luralabs.statussaver.ui.base.MvpView;

import java.util.List;

public interface RecentPicsView extends MvpView{
    void displayLoadingAnimation(boolean status);
    void displayRecentImages(List<ImageModel> images);
    void displayNoImagesInfo();
    void displayImageSavedMsg();
    void displayImage(int position, ImageModel imageModel);
    void displayDeleteSuccessMsg();
    void displayStatusDeleteSuccessMsg();
    void displayDeleteConfirmPrompt(ImageModel imageModel, int itemPosition);
    void displayStatusDeleteConfirmPrompt(ImageModel imageModel, int itemPosition);
}
