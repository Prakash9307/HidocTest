package com.example.hidoctest.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.hidoctest.Adapter.TabAdapter;
import com.example.hidoctest.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity
{
    ViewPager viewPager;
    TabLayout tab_status;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }

    public void initUI()
    {

        tab_status = findViewById(R.id.tab_status);
        viewPager = findViewById(R.id.viewPager);

        setTab();
    }

    public void setTab()
    {

        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager());

        viewPager.setAdapter(tabAdapter);
        tab_status.setupWithViewPager(viewPager);
    }

    public static String getCurrentDate()
    {
        String date = "2021-04-14";

        return date;
    }
}