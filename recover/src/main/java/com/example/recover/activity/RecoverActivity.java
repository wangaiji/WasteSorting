package com.example.recover.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recover.R;
import com.example.recover.fragment.RecoverFragment;

public class RecoverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover);
        getSupportFragmentManager().beginTransaction().replace(R.id.recover_container, new RecoverFragment()).commit();
    }
}