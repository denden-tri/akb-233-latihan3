package com.denztri.monitory233;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BiodataActivity extends AppCompatActivity {

    public static final String ID_EXTRA_MSG = "com.denztri.monitory233.MSG";
    final Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);
        EditText edtName = findViewById(R.id.edtBiodataName);

        Button btnNext = findViewById(R.id.btnBiodataNext);
        btnNext.setOnClickListener(view -> {
            String nameBiodata = edtName.getText().toString();
            if (isStringEmpty(nameBiodata)) {
                showWarningMessage();
            } else {
                Intent intent = new Intent(this, DoneActivity.class);
                intent.putExtra(ID_EXTRA_MSG, nameBiodata);
                startActivity(intent);
            }
        });

    }

    public static boolean isStringEmpty(String str) {
        return "".equals(str);
    }

    public void showWarningMessage(){
        String emptyTitle =  getString(R.string.check_code_warning_empty_title_name);
        String emptyMessage = getString(R.string.check_code_warning_empty_desc_name);
        String warningTitle = getString(R.string.warning_title);
        // custom dialog
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_warning_dialog);
        dialog.setTitle(warningTitle);

        // set the custom dialog components - text, image and button
        TextView textTitle = (TextView) dialog.findViewById(R.id.txtWarningDialogTitle);
        TextView textDesc = (TextView) dialog.findViewById(R.id.txtWarningDialogDesc);
        Button dialogButton = (Button) dialog.findViewById(R.id.btnWarningDialogOk);

        textTitle.setText(emptyTitle);
        textDesc.setText(emptyMessage);

        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }

}