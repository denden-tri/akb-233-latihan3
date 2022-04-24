package com.denztri.monitory233;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

//  NIM                 : 10119233
//  Nama                : Denden Triana
//  Kelas               : IF-6
//  Tanggal Pengerjaan  : 23-04-2022
//  Deskripsi Pekerjaan : 1. Mengerjakan logic agar dapat berpindah dari WelcomeActivity ke
//                           LoginCodeActivity
//                        2. Membuat logic agar menutup semua activity jika mengklik tombol Done
//                           pada DoneActivity
//                        3. Mengerjakan logic agar dapat berpindah dari LoginCodeActivity ke
//                           BiodataActivity
//                        4. Membuat logic agar menampilkan dialog message jika TextInput Code nya
//                           kosong/belum diisi
//                        5. Mengerjakan logic agar dapat berpindah dari BiodataActivity ke
//                           DoneActivity
//                        6. Membuat logic agar DoneActivity dapat menerima data dari BiodataActivity
//                           agar dapat ditampilkan pada DoneActivity
//                        7. Membuat logic agar menampilkan dialog message jika TextInput Name pada
//                           BiodataActivity kosong/belum diisi


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