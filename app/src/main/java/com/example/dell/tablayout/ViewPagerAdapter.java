package com.example.dell.tablayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Dell on 12/31/2017.
 */

public class ViewPagerAdapter <M extends RecyclerView.ViewHolder> extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ArrayList<String> tabTitles = new ArrayList<>();

    public void addFragments(Fragment fragment,String titles){
        this.fragments.add(fragment);
        this.tabTitles.add(titles);
    }


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return tabTitles.get(position);
    }
}
