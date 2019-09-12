package com.travlerrr.hqweather.mvp.model;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.travlerrr.hqweather.mvp.contract.DrawerContract;

import javax.inject.Inject;

@ActivityScope
public class DrawerModel extends BaseModel implements DrawerContract.Model {

    @Inject
    public DrawerModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }
}
