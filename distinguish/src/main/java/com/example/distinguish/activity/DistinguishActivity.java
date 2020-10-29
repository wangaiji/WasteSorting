package com.example.distinguish.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.distinguish.R;
import com.example.distinguish.fragment.DistinguishFragment;

public class DistinguishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distinguish);
        getSupportFragmentManager().beginTransaction().replace(R.id.distinguish_container, new DistinguishFragment()).commit();
    }
}