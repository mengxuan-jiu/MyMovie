package com.bw.movie.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;



import butterknife.ButterKnife;


/**
 * @包名 com.bawei.mengxuan.base
 * @MengXuanmengxuan
 * @日期2020-3-19
 * @项目名MengXuan2020316
 * @类名BaseActivity
 **/
public abstract class BaseActivity<P extends BasePresenter>  extends AppCompatActivity {
protected P mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        mPresenter =Ppresenter();
        if (mPresenter != null) {
            mPresenter.attached(this);
        }
        ButterKnife.bind(this);
        initView();
        initDate();
    }

    protected abstract int layoutId();

    protected abstract void initDate();

    protected abstract void initView();

    protected abstract P Ppresenter();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.dttached();
        }
    }
}