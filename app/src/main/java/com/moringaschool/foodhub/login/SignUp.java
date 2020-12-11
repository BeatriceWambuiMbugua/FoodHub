package com.moringaschool.foodhub.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.moringaschool.foodhub.R;
import com.moringaschool.foodhub.ui.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.button1)
    Button mCreateUserButton;
    @BindView(R.id.email1)
    EditText mEmail;
    @BindView(R.id.fullname)
    EditText mFullname;
    @BindView(R.id.password2)
    EditText mPassword;
    @BindView(R.id.confirmpassword)
    EditText mConfirm;
    @BindView(R.id.loginTextView)
    TextView mLoginTextView;
    float v=0;
    private FirebaseAuth mAuth;
    public static final String TAG = SignUp.class.getSimpleName();
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

        mCreateUserButton.setOnClickListener(this);
        mLoginTextView.setOnClickListener(this);

        createAuthStateListener();

        mAuth = FirebaseAuth.getInstance();


        mEmail.setTranslationX(800);
        mPassword.setTranslationX(800);
        mFullname.setTranslationX(800);
        mConfirm.setTranslationX(800);
        mCreateUserButton.setTranslationX(800);

        mEmail.setAlpha(v);
        mPassword.setAlpha(v);
       mConfirm.setAlpha(v);
        mFullname.setAlpha(v);
        mCreateUserButton.setAlpha(v);


       mEmail.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        mPassword.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        mConfirm.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        mFullname.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        mCreateUserButton.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();

    }

    private void createAuthStateListener() {
        mAuthListener = firebaseAuth -> {
            final FirebaseUser user = firebaseAuth.getCurrentUser();
            if (user != null) {
                Intent intent = new Intent(SignUp.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        };
    }


    @Override
    public void onClick(View view) {
        {

            if (view == mLoginTextView) {
                Intent intent = new Intent(SignUp.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }

            if (view == mCreateUserButton) {
                createNewUser();
            }

        }
    }

    private void createNewUser() {
        final String name = mFullname.getText().toString().trim();
        final String email = mEmail.getText().toString().trim();
        String password = mPassword.getText().toString().trim();
        String confirmPassword = mConfirm.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "Authentication successful");
                        } else {
                            Toast.makeText(SignUp.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

}
