package com.denztri.monitory233;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginCodeActivity extends AppCompatActivity {

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_code);

        Button masukBtn = findViewById(R.id.btnCheckCode);
        EditText txtCode = findViewById(R.id.edtInputCode);
        TextView txtAgree = findViewById(R.id.txtCheckCodeAgree);

        txtAgree.setText(Html.fromHtml(getString(R.string.check_code_text_agreement),Html.FROM_HTML_MODE_LEGACY));

        masukBtn.setOnClickListener(view -> {
            if(isCodeEmpty(txtCode.getText().toString())){
                showWarningMessage();
            } else {
                startActivity(new Intent(getApplicationContext(), BiodataActivity.class));
            }
        });

    }

    public boolean isCodeEmpty(String str){
        return "".equals(str);
    }

    public void showWarningMessage(){
        String emptyTitle =  getString(R.string.check_code_warning_empty_title);
        String emptyMessage = getString(R.string.check_code_warning_empty_desc);
        String warningTitle = getString(R.string.warning_title);

        // custom dialog
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_warning_dialog);
        dialog.setTitle(warningTitle);

        // set the custom dialog components - text, image and button
        TextView textTitle = (TextView) dialog.findViewById(R.id.txtWarningDialogTitle);
        TextView text = (TextView) dialog.findViewById(R.id.txtWarningDialogDesc);
        Button dialogButton = (Button) dialog.findViewById(R.id.btnWarningDialogOk);

        textTitle.setText(emptyTitle);
        text.setText(emptyMessage);

        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }
}