package com.bw.movie.base;

/**
 * @包名 com.bawei.mengxuan.base
 * @MengXuanmengxuan
 * @日期2020-3-19
 * @项目名MengXuan2020316
 * @类名BasePrenher 契约
 **/
public abstract class BasePresenter<V> {
    protected V view;

    public BasePresenter() {
        initModel();
    }

    public void attached(V view) {
        this.view = view;
    }

    public void dttached() {
        view = null;
    }

    protected abstract void initModel();
}
