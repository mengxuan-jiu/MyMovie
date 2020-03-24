package com.bw.movie.contract;

import com.bw.movie.band.Registered;
import com.bw.movie.band.SendOutEmailCode;

/**
 * @包名 com.bw.movie.contract
 * @MengXuanmengxuan
 * @日期2020/3/23
 * @项目名MxMove
 * @类名Contract
 **/
public interface IContractRegistered {
    interface IView{
     void EmailCodeSuccess(SendOutEmailCode code);
     void EmailCodeFailure(Throwable throwable);

     void RegisteredSuccess(Registered registered);
     void RegisteredFailure(Throwable throwable);
    }

    interface IPresent{
         void EmailCodeDate(String email);
         void RegisteredDate(String nickName,String pwd,String email,String code);
    }

    interface IModel{
        void EmailCodeDate(String email,IViewEmail iViewEmail);
        void RegisteredDate(String nickName,String pwd,String email,String code,IViewRegis iViewRegis);
        interface IViewEmail{
            void EmailCodeSuccess(SendOutEmailCode code);
            void EmailCodeFailure(Throwable throwable);
        }
        interface IViewRegis{

            void RegisteredSuccess(Registered registered);
            void RegisteredFailure(Throwable throwable);
        }
    }
}
