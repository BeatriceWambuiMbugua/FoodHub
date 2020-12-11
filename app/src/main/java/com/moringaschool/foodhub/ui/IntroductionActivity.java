package com.moringaschool.foodhub.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.moringaschool.foodhub.R;

public class IntroductionActivity extends AppCompatActivity {
    ImageView logo, splashImage, appName;
    LottieAnimationView lottieAnimationView;

    private static  final int NUM_PAGES = 3;
    private ViewPager  viewPager;
    private ScreenSlidePagerAdapter pagerAdapter;
    Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_introduction);

        logo = findViewById(R.id.logo);
        splashImage = findViewById(R.id.img);
        lottieAnimationView = findViewById(R.id.lottie);
        appName = findViewById(R.id.app_name);

        viewPager = findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);


        anim = AnimationUtils.loadAnimation(this, R.anim.o_anim);
        viewPager.startAnimation(anim);

        splashImage.animate().translationY(-2400).setDuration(1000).setStartDelay(4000);
        logo.animate().translationY(1800).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(1800).setDuration(1000).setStartDelay(4000);
        appName.animate().translationY(1800).setDuration(1000).setStartDelay(4000);


    }
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter{

        public ScreenSlidePagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0:
                    OnBoardingFragment1 onboardingFragment1 = new OnBoardingFragment1();
                    return onboardingFragment1;
                    case 1:
                    OnBoardingFragment2 onboardingFragment2 = new OnBoardingFragment2();
                    return onboardingFragment2;
                    case 2:
                    OnBoardingFragment3 onboardingFragment3 = new OnBoardingFragment3();
                    return onboardingFragment3;
            }
            return null;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}