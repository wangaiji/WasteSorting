package com.example.wastesorting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.alibaba.android.arouter.launcher.ARouter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private Fragment distinguishFragment;
    private Fragment recoverFragment;
    private Fragment guideFragment;
    private Fragment mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(this.getApplication()); // 尽可能早，推荐在Application中初始化
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//设置透明状态栏
        }
        initView();
    }

    private void initView() {
        distinguishFragment = (Fragment) ARouter.getInstance().build("/distinguish/fragment").navigation();
        recoverFragment = (Fragment) ARouter.getInstance().build("/recover/fragment").navigation();
        guideFragment = (Fragment) ARouter.getInstance().build("/guide/fragment").navigation();
        mineFragment = (Fragment) ARouter.getInstance().build("/mine/fragment").navigation();
        bottomNavigationView = findViewById(R.id.navigation_view);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frameLayout, distinguishFragment).add(R.id.frameLayout, recoverFragment).add(R.id.frameLayout, guideFragment).add(R.id.frameLayout, mineFragment);
        fragmentTransaction.hide(recoverFragment).hide(guideFragment).hide(mineFragment);
        fragmentTransaction.commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
                switch (menuItem.getItemId()) {
                    case R.id.distinguish:
                        beginTransaction.hide(recoverFragment).hide(guideFragment).hide(mineFragment);
                        beginTransaction.show(distinguishFragment);
                        beginTransaction.commit();
                        break;
                    case R.id.recover:
                        beginTransaction.hide(distinguishFragment).hide(guideFragment).hide(mineFragment);
                        beginTransaction.show(recoverFragment);
                        beginTransaction.commit();
                        break;
                    case R.id.guide:
                        beginTransaction.hide(distinguishFragment).hide(recoverFragment).hide(mineFragment);
                        beginTransaction.show(guideFragment);
                        beginTransaction.commit();
                        break;
                    case R.id.mine:
                        beginTransaction.hide(distinguishFragment).hide(recoverFragment).hide(guideFragment);
                        beginTransaction.show(mineFragment);
                        beginTransaction.commit();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }
}