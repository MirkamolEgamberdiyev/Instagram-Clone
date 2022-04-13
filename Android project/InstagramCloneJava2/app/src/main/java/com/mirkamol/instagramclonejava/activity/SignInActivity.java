package com.mirkamol.instagramclonejava.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.mirkamol.instagramclonejava.R;
/*
 *In SignUpActivity, user can login using email, password
 */
public class SignInActivity extends BaseActivity {
    private static final String TAG = SignInActivity.class.toString();
    EditText et_email;
    EditText et_password;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        initViews();

    }

    private void initViews() {
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);

        TextView b_signin = findViewById(R.id.b_signin);
        b_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callMainActivity();
            }
        });

        TextView tv_signup = findViewById(R.id.tv_signup);
        tv_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callSignUpActivity();
            }
        });
    }

    private void callSignUpActivity() {
        Intent intent =new  Intent(this, SignUpActivity.class);
        startActivity(intent);
        finish();
    }

    private void callMainActivity() {
        Intent intent =new  Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}