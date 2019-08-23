package com.luralabs.statussaver;

import android.app.Application;

import com.luralabs.statussaver.injection.component.AppComponent;
import com.luralabs.statussaver.injection.component.DaggerAppComponent;
import com.luralabs.statussaver.injection.module.AppModule;


public class TheApplication extends Application {

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}