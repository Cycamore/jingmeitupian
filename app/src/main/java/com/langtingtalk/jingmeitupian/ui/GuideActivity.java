package com.langtingtalk.jingmeitupian.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.langtingtalk.jingmeitupian.MainActivity;
import com.langtingtalk.jingmeitupian.R;
import com.langtingtalk.jingmeitupian.adapter.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity implements View.OnClickListener {
    ViewPager mViewPager;
    TextView mSkip;
    View mView1, mView2, mView3;
    List<View> mViewList = new ArrayList<>();
    ImageView mPoint1, mPoint2, mPoint3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        initView();
        setUpViewPager();

    }

    private void setUpViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.guide_viewpager);
        mViewPager.setAdapter(new MyPagerAdapter(mViewList));
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        setBottomPointImg(true, false, false);
                        break;
                    case 1:
                        setBottomPointImg(false, true, false);
                        break;
                    case 2:
                        setBottomPointImg(false, false, true);
                        mSkip.setVisibility(View.GONE);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initBottomPoint() {
        mPoint1 = (ImageView) findViewById(R.id.bottom_button1);
        mPoint2 = (ImageView) findViewById(R.id.bottom_button2);
        mPoint3 = (ImageView) findViewById(R.id.bottom_button3);
        setBottomPointImg(true,false,false);

    }


    private void setBottomPointImg(boolean point1, boolean point2, boolean point3) {
        if (point1) {
            mPoint1.setImageResource(R.drawable.point_on);

        } else {
            mPoint1.setImageResource(R.drawable.point_off);
        }

        if (point2) {
            mPoint2.setImageResource(R.drawable.point_on);

        } else {
            mPoint2.setImageResource(R.drawable.point_off);
        }
        if (point3) {
            mPoint3.setImageResource(R.drawable.point_on);

        } else {
            mPoint3.setImageResource(R.drawable.point_off);
        }
    }

    private void initView() {
        mView1 = View.inflate(this, R.layout.activity_guide_pager1, null);
        mView2 = View.inflate(this, R.layout.activity_guide_pager2, null);
        mView3 = View.inflate(this, R.layout.activity_guide_pager3, null);
        mView3.findViewById(R.id.btn_enter).setOnClickListener(this);


        mViewList.add(mView1);
        mViewList.add(mView2);
        mViewList.add(mView3);

        //
        mSkip = (TextView) findViewById(R.id.tv_skip);
        //
        initBottomPoint();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_enter:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;

        }
    }
}
