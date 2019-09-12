package com.travlerrr.hqweather.di.module;

import com.travlerrr.hqweather.mvp.contract.DrawerContract;
import com.travlerrr.hqweather.mvp.contract.MainContract;
import com.travlerrr.hqweather.mvp.model.DrawerModel;
import com.travlerrr.hqweather.mvp.model.MainModel;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DrawerMoudle {

    @Binds
    abstract DrawerContract.Model bindDrawerModel(DrawerModel model);
}
