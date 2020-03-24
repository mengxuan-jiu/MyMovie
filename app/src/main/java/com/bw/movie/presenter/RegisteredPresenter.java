package com.bw.movie.presenter;

import com.bw.movie.band.Registered;
import com.bw.movie.band.SendOutEmailCode;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.IContractRegistered;
import com.bw.movie.model.RegisteredModel;

/**
 * @包名 com.bw.movie.presenter
 * @MengXuanmengxuan
 * @日期2020/3/23
 * @项目名MyMovie
 * @类名RegisteredPresenter
 **/
public class RegisteredPresenter extends BasePresenter<IContractRegistered.IView> implements IContractRegistered.IPresent {

    private RegisteredModel mRegisteredModel;

    @Override
    protected void initModel() {
        mRegisteredModel = new RegisteredModel();

    }

    @Override
    public void EmailCodeDate(String email) {
        mRegisteredModel.EmailCodeDate(email, new IContractRegistered.IModel.IViewEmail() {
            @Override
            public void EmailCodeSuccess(SendOutEmailCode code) {
                view.EmailCodeSuccess(code);
            }

            @Override
            public void EmailCodeFailure(Throwable throwable) {
                view.EmailCodeFailure(throwable);
            }
        });
    }

    @Override
    public void RegisteredDate(String nickName, String pwd, String email, String code) {
        mRegisteredModel.RegisteredDate(nickName, pwd, email, code, new IContractRegistered.IModel.IViewRegis() {
            @Override
            public void RegisteredSuccess(Registered registered) {
                view.RegisteredSuccess(registered);
            }

            @Override
            public void RegisteredFailure(Throwable throwable) {
                view.RegisteredFailure(throwable);
            }
        });
    }
}
