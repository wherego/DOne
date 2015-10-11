package com.dzy.done.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dzy.done.config.PageConfig;
import com.dzy.done.view.fregment.ContentListFregment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dzysg on 2015/10/9 0009.
 */
public class MainPageAdapter extends FragmentPagerAdapter {


    List<Fragment> mFragments;


    public MainPageAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new ArrayList<Fragment>();

        mFragments.add(ContentListFregment.newInstance(1));
        mFragments.add(ContentListFregment.newInstance(2));
        mFragments.add(ContentListFregment.newInstance(3));

    }

    @Override
    public Fragment getItem(int position) {

        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {

        return PageConfig.titles[position];
    }
}
