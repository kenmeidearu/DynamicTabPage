package kenjin.DynamicTabPage.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;

import kenjin.DynamicTabPage.R;
import kenjin.DynamicTabPage.fragments.OneFragment;
import kenjin.DynamicTabPage.fragments.ThreeFragment;
import kenjin.DynamicTabPage.fragments.TwoFragment;
import kenjin.DynamicTabPage.model.ViewPagerTab;

/**
 * Created by K on 22.06.2015.
 */
public class StaticTabPageAdapter extends FragmentPagerAdapter
        implements PagerSlidingTabStrip.CustomTabProvider {

    ArrayList<ViewPagerTab> tabs;

    public StaticTabPageAdapter(FragmentManager fm, ArrayList<ViewPagerTab> tabs) {
        super(fm);
        this.tabs = tabs;
    }


    @Override
    public View getCustomTabView(ViewGroup viewGroup, int i) {
        RelativeLayout tabLayout = (RelativeLayout)
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tab_layout, null);

        TextView tabTitle = (TextView) tabLayout.findViewById(R.id.tab_title);
        TextView badge = (TextView) tabLayout.findViewById(R.id.badge);

        ViewPagerTab tab = tabs.get(i);

        tabTitle.setText(tab.title.toUpperCase());

       if (tab.notifications > 0) {
            badge.setVisibility(View.VISIBLE);
            badge.setText(String.valueOf(tab.notifications));
        } else {
            badge.setVisibility(View.GONE);
        }

        return tabLayout;
    }

    @Override
    public void tabSelected(View view) {
        RelativeLayout tabLayout = (RelativeLayout) view;
        TextView badge = (TextView) tabLayout.findViewById(R.id.badge);
        badge.setVisibility(View.GONE);
    }

    @Override
    public void tabUnselected(View view) {
        //view.setBackgroundColor(Color.GREEN);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new OneFragment();
            case 1:
                return new TwoFragment();
            case 2:
                return new ThreeFragment();
        }
        return new OneFragment();
    }

    @Override
    public int getCount() {
        return tabs.size();
    }
}