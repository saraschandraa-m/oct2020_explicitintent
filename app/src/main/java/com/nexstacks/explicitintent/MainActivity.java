package com.nexstacks.explicitintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEtEmailAddress;
    private EditText mEtUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEtEmailAddress = findViewById(R.id.et_email_address);
        mEtUsername = findViewById(R.id.et_user_name);

//        mEtUsername.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent secondintent = new Intent(getApplicationContext(), SecondActivity.class);
//            }
//        });


    }

    public void moveToSecondScreen(View view) {
//        Toast.makeText(MainActivity.this, "Button Clicked", Toast.LENGTH_LONG).show();
        String emailaddress = mEtEmailAddress.getText().toString();
        String username = mEtUsername.getText().toString();

        String url = "http://google.com/search?&q=".concat(emailaddress);


        Intent secondintent = new Intent(MainActivity.this, SecondActivity.class);
        secondintent.putExtra("EMAILADDRESS", emailaddress);
        secondintent.putExtra("USERNAME", username);
        secondintent.putExtra("BOOLEANSAMPLE", true);
        secondintent.putExtra("INTEGERSAMPLE", 0);
        startActivity(secondintent);
    }

    public void moveToSecondScreenWithResult(View view){
        String emailAddress = mEtEmailAddress.getText().toString();
        String username = mEtUsername.getText().toString();

        if(emailAddress.isEmpty() || username.isEmpty()){
            Toast.makeText(MainActivity.this, "Email Adddress or username is empty", Toast.LENGTH_LONG).show();
        }else {

            Intent secondintent = new Intent(MainActivity.this, SecondActivity.class);
            secondintent.putExtra("EMAILADDRESS", emailAddress);
            secondintent.putExtra("USERNAME", username);
            startActivityForResult(secondintent, 134);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 134){
            if(resultCode == Activity.RESULT_OK){
                String editedEmailAddress = data.getExtras().getString("EDITED_EMAIL");
                String editedUsername = data.getExtras().getString("EDITED_USERNAME");

                mEtEmailAddress.setText(editedEmailAddress);
                mEtUsername.setText(editedUsername);
            }else{
                Toast.makeText(MainActivity.this, "User Cancelled", Toast.LENGTH_LONG).show();
            }
        }
    }

    //    public void anyFunctionName(View view){
//
//    }
}