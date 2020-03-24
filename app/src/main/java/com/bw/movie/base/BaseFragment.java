package com.bw.movie.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



import butterknife.ButterKnife;

/**
 * @包名 com.bawei.mengxuan.base
 * @MengXuanmengxuan
 * @日期2020-3-19
 * @项目名MengXuan2020316
 * @类名BaseFragment
 **/
public abstract class BaseFragment<P extends BasePresenter> extends Fragment {
    protected P mPresenter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(layoutId(), container, false);
        mPresenter =Pprenher();
        if (mPresenter != null) {
            mPresenter.attached(this);
        }
        ButterKnife.bind(this,inflate);
        initView(inflate);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    initDate();
    }

    protected abstract void initDate();

    protected abstract int layoutId();

    protected abstract void initView(View inflate);

    protected abstract P Pprenher();

}
