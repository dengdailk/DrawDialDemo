package com.study.drawdialdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.study.drawdialdemo.DialView.DialView;
import com.study.drawdialdemo.oilview.OilView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DialView dialView = findViewById(R.id.dialView);
        dialView.setBigDialDegreesMax(50);
        dialView.setSmallDialDegreesMax(-90);
        OilView oilView = findViewById(R.id.oilView);
        oilView.setAngelMax(10);
    }
}
