package com.williamtygret.mvprxjava.main;

import com.williamtygret.mvprxjava.models.CityListResponse;

/**
 * Created by williamtygret on 7/24/17.
 */
public interface MainView {

    void showWait();

    void removeWait();

    void onFailure(String appErrorMessage);

    void getityListSuccess(CityListResponse cityListResponse);


}
