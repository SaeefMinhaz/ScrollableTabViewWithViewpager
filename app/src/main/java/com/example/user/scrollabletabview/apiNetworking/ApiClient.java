package com.example.user.scrollabletabview.apiNetworking;

import com.example.user.scrollabletabview.model.masterCategoryModel.CategoryChild.Secondary;
import com.example.user.scrollabletabview.model.masterCategoryModel.masterCategory.MasterCategory;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by SHOVON on 1/9/2018.
 */

public interface ApiClient {

    //master category with children items
    @GET("categories")
    Call <MasterCategory> getMasterCategoryApiResponse(@Query("with") String categorySort);

    //secondary/ child items
    @GET("categories/{masterCategoryId}/secondaries")
    Call <Secondary> getChildFromMasterCategory(@Path("masterCategoryId") int masterCategoryId);
//
//    //by celsius format
//    @GET("data/2.5/forecast")
//    Call <WeatherData> getDataByCelcius(@Query("q") String cityName,
//                                        @Query("units") String celsiusFormat,
//                                        @Query("appid") String apiTokenKey);


}
