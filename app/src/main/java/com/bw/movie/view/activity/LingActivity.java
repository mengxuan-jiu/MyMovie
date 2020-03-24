package com.bw.movie.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bw.movie.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LingActivity extends AppCompatActivity {

    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.forget_password)
    Button forgetPassword;
    @BindView(R.id.sign_up_now)
    TextView signUpNow;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.we_Chat)
    ImageButton weChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ling);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.forget_password, R.id.sign_up_now, R.id.login, R.id.we_Chat})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.forget_password:
                break;
            case R.id.sign_up_now:
              startActivity(new Intent(LingActivity.this,RegisterActivity.class));
                break;
            case R.id.login:
                break;
            case R.id.we_Chat:
                break;
        }
    }
}
