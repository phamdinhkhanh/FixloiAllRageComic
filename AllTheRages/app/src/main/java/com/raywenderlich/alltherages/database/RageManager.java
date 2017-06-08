package com.raywenderlich.alltherages.database;

import android.util.Log;

import com.raywenderlich.alltherages.database.model.RageComic;
import com.raywenderlich.alltherages.networks.NetContext;
import com.raywenderlich.alltherages.networks.jsonmodels.RageResponseJson;
import com.raywenderlich.alltherages.networks.services.RageService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by laptopTCC on 6/8/2017.
 */

public class RageManager {
    public static String TAG = RageManager.class.toString();
    public static RageManager instance = new RageManager();
    private RageService rageManager = NetContext.instance.create(RageService.class);
    private RageManager(){

    };

    //1.Get all rage
    public void getRageManager(){
        rageManager.getRages().enqueue(new Callback<List<RageResponseJson>>() {
            @Override
            public void onResponse(Call<List<RageResponseJson>> call, Response<List<RageResponseJson>> response) {
                Log.d(TAG,"onResponse: getAllRage"+response.code());
                if(response.body() != null){
                    for(RageResponseJson r: response.body()){
                        DBContext.instance.addOrUpdate(new RageComic(
                                r.getId().getOid(),
                                r.getName(),
                                r.getUrl(),
                                r.getDescription(),
                                r.getOld_price(),
                                r.getNew_price(),
                                r.getDiscount_rate(),
                                r.getIs_favorite()
                        ));
                    }
                }
            }

            @Override
            public void onFailure(Call<List<RageResponseJson>> call, Throwable t) {
                Log.d(TAG, String.format("onFailure: get all task %s", t.getCause()));
            }
        });
    }

    //2.add newRage
    public void addNewRage(final RageComic r){
        RageResponseJson.ID id = new RageResponseJson.ID(r.getOid());
        RageResponseJson rageComic = new RageResponseJson(
                id,
                r.getName(),
                r.getUrl(),
                r.getDescription(),
                r.getOld_price(),
                r.getNew_price(),
                r.getDiscount_rate(),
                r.getIs_favorite()
        );

        rageManager.addNewRage(rageComic).enqueue(new Callback<RageResponseJson>() {
            @Override
            public void onResponse(Call<RageResponseJson> call, Response<RageResponseJson> response) {

            }

            @Override
            public void onFailure(Call<RageResponseJson> call, Throwable t) {

            }
        });
    }
}
