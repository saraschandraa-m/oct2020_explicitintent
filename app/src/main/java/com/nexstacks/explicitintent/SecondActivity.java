package com.nexstacks.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView mTvEmailAddress = findViewById(R.id.tv_email_address);
        TextView mTvUserName = findViewById(R.id.tv_user_name);
        final EditText mEtEmailAddress = findViewById(R.id.et_email_address_2);
        final EditText mEtUserName = findViewById(R.id.et_user_name_2);

        Button mbtnEdit = findViewById(R.id.btn_edit);
        Button mbtnCancel = findViewById(R.id.btn_cancel);

        Bundle data = getIntent().getExtras();

        if (data != null) {
            String emailAddress = data.getString("EMAILADDRESS");
            String username = data.getString("USERNAME");

            mTvEmailAddress.setText(emailAddress);
            mTvUserName.setText(username);

            mEtEmailAddress.setText(emailAddress);
            mEtUserName.setText(username);
        }

        mbtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });

        mbtnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editedEmail = mEtEmailAddress.getText().toString();
                String editedUsername = mEtUserName.getText().toString();

                Intent returnIntent = new Intent();
                returnIntent.putExtra("EDITED_EMAIL", editedEmail);
                returnIntent.putExtra("EDITED_USERNAME", editedUsername);
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}