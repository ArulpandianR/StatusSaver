package com.luralabs.statussaver.ui.imageslider;


import com.luralabs.statussaver.data.model.ImageModel;
import com.luralabs.statussaver.ui.base.MvpView;

import java.util.List;

public interface ImageSliderView extends MvpView {
    void displayLoadingAnimation(boolean status);
    void displayImageSlider(List<ImageModel> mediaItems, int imageToDisplayPosition);
}
