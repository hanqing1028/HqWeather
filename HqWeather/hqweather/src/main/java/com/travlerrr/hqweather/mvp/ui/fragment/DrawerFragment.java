package com.travlerrr.hqweather.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.travlerrr.hqweather.R;
import com.travlerrr.hqweather.mvp.contract.DrawerContract;
import com.travlerrr.hqweather.mvp.presenter.DrawerPresenter;
import com.travlerrr.hqweather.mvp.ui.activity.SearchActivity;

import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;

public class DrawerFragment extends BaseFragment<DrawerPresenter> implements DrawerContract.View {

    @BindView(R.id.btn_fab)
    FloatingActionButton fab;

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_drawer,container,false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        setFABlistener();
    }

    @Override
    public void setData(@Nullable Object data) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {

    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);

    }

    @Override
    public void killMyself() {

    }

    //设置FAB的点击事件
    @Override
    public void setFABlistener() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchintent = new Intent(getActivity(), SearchActivity.class);
                launchActivity(searchintent);
            }
        });

    }
}
