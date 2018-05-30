package com.huang.navigationviewdemo;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.activity_main);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //默认情况下，所有的图标都会统一处理成黑色，通过这个API设置不处理
        navigationView.setItemIconTintList(null);

        //获得app:headerLayout指定的view
        View headerView = navigationView.getHeaderView(0);
        TextView headerTv = (TextView) headerView.findViewById(R.id.version_tv);
        headerTv.setText("V2.0.1");

        //设置navigation每个item的点击事件
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                String tip = "Oh On";
                switch (item.getItemId()){
                    case R.id.nav_menu_camera:
                        tip = "camera";
                        break;
                    case R.id.nav_menu_calendar:
                        tip = "calendar";
                        break;
                    case R.id.nav_slideshow:
                        tip = "slideshow";
                        break;
                    case R.id.nav_manage:
                        tip = "manage";
                        break;
                    case R.id.nav_share:
                        tip = "share";
                        break;
                    case R.id.nav_send:
                        tip = "send";
                        break;
                }
                Toast.makeText(MainActivity.this, tip, Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });
    }
}
