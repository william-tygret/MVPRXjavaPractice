package com.williamtygret.mvprxjava.networking;

import com.williamtygret.mvprxjava.models.CityListResponse;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by williamtygret on 7/24/17.
 */
public interface NetworkService {


    @GET("v1/city")
    Observable<CityListResponse> getCityList();

}
