package kenjin.DynamicTabPage.activities;

import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;

import kenjin.DynamicTabPage.R;
import kenjin.DynamicTabPage.adapters.DynamicTabPageAdapter;
import kenjin.DynamicTabPage.fragments.OneFragment;
import kenjin.DynamicTabPage.model.ViewPagerTab;

/**
 * Created by kenjinsan on 5/22/17.
 */

public class DynamicActivity extends AppCompatActivity {

    PagerSlidingTabStrip tabs;
    ViewPager pager;
    FragmentStatePagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);
        setTitle("Dynamic Tabs");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        pager = (ViewPager) findViewById(R.id.pager);

        ArrayList<ViewPagerTab> tabsList = new ArrayList<>();
        tabsList.add(new ViewPagerTab("One", 3));
        tabsList.add(new ViewPagerTab("Two", 1));
        tabsList.add(new ViewPagerTab("Three", 2));
        //if you want dynamic
        ArrayList<OneFragment> tabFragment=new ArrayList<>();
        tabFragment.add(OneFragment.newInstant("One"));
        tabFragment.add(OneFragment.newInstant("Two"));
        tabFragment.add(OneFragment.newInstant("Three"));

        adapter = new DynamicTabPageAdapter(getSupportFragmentManager(), tabsList,tabFragment);

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
