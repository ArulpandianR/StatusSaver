package com.luralabs.statussaver.ui.imageslider.imagedetails;

import com.luralabs.statussaver.data.local.FileHelper;
import com.luralabs.statussaver.data.model.ImageModel;
import com.luralabs.statussaver.ui.base.BasePresenter;

import javax.inject.Inject;

public class ImageDetailsPresenter extends BasePresenter<ImageDetailsView> {

    private static final String TAG = ImageDetailsPresenter.class.getSimpleName();
    private final FileHelper fileHelper;

    @Inject
    public ImageDetailsPresenter(FileHelper fileHelper) {
        this.fileHelper = fileHelper;
    }

    void setLoadingAnimation(boolean status) {
        getMvpView().displayLoadingAnimation(status);
    }

    void saveMedia(ImageModel imageModel) {
        boolean status = fileHelper.saveMediaToLocalDir(imageModel);
        if (status) {
            getMvpView().displayImageSavedMsg();
        }
    }

    void deleteLocalImage(ImageModel imageModel) {
        boolean status = fileHelper.deleteImageFromLocalDir(imageModel);
        if (status) {
            getMvpView().displayDeleteSuccessMsg();
        }
    }

}
