package com.travlerrr.hqweather.mvp.presenter;

import android.app.Application;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.jess.arms.integration.AppManager;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.http.imageloader.ImageLoader;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import timber.log.Timber;

import javax.inject.Inject;

import com.jess.arms.utils.ArmsUtils;
import com.jess.arms.utils.RxLifecycleUtils;
import com.travlerrr.hqweather.R;
import com.travlerrr.hqweather.mvp.contract.SearchContract;
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
@ActivityScope
public class SearchPresenter extends BasePresenter<SearchContract.Model, SearchContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;
    @Inject
    SearchCityAdapter madapter;
//    @Inject
//    RecyclerView.Adapter mAdapter;
    @Inject
    List<SearchCityEntity.HeWeather6Bean.BasicBean> mlist ;


    @Inject
    public SearchPresenter(SearchContract.Model model, SearchContract.View rootView) {
        super(model, rootView);
    }


    //根据输入的字符获取城市列表
    public void getSearchedCity(String location) {
        mModel.getCities(location,"1328490164f2440db3519e45b3b914eb","match")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))//使用 Rxlifecycle,使 Disposable 和 Activity 一起销毁
                .subscribe(new ErrorHandleSubscriber<SearchCityEntity>(mErrorHandler) {
                    @Override
                    public void onError(Throwable t) {
                        super.onError(t);
                        Timber.e(t.getMessage());
                    }

                    @Override
                    public void onNext(SearchCityEntity entity) {
                        if(entity != null) {
                            //这里必须用addAll，不然会显示不了数据
                            //list = newlist的方法似乎会赋予一个新的引用
                            mlist.clear();
                            mlist.addAll(entity.getHeWeather6().get(0).getBasic());
                            Timber.d("searchText");
                            Timber.d(mlist.size()+"");
                            madapter.notifyDataSetChanged();
                        }else {
                            Toast.makeText(mApplication, "查询不到地点", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mImageLoader = null;
        this.mApplication = null;
        this.madapter = null;
        this.mlist = null;

    }
}
