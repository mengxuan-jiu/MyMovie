package com.bw.movie.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.view.fragment.MoveFragment;
import com.bw.movie.view.fragment.MoveyFragment;
import com.bw.movie.view.fragment.MyFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HainActivity extends BaseActivity {


    @BindView(R.id.ha_vp)
    ViewPager haVp;
    @BindView(R.id.ha_rb_film)
    RadioButton haRbFilm;
    @BindView(R.id.ha_rb_cinema)
    RadioButton haRbCinema;
    @BindView(R.id.ha_rb_mine)
    RadioButton haRbMine;
    @BindView(R.id.ha_rg)
    RadioGroup haRg;

    @Override
    protected int layoutId() {
        return R.layout.activity_hain;
    }

    @Override
    protected void initDate() {
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new MoveFragment());
        list.add(new MoveyFragment());
        list.add(new MyFragment());
        haVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
    }

    @Override
    protected void initView() {
haVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
haRg.check(haRg.getChildAt(position).getId());
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
});
    }

    @Override
    protected BasePresenter Ppresenter() {
        return null;
    }



    @OnClick({R.id.ha_rb_film, R.id.ha_rb_cinema, R.id.ha_rb_mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ha_rb_film:
                haVp.setCurrentItem(0);
                break;
            case R.id.ha_rb_cinema:
                haVp.setCurrentItem(1);
                break;
            case R.id.ha_rb_mine:
                haVp.setCurrentItem(2);
                break;
        }
    }
}
