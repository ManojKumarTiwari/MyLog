package com.theinfinitecoder.mylog;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private TextView welcomeTx, myLogTx;
    private EditText loginEmailEt, loginPassEt;
    private Button loginBtn, loginRegBtn;
    private ProgressBar loginProgressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        welcomeTx = (TextView) findViewById(R.id.login_welcome_tx);
        myLogTx = (TextView) findViewById(R.id.login_mylog_tx);
        loginEmailEt = (EditText) findViewById(R.id.login_email_et);
        loginPassEt = (EditText) findViewById(R.id.login_password_et);
        loginBtn = (Button) findViewById(R.id.login_login_btn);
        loginRegBtn = (Button) findViewById(R.id.login_reg_btn);
        loginProgressBar = (ProgressBar) findViewById(R.id.login_pb);

        mAuth = FirebaseAuth.getInstance();

        Typeface alexBrushRegular = Typeface.createFromAsset(getAssets(), "fonts/AlexBrush-Regular.ttf");
        Typeface robotoSlabLight = Typeface.createFromAsset(getAssets(), "fonts/RobotoSlab-Light.ttf");

        welcomeTx.setTypeface(robotoSlabLight);
        myLogTx.setTypeface(alexBrushRegular);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loginEmail = loginEmailEt.getText().toString();
                String loginPass = loginPassEt.getText().toString();

                if(!TextUtils.isEmpty(loginEmail) && !TextUtils.isEmpty(loginPass)){
                    loginProgressBar.setVisibility(View.VISIBLE);

                    mAuth.signInWithEmailAndPassword(loginEmail, loginPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){

                                sendToMain();

                            } else {

                                String errorMsg = task.getException().getMessage();
                                Toast.makeText(LoginActivity.this, "Error:" + errorMsg, Toast.LENGTH_LONG).show();
                            }

                            loginProgressBar.setVisibility(View.INVISIBLE);

                        }
                    });
                }
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser != null){

            sendToMain();

        }
    }

    private void sendToMain() {
        Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(mainIntent);
        finish();
    }
}
