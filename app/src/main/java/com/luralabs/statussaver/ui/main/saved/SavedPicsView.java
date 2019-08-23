package com.luralabs.statussaver.ui.main.saved;

import com.luralabs.statussaver.data.model.ImageModel;
import com.luralabs.statussaver.ui.base.MvpView;

import java.util.List;

public interface SavedPicsView extends MvpView {
    void displayLoadingAnimation(boolean status);

    void displaySavedImages(List<ImageModel> images);

    void displayNoImagesInfo();

    void displayImage(int position, ImageModel imageModel);

    void displayDeleteSuccessMsg();

    void displayDeleteConfirm(List<ImageModel> imageModels);
}
