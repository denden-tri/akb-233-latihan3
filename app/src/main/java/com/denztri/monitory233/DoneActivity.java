package com.denztri.monitory233;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);
        Button btnDone = findViewById(R.id.btnDoneNext);

        bindExtra();

        btnDone.setOnClickListener(view -> {
            Intent intent = new Intent(this, WelcomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("ID_EXTRA_MSG_EXIT", true);
            startActivity(intent);
        });
    }

    private void bindExtra(){
        TextView txtNama = findViewById(R.id.txtDoneTitle);
        String beres = getString(R.string.activation_beres);
        String sudahBisa = getString(R.string.activation_sudah_bisa);
        String setiap = getString(R.string.activation_setiap);
        String buat = getString(R.string.activation_buat);

        Intent intent = getIntent();
        String name = intent.getStringExtra(BiodataActivity.ID_EXTRA_MSG);
        txtNama.setText(String.format(getString(R.string.final_kalimat),beres, name,sudahBisa,setiap, buat));
    }
}