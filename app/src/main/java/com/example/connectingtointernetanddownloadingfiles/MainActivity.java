package com.example.connectingtointernetanddownloadingfiles;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText urlEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        urlEt=(EditText) findViewById(R.id.imageEt);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if(InternetStatus.connectionStatus(MainActivity.this)) {
                    Toast.makeText(MainActivity.this, "Connected", Toast.LENGTH_SHORT).show();
                    DownloadingContent dc=new DownloadingContent();
                    dc.downloadImage(MainActivity.this, String.valueOf(System.currentTimeMillis()), urlEt.getText().toString().trim());
                }
                else
                    Toast.makeText(MainActivity.this,"requried network connection",Toast.LENGTH_SHORT).show();
            }
        });

    }
}