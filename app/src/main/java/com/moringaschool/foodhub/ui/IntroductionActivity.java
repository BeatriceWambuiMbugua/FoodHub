package com.moringaschool.foodhub.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.moringaschool.foodhub.R;

public class IntroductionActivity extends AppCompatActivity {
    ImageView logo, splashImage, appName;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_introduction);

        logo = findViewById(R.id.logo);
        splashImage = findViewById(R.id.img);
        lottieAnimationView = findViewById(R.id.lottie);
        appName = findViewById(R.id.app_name);

        splashImage.animate().translationY(-2400).setDuration(1000).setStartDelay(4000);
        logo.animate().translationY(1800).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(1800).setDuration(1000).setStartDelay(4000);
        appName.animate().translationY(1800).setDuration(1000).setStartDelay(4000);



    }
}