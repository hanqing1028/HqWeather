package com.travlerrr.hqweather.mvp.model.api.service;

import com.travlerrr.hqweather.mvp.model.entity.SearchCityEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

//搜索城市的接口
public interface CitySearchService {

    /**
     * 获取city列表
     */
    @GET("/find")
    Observable<SearchCityEntity> getCities(@Query("location") String location,
                                           @Query("key") String key,
                                           @Query("mode") String mode
    );
}
