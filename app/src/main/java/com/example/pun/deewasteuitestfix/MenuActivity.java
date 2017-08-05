package com.example.pun.deewasteuitestfix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Pun on 8/5/2017 AD.
 */



public class MenuActivity extends AppCompatActivity {

    private Button btn_report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        btn_report = (Button)findViewById(R.id.btn_report);
        btn_report.setOnClickListener(reportClick);

    }
    private View.OnClickListener reportClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent1 = new Intent(MenuActivity.this, ReportActivity.class);
            //pass parameter to next activity

            startActivity(intent1);
        }
    };

}
