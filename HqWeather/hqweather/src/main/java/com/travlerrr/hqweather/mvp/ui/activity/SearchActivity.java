package com.travlerrr.hqweather.mvp.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AutoCompleteTextView;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.tbruyelle.rxpermissions2.RxPermissions;
import com.travlerrr.hqweather.di.component.DaggerSearchComponent;
import com.travlerrr.hqweather.mvp.contract.SearchContract;
import com.travlerrr.hqweather.mvp.presenter.SearchPresenter;

import com.travlerrr.hqweather.R;
import com.travlerrr.hqweather.mvp.ui.adapter.SearchCityAdapter;


import javax.inject.Inject;

import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/13/2019 10:08
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class SearchActivity extends BaseActivity<SearchPresenter> implements SearchContract.View {

    @BindView(R.id.rv_search)
    RecyclerView rvSearch;
    @BindView(R.id.actv_search)
    AutoCompleteTextView actv;
    @Inject
    RecyclerView.LayoutManager mLayoutManager;
    @Inject
    SearchCityAdapter madapter;
//    @Inject
//    RecyclerView.Adapter mAdapter;
    @Inject
    RxPermissions mRxPermissions;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerSearchComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_search;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initRecyclerView();
        rvSearch.setAdapter(madapter);
        initSearch();
    }

    private void initRecyclerView() {
        ArmsUtils.configRecyclerView(rvSearch, mLayoutManager);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }



    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public RxPermissions getRxPermissions() {
        return mRxPermissions;
    }


    private void initSearch() {
        actv.setThreshold(1);
        //编辑框输入监听
        actv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String searchResult = actv.getText().toString();
                if (!TextUtils.isEmpty(searchResult)) {
                    mPresenter.getSearchedCity(searchResult);
                    //rvSearch.setAdapter(mAdapter);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
