package com.luralabs.statussaver.ui.imageslider;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.luralabs.statussaver.data.model.ImageModel;
import com.luralabs.statussaver.ui.imageslider.imagedetails.ImageDetailsFragment;

import java.util.List;


public class CustomViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<ImageModel> items;
    // Image types available in ImageSliderActivity
    private int imageType;

    public CustomViewPagerAdapter(FragmentManager fm, List<ImageModel> items, int imageType) {
        super(fm);
        this.items = items;
        this.imageType = imageType;
    }

    public void removeItem(int position) {
        items.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return ImageDetailsFragment.newInstance(items.get(position), imageType);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
