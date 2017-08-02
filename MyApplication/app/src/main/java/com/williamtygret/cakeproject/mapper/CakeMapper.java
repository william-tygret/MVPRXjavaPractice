package com.williamtygret.cakeproject.mapper;

import android.support.annotation.NonNull;

import com.williamtygret.cakeproject.mvp.model.Cake;
import com.williamtygret.cakeproject.mvp.model.CakesResponse;
import com.williamtygret.cakeproject.mvp.model.CakesResponseCakes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.inject.Inject;

/**
 * Created by williamtygret on 8/1/17.
 */
public class CakeMapper {

    @Inject
    public CakeMapper(){

    }

    public List<Cake> mapCakes(CakesResponse response){
        List<Cake> cakeList = new ArrayList<>();

        if (response != null) {
            CakesResponseCakes[] responseCakes = response.getCakes();

            if (responseCakes != null) {
                for (CakesResponseCakes cake : responseCakes) {
                    Cake myCake = new Cake();
                    myCake.setId(cake.getId());
                    myCake.setPreviewDescription(cake.getPreviewDescription());
                    myCake.setDetailDescription(cake.getDetailDescription());
                    myCake.setImageURL(cake.getImage());
                    myCake.setTitle(cake.getTitle());
                    cakeList.add(myCake);
                }
            }

        }

            return cakeList;

    }

}
