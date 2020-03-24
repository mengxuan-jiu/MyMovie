package com.bw.movie.view.activity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.band.Registered;
import com.bw.movie.band.SendOutEmailCode;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.IContractRegistered;
import com.bw.movie.presenter.RegisteredPresenter;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity<RegisteredPresenter> implements IContractRegistered.IView {


    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.pwb)
    EditText pwb;
    @BindView(R.id.r_email)
    EditText rEmail;
    @BindView(R.id.r_syz)
    EditText rSyz;
    @BindView(R.id.r_f_email)
    Button rFEmail;
    @BindView(R.id.zc)
    Button zc;

    @Override
    protected int layoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected RegisteredPresenter Ppresenter() {
        return new RegisteredPresenter();
    }

    @Override
    public void EmailCodeSuccess(SendOutEmailCode code) {
        Toast.makeText(this, "" + code.getMessage() + code.getStatus(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void EmailCodeFailure(Throwable throwable) {
        Toast.makeText(this, ""+throwable.getMessage(), Toast.LENGTH_SHORT).show();
        Log.e("xx", "EmailCodeFailure: "+throwable.getMessage() );
    }

    @Override
    public void RegisteredSuccess(Registered registered) {
        registered.getStatus();
        if (registered.getMessage().equals("0000")){
            Toast.makeText(this, "v"+registered.getMessage(), Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "x"+registered.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void RegisteredFailure(Throwable throwable) {
        Toast.makeText(this, ""+throwable.getMessage(), Toast.LENGTH_SHORT).show();
        Log.e("xx", "EmailCodeFailure: "+throwable.getMessage() );
    }


    @OnClick({R.id.r_f_email, R.id.zc})
    public void onViewClicked(View view) {
        String srEmail = rEmail.getText().toString();
        String nam = name.getText().toString();
        String pw = pwb.getText().toString();
        String yzm = rSyz.getText().toString();
        switch (view.getId()) {
            case R.id.r_f_email:

                mPresenter.EmailCodeDate(srEmail);
                break;
            case R.id.zc:
                Toast.makeText(this, ""+pw, Toast.LENGTH_SHORT).show();
                mPresenter.RegisteredDate(nam, pw, srEmail, yzm);
                break;
        }
    }
}
