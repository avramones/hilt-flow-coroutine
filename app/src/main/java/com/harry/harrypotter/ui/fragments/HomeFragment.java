package com.harry.harrypotter.ui.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.harry.harrypotter.R;
import com.harry.harrypotter.ui.MainActivity;
import com.harry.harrypotter.utils.AppConstants;

import org.jetbrains.annotations.NotNull;


import androidx.fragment.app.Fragment;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends Fragment implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.button_1).setOnClickListener(this);
        view.findViewById(R.id.button_2).setOnClickListener(this);
        view.findViewById(R.id.button_3).setOnClickListener(this);
        view.findViewById(R.id.button_4).setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        String house = "";
        switch (v.getId()) {
            case R.id.button_1:
                house = AppConstants.GRYFFINDOR;
                break;
            case R.id.button_2:
                house = AppConstants.HUFFLEPUFF;
                break;
            case R.id.button_3:
                house = AppConstants.RAVENCLAW;
                break;
            case R.id.button_4:
                house = AppConstants.SLYTHERIN;
                break;
        }
        bundle.putString(AppConstants.HOUSE, house);
        ((MainActivity) requireActivity()).navController
                .navigate(R.id.action_homeFragment_to_personFragment, bundle);
    }


}

