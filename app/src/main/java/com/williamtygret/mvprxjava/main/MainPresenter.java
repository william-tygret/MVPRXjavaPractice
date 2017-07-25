package com.williamtygret.mvprxjava.main;

import com.williamtygret.mvprxjava.models.CityListResponse;
import com.williamtygret.mvprxjava.networking.NetworkError;
import com.williamtygret.mvprxjava.networking.Service;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by williamtygret on 7/24/17.
 */
public class MainPresenter {

    private final Service service;
    private final MainView view;
    private CompositeSubscription subscriptions;

    public MainPresenter(Service service, MainView view) {
        this.service = service;
        this.view = view;
        this.subscriptions = new CompositeSubscription();
    }

    public void getCityList() {
        view.showWait();

        Subscription subscription = service.getCityList(new Service.GetCityListCallback() {
            @Override
            public void onSuccess(CityListResponse cityListResponse) {
                view.removeWait();
                view.getityListSuccess(cityListResponse);
            }

            @Override
            public void onError(NetworkError networkError) {
                view.removeWait();
                view.onFailure(networkError.getAppErrorMessage());
            }

        });

        subscriptions.add(subscription);
    }
    public void onStop() {
        subscriptions.unsubscribe();
    }

}
