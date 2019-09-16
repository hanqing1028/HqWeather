package com.travlerrr.hqweather.mvp.ui.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.travlerrr.hqweather.R;
import com.travlerrr.hqweather.mvp.model.entity.SearchCityEntity;
import com.travlerrr.hqweather.mvp.model.entity.SearchCityEntity.HeWeather6Bean.BasicBean;

import java.util.List;



public class SearchCityAdapter extends BaseQuickAdapter<SearchCityEntity.HeWeather6Bean.BasicBean, BaseViewHolder> {

    public SearchCityAdapter(int layoutResId, @Nullable List<BasicBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, BasicBean item) {
        helper.setText(R.id.tv_item_searchcity,item.getLocation());
    }


}
