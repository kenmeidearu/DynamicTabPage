package kenjin.DynamicTabPage.adapters;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;

import kenjin.DynamicTabPage.R;
import kenjin.DynamicTabPage.fragments.OneFragment;
import kenjin.DynamicTabPage.model.ViewPagerTab;

/**
 * Created by kenjinsan on 5/22/17.
 */

public class DynamicTabPageAdapter extends FragmentStatePagerAdapter
        implements PagerSlidingTabStrip.CustomTabProvider {

    ArrayList<ViewPagerTab> tabs;
    ArrayList<OneFragment> fragments;

    public DynamicTabPageAdapter(FragmentManager fm, ArrayList<ViewPagerTab> tabs, ArrayList<OneFragment> fragments) {
        super(fm);
        this.tabs = tabs;
        this.fragments=fragments;
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
        badge.setTextColor(Color.YELLOW);
    }

    @Override
    public void tabUnselected(View view) {
        RelativeLayout tabLayout = (RelativeLayout) view;
        TextView badge = (TextView) tabLayout.findViewById(R.id.badge);
        badge.setTextColor(Color.WHITE);
    }

    @Override
    public Fragment getItem(int position) {
        return  fragments.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }
}
