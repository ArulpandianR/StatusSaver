package com.luralabs.statussaver.injection.component;


import com.luralabs.statussaver.data.local.FileHelper;
import com.luralabs.statussaver.injection.module.AppModule;
import com.luralabs.statussaver.ui.imageslider.ImageSliderActivity;
import com.luralabs.statussaver.ui.imageslider.imagedetails.ImageDetailsFragment;
import com.luralabs.statussaver.ui.main.MainActivity;
import com.luralabs.statussaver.ui.main.recentscreen.RecentPicsFragment;
import com.luralabs.statussaver.ui.main.saved.SavedPicsFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(MainActivity activity);
    void inject(RecentPicsFragment fragment);
    void inject(SavedPicsFragment fragment);
    void inject(ImageSliderActivity activity);
    void inject(ImageDetailsFragment fragment);
    FileHelper fileHelper();
}
