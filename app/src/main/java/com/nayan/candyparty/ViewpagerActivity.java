package com.nayan.candyparty;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

/**
 * Created by developer on 9/24/2017.
 */

public class ViewpagerActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout footerTab;
    Toolbar toolbar;
    private CircleIndicator circleIndicator;
    private static ArrayList<Integer> footerIcons;
    private AdFooterTab adapterFooter;
    public static int selectTabPos = 0;
    private Button btnStart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_activity);
        init();
        setupFooter();
    }

    private void init() {
        btnStart = (Button) findViewById(R.id.btnStart);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        circleIndicator = (CircleIndicator) findViewById(R.id.indicator);
        footerTab = (TabLayout) findViewById(R.id.footerTab);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewpagerActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setupFooter() {
        adapterFooter = new AdFooterTab(getSupportFragmentManager());
        adapterFooter.addFragment(FragmentOnbording.newInstance(), "Onbording1");
        adapterFooter.addFragment(FragmentOnbording2.newInstance(), "Onbording2");
        adapterFooter.addFragment(FragmentOnbording3.newInstance(), "Onbording3");
        viewPager.setAdapter(adapterFooter);
        circleIndicator.setViewPager(viewPager);

    }


}
