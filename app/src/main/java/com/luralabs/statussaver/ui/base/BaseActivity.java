package com.luralabs.statussaver.ui.base;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.appcompat.app.AppCompatActivity;

import com.luralabs.statussaver.TheApplication;

public class BaseActivity extends AppCompatActivity {


    public TheApplication getTheApplication() {
        return ((TheApplication) getApplication());
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }
}