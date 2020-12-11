package com.moringaschool.foodhub.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.moringaschool.foodhub.R;
import com.moringaschool.foodhub.login.LoginActivity;
import com.moringaschool.foodhub.login.SignUp;

public class OnBoardingFragment3 extends Fragment {

   FloatingActionButton fab;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.onboarding_fragment3, container, false);

        fab = root.findViewById(R.id.fab);

        fab.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        });
        return root;
    }
}
