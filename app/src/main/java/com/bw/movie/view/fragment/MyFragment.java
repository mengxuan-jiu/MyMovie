package com.bw.movie.view.fragment;


import android.content.Intent;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.view.activity.LingActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends BaseFragment {

    @BindView(R.id.look_information)
    ImageView lookInformation;
    @BindView(R.id.im_dl)
    ImageView imDl;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.information)
    ImageButton information;
    @BindView(R.id.dyp)
    ImageView dyp;
    @BindView(R.id.my_attention)
    RadioButton myAttention;
    @BindView(R.id.my_reservation)
    RadioButton myReservation;
    @BindView(R.id.buy_tickets)
    RadioButton buyTickets;
    @BindView(R.id.watched_a_movie)
    RadioButton watchedAMovie;
    @BindView(R.id.my_comment)
    RadioButton myComment;
    @BindView(R.id.feedback)
    RadioButton feedback;
    @BindView(R.id.my_settings)
    RadioButton mySettings;

    @Override
    protected void initDate() {

    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView(View inflate) {
        imDl.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent picture = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(picture, 2);

                return true;
            }
        });
    }

    @Override
    protected BasePresenter Pprenher() {
        return null;
    }

    @OnClick({R.id.look_information, R.id.im_dl, R.id.name, R.id.information, R.id.dyp, R.id.my_attention, R.id.my_reservation, R.id.buy_tickets, R.id.watched_a_movie, R.id.my_comment, R.id.feedback, R.id.my_settings})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.look_information:
                Toast.makeText(getContext(), "查看信息", Toast.LENGTH_SHORT).show();
                break;
            case R.id.im_dl:
                Toast.makeText(getContext(), "点击头像登录", Toast.LENGTH_SHORT).show();
                initdl();
                break;
            case R.id.name:
                Toast.makeText(getContext(), "点击名字登录", Toast.LENGTH_SHORT).show();
                initdl();
                break;
            case R.id.information:
                Toast.makeText(getContext(), "基本信息", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dyp:
                Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_attention:
                Toast.makeText(getContext(), "我的关注", Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_reservation:
                Toast.makeText(getContext(), "我的预约", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buy_tickets:
                Toast.makeText(getContext(), "购票记录", Toast.LENGTH_SHORT).show();
                break;
            case R.id.watched_a_movie:
                Toast.makeText(getContext(), "看过电影", Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_comment:
                Toast.makeText(getContext(), "我的评论", Toast.LENGTH_SHORT).show();
                break;
            case R.id.feedback:
                Toast.makeText(getContext(), "建议反馈", Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_settings:
                Toast.makeText(getContext(), "设置", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void initdl() {
        Intent intent = new Intent(getContext(), LingActivity.class);
        startActivity(intent);

    }
}
