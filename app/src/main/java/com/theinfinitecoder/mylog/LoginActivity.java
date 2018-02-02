package com.theinfinitecoder.mylog;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView welcomeTx = (TextView) findViewById(R.id.login_welcome_tx);
        TextView myLogTx = (TextView) findViewById(R.id.login_mylog_tx);

        Typeface alexBrushRegular = Typeface.createFromAsset(getAssets(), "fonts/AlexBrush-Regular.ttf");
        welcomeTx.setTypeface(alexBrushRegular);

        Typeface robotoSlabLight = Typeface.createFromAsset(getAssets(), "fonts/RobotoSlab-Light.ttf");
        myLogTx.setTypeface(robotoSlabLight);
    }
}
