package com.example.guide.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.guide.R;
import com.example.guide.fragment.GuideFragment;

public class GuideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        getSupportFragmentManager().beginTransaction().replace(R.id.guide_container, new GuideFragment()).commit();
    }
}