package com.example.connectingtointernetanddownloadingfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(InternetStatus.connectionStatus(this))
            Toast.makeText(this,"Connected via",Toast.LENGTH_SHORT).show();

        else
            Toast.makeText(this,"requried network connection",Toast.LENGTH_SHORT).show();
    }
}