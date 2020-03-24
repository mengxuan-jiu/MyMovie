package com.bw.movie.model;

import com.bw.movie.band.Registered;
import com.bw.movie.band.SendOutEmailCode;
import com.bw.movie.contract.IContractRegistered;
import com.bw.movie.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @包名 com.bw.movie.model
 * @MengXuanmengxuan
 * @日期2020/3/23
 * @项目名MyMovie
 * @类名RegisteredModel
 **/
public class RegisteredModel implements IContractRegistered.IModel {

    @Override
    public void EmailCodeDate(String email, IViewEmail iViewEmail) {
        NetUtil.getInstance().getmApi().SendOutEmailCode(email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SendOutEmailCode>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SendOutEmailCode code) {
                        iViewEmail.EmailCodeSuccess(code);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iViewEmail.EmailCodeFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void RegisteredDate(String nickName, String pwd, String email, String code, IViewRegis iViewRegis) {
        NetUtil.getInstance().getmApi().Registered(nickName, pwd, email, code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Registered>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Registered registered) {
                        iViewRegis.RegisteredSuccess(registered);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iViewRegis.RegisteredFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
