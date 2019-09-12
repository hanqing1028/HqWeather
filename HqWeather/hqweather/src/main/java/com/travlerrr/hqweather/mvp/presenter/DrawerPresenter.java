package com.travlerrr.hqweather.mvp.presenter;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;
import com.travlerrr.hqweather.mvp.contract.DrawerContract;
import com.travlerrr.hqweather.mvp.contract.MainContract;

import javax.inject.Inject;

@ActivityScope
public class DrawerPresenter extends BasePresenter<DrawerContract.Model, DrawerContract.View> {

    @Inject
    public DrawerPresenter(DrawerContract.Model model, DrawerContract.View rootView) {
        super(model, rootView);
    }


}
