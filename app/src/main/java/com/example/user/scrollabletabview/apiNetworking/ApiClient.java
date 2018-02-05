package com.example.user.scrollabletabview.apiNetworking;

import com.example.user.scrollabletabview.model.masterCategoryModel.MasterCategory;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by SHOVON on 1/9/2018.
 */

public interface ApiClient {

    //master category with children items
    @GET("v1/categories")
    Call <MasterCategory> getMasterCategoryApiResponse(@Query("with") String categorySort);

//    //by latitude & longitude
//    @GET("data/2.5/forecast")
//    Call <WeatherData> getDataByLatLon(@Query("lat") Float latitude,
//                                       @Query("lon") Float longitude,
//                                       @Query("appid") String apiTokenKey);
//
//    //by celsius format
//    @GET("data/2.5/forecast")
//    Call <WeatherData> getDataByCelcius(@Query("q") String cityName,
//                                        @Query("units") String celsiusFormat,
//                                        @Query("appid") String apiTokenKey);


}
