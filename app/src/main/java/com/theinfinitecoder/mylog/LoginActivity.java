package com.theinfinitecoder.mylog;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    TextView welcomeTx,myLogTx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        welcomeTx = (TextView) findViewById(R.id.login_welcome_tx);
        myLogTx = (TextView) findViewById(R.id.login_mylog_tx);

        Typeface alexBrushRegular = Typeface.createFromAsset(getAssets(), "fonts/AlexBrush-Regular.ttf");
        Typeface robotoSlabLight = Typeface.createFromAsset(getAssets(), "fonts/RobotoSlab-Light.ttf");

        welcomeTx.setTypeface(robotoSlabLight);
        myLogTx.setTypeface(alexBrushRegular);

    }
}
