package com.quintaooh.thegamereminder.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.quintaooh.thegamereminder.R;

/**
 * Created by riccardo on 22/10/2018.
 */

public class SplashActivity extends GRActivity {
    private final int TTL = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(() -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }, TTL);
    }
}
