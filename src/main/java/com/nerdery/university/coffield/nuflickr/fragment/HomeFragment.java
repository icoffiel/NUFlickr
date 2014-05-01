package com.nerdery.university.coffield.nuflickr.fragment;

import com.nerdery.university.coffield.nuflickr.R;
import com.nerdery.university.coffield.nuflickr.logging.Logger;
import com.nerdery.university.coffield.nuflickr.activity.BaseActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class HomeFragment extends BaseFragment {

    @Inject
    Logger mLogger;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.inject(this, view);
        ((BaseActivity) getActivity()).inject(this);

        return view;
    }
}
