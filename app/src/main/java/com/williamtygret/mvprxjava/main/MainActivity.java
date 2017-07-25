package com.williamtygret.mvprxjava.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.williamtygret.mvprxjava.BaseApp;
import com.williamtygret.mvprxjava.R;
import com.williamtygret.mvprxjava.models.CityListData;
import com.williamtygret.mvprxjava.models.CityListResponse;
import com.williamtygret.mvprxjava.networking.Service;

import javax.inject.Inject;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.williamtygret.mvprxjava.R;

public class MainActivity extends BaseApp implements MainView {

    private RecyclerView list;
    @Inject
    public  Service service;
    ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDeps().inject(this);

        renderView();
        init();

        MainPresenter presenter = new MainPresenter(service, this);
        presenter.getCityList();
    }

    public  void renderView(){
        setContentView(R.layout.activity_main);
        list = (RecyclerView) findViewById(R.id.list);
        progressBar = (ProgressBar) findViewById(R.id.progress);
    }

    public void init(){
        list.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showWait() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeWait() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(String appErrorMessage) {

    }

    @Override
    public void getityListSuccess(CityListResponse cityListResponse) {

        MainAdapter adapter = new MainAdapter(getApplicationContext(), cityListResponse.getData(),
                new MainAdapter.OnItemClickListener() {
                    @Override
                    public void onClick(CityListData Item) {
                        Toast.makeText(getApplicationContext(), Item.getName(),
                                Toast.LENGTH_LONG).show();
                    }
                });

        list.setAdapter(adapter);

    }

}
