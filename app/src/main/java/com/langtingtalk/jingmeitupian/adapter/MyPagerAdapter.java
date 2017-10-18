package com.langtingtalk.jingmeitupian.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Author       : Michealstorm@aliyun.com
 * Project Name ：JingMeiTuPian
 * Created Time : 2017/10/18 15:53
 * Description  : //todo
 */

public class MyPagerAdapter extends PagerAdapter {
    private List<View> mList;
    public MyPagerAdapter(List<View> mViewList) {
        this.mList=mViewList;

    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
//        return super.instantiateItem(container, position);
        ((ViewPager) container).addView(mList.get(position));
        return mList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView(mList.get(position));
//        super.destroyItem(container, position, object);
    }
}
