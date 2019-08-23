package com.luralabs.statussaver.ui.base;


import androidx.fragment.app.Fragment;

import com.luralabs.statussaver.TheApplication;

public class BaseFragment extends Fragment {

    public TheApplication getTheApplication() {
        return ((TheApplication) getActivity().getApplication());
    }

}