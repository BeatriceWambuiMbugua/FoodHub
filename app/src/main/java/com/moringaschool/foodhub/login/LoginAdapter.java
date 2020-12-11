package com.moringaschool.foodhub.login;

import android.content.Context;
import android.util.Log;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class LoginAdapter extends FragmentPagerAdapter {

    private Context context;
    int totalTabs;
    private static final String TAG = LoginAdapter.class.getSimpleName();

    public LoginAdapter(FragmentManager fm, Context context, int totalTabs) {
        super(fm);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    @Override
    public int getCount() {
        return totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Log.d(TAG, "Successful");
                LoginFragment loginfragment = new LoginFragment();
                return loginfragment;

            case 1:
                SignUpFragment signupfragment = new SignUpFragment();
                return signupfragment;

            default:
                return null;
        }
    }

}
