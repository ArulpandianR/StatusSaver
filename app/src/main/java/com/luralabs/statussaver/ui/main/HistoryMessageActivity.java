package com.luralabs.statussaver.ui.main;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.luralabs.statussaver.R;
import com.luralabs.statussaver.ui.main.notification.NotificationMessageFragment;

public class HistoryMessageActivity extends AppCompatActivity {

    String mobile;
    String name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_activity_main);
        setSupportActionBar(findViewById(R.id.toolbar));
        mobile = getIntent().getStringExtra("mobile");
        name = getIntent().getStringExtra("name");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        loadFragment(NotificationMessageFragment.newInstance(name, mobile));
    }

    private void loadFragment(Fragment selectedFragment) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.message_layout, selectedFragment);
        transaction.commitAllowingStateLoss();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.onBackPressed();
                break;
        }
        return true;
    }
}
