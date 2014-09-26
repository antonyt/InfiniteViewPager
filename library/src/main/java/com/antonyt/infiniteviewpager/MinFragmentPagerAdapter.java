package com.antonyt.infiniteviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

public class MinFragmentPagerAdapter extends FragmentPagerAdapter {

	private FragmentPagerAdapter adapter;

	public MinFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	public void setAdapter(FragmentPagerAdapter adapter) {
		this.adapter = adapter;
	}
	
	public int getRealCount() {
		return adapter.getCount();
	}

	@Override
	public int getCount() {
		int realCount = adapter.getCount();
		if (realCount == 1)
			return 4;
		else if (realCount == 2 || realCount == 3)
			return realCount * 2;
		else
			return realCount;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return adapter.isViewFromObject(view, object);
	}

	@Override
	public Fragment getItem(int position) {
		int realCount = adapter.getCount();
		if (realCount == 1)
			return adapter.getItem(0);
		else if (realCount == 2 || realCount == 3)
			return adapter.getItem(position % realCount);
		else
			return adapter.getItem(position);
	}

}
