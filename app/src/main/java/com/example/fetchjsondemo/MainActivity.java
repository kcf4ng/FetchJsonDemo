package com.example.fetchjsondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


//範例教學影片：https://youtu.be/Vcn4OuV4Ixg

public class MainActivity extends AppCompatActivity {

    private View.OnClickListener btnGet_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            FetchDataAct process = new FetchDataAct();
            process.execute();

        }
    } ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitialComponent();
    }

    private void InitialComponent() {
    btnGet = findViewById(R.id.btnGet);
    btnGet.setOnClickListener(btnGet_click);
    lblJson = findViewById(R.id.lblJson);
    }
    Button btnGet;
    public static TextView lblJson;
}
