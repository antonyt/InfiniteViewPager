package com.antonyt.infiniteviewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

public class InfiniteViewPagerActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        PagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            int[] colours = new int[]{Color.CYAN, Color.GRAY, Color.MAGENTA, Color.LTGRAY, Color.GREEN, Color.WHITE,
                    Color.YELLOW};

            @Override
            public int getCount() {
                return colours.length;
            }

            @Override
            public Fragment getItem(int position) {
                Fragment fragment = new ColourFragment();
                Bundle args = new Bundle();
                args.putInt("colour", colours[position]);
                args.putInt("identifier", position);
                fragment.setArguments(args);
                return fragment;
            }
        };

        // wrap pager to provide infinite paging with wrap-around
        PagerAdapter wrappedAdapter = new InfinitePagerAdapter(adapter);

        // actually an InfiniteViewPager
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(wrappedAdapter);

    }
}