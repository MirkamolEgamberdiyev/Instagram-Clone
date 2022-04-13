package com.mirkamol.instagramclonejava.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mirkamol.instagramclonejava.R;

public class SignUpActivity extends BaseActivity {
    String TAG = SignUpActivity.class.getSimpleName();
    EditText et_email;
    EditText et_password;
    EditText et_fullname;
    EditText et_cpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initViews();

    }

    private void initViews() {

        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        et_cpassword = findViewById(R.id.et_cpassword);
        et_fullname = findViewById(R.id.et_fullname);

        Button b_signup = findViewById(R.id.b_signup);

        b_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        TextView tv_signUp = findViewById(R.id.tv_signup);
        tv_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}