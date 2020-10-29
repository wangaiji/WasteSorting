package com.example.mine.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mine.R;
import com.example.mine.fragment.MineFragment;

public class MineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
        getSupportFragmentManager().beginTransaction().replace(R.id.mine_container, new MineFragment()).commit();
    }
}