package kenjin.DynamicTabPage.activities;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;


import java.util.ArrayList;

import kenjin.DynamicTabPage.R;
import kenjin.DynamicTabPage.adapters.StaticTabPageAdapter;
import kenjin.DynamicTabPage.model.ViewPagerTab;

/**
 * Created by kenjinsan on 5/22/17.
 */

public class StaticActivity extends AppCompatActivity {

    PagerSlidingTabStrip tabs;
    ViewPager pager;
    FragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static);
        setTitle("Static Tabs");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        pager = (ViewPager) findViewById(R.id.pager);

        ArrayList<ViewPagerTab> tabsList = new ArrayList<>();
        tabsList.add(new ViewPagerTab("One", 0));
        tabsList.add(new ViewPagerTab("Two", 1));
        tabsList.add(new ViewPagerTab("Three", 2));

        adapter = new StaticTabPageAdapter(getSupportFragmentManager(), tabsList);

        pager.setAdapter(adapter);
        tabs.setViewPager(pager);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            //getFragmentManager().popBackStack();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
