package com.denztri.monitory233;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        if (getIntent().getBooleanExtra("ID_EXTRA_MSG_EXIT", false)) {
            finish();
        }

        Button walkStart = findViewById(R.id.btnWalkthroughStart);
        walkStart.setOnClickListener(view -> startActivity(new Intent(this, LoginCodeActivity.class)));
    }

}