package com.example.pun.deewasteuitestfix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_login;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        btn_login = (Button)findViewById(R.id.btn_login);
        btn_login.setOnClickListener(loginClick);




    }
    private View.OnClickListener loginClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent1 = new Intent(MainActivity.this, MenuActivity.class);
            //pass parameter to next activity

            startActivity(intent1);
        }
    };



}
