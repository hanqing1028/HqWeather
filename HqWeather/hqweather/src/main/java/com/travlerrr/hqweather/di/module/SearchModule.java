package com.travlerrr.hqweather.di.module;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import com.tbruyelle.rxpermissions2.RxPermissions;
import com.travlerrr.hqweather.R;
import com.travlerrr.hqweather.mvp.contract.SearchContract;
import com.travlerrr.hqweather.mvp.model.SearchModel;
import com.travlerrr.hqweather.mvp.model.entity.SearchCityEntity;
import com.travlerrr.hqweather.mvp.ui.adapter.SearchCityAdapter;

import java.util.ArrayList;
import java.util.List;


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
@Module
public abstract class SearchModule {

    @Binds
    abstract SearchContract.Model bindSearchModel(SearchModel model);

    @ActivityScope
    @Provides
    static RxPermissions provideRxPermissions(SearchContract.View view) {
        return new RxPermissions((FragmentActivity) view.getActivity());
    }

    @ActivityScope
    @Provides
    static List<SearchCityEntity.HeWeather6Bean.BasicBean> provideCityList() {
        return new ArrayList<>();
    }

    @ActivityScope
    @Provides
    static SearchCityAdapter provideSearchCityAdapter(List<SearchCityEntity.HeWeather6Bean.BasicBean> mlist){
        return new SearchCityAdapter(R.layout.item_searching,mlist);
    }

    @ActivityScope
    @Provides
    static RecyclerView.LayoutManager provideLayoutManager(SearchContract.View view) {
        return new LinearLayoutManager(view.getActivity(),LinearLayoutManager.VERTICAL,false);
    }


}