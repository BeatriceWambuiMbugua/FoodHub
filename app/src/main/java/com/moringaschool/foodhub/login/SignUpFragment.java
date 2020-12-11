package com.moringaschool.foodhub.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.moringaschool.foodhub.R;


public class SignUpFragment extends Fragment {

    EditText email, password, fullname, confirmpassword;
    Button signup;
    float v=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);

        email = root.findViewById(R.id.email1);
        password = root.findViewById(R.id.password2);
        fullname = root.findViewById(R.id.fullname);
        confirmpassword = root.findViewById(R.id.confirmpassword);
        signup = root.findViewById(R.id.button1);

        email.setTranslationX(800);
        password.setTranslationX(800);
        fullname.setTranslationX(800);
        confirmpassword.setTranslationX(800);
        signup.setTranslationX(800);

        email.setAlpha(v);
        password.setAlpha(v);
        confirmpassword.setAlpha(v);
        fullname.setAlpha(v);
        signup.setAlpha(v);


        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        confirmpassword.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        fullname.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        signup.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();

        return root;
    }
}
