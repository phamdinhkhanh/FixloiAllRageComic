package com.raywenderlich.alltherages.database;

import android.content.Context;

import com.raywenderlich.alltherages.database.model.RageComic;
import com.raywenderlich.alltherages.utils.SharedPref;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by laptopTCC on 5/27/2017.
 */

public class DBContext {
    private static final String TAG = DBContext.class.toString();
    private Realm realm;
    public static DBContext instance;
    private List<RageComic> rageComics;

    private DBContext(Context context){
        rageComics = new Vector<>();
        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }

    public static void setInstance(Context context) {
        instance = new DBContext(context);
    }

    //1. Get all Ragecomic
    public List<RageComic> getAllRageComic(){
        RealmResults<RageComic> allRageComics = realm.where(RageComic.class).findAll();
        return allRageComics;
    }

    //5.Get a RageComic
    public RageComic findRageComic(RageComic rageComic){
        //realm.beginTransaction();
        RageComic aRageComic = realm.where(RageComic.class).equalTo("name",rageComic.getName()).findFirst();
        //realm.commitTransaction();
        return aRageComic;
    }

    //2. Delete a Ragecomic
    public void deleteRageComic(RageComic rageComic){
        realm.beginTransaction();
        RealmResults<RageComic> delRageComics = realm.where(RageComic.class).equalTo("name",rageComic.getName()).findAll();
        if(delRageComics != null){
            for(RageComic r: delRageComics){
                r.deleteFromRealm();
            }
            realm.commitTransaction();
        }
    }

    //3. Add or update a RageComic
    public <T> void addOrUpdate(T t){
        realm.beginTransaction();
        realm.copyToRealmOrUpdate((RealmObject) t);
        realm.commitTransaction();
    }

    //4.Add a RageComic
    public <T> void add(T t){
        realm.beginTransaction();
        realm.copyToRealm((RealmObject) t);
        realm.commitTransaction();
    }

    public void cleanCart() {
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
        SharedPref.instance.getSharedPreferences().edit().putInt("COUNT", 0).commit();
    }

    public static final List<RageComic> getAllRage(){
        List<RageComic> rageComics = new ArrayList<>();
        rageComics.add(new RageComic("https://fimgs.net/images/perfume/nd.7222.jpg",
                "Sophie Guerlain","I'm Sophie Guerlain","https://www.fragrantica.com/perfume/Guerlain/Les-Secrets-de-Sophie-7222.html"));
        rageComics.add(new RageComic("https://fimgs.net/images/perfume/nd.53.jpg",
                "Shalimar Guerlain","I'm Shalimar Guerlain","https://www.fragrantica.com/perfume/Guerlain/Shalimar-53.html"
                ));
        rageComics.add(new RageComic("https://fimgs.net/images/perfume/nd.608.jpg",
                "Chanel N°5","I'm Chanel N°5","https://www.fragrantica.com/perfume/Chanel/Chanel-N-5-608.html"
        ));

        rageComics.add(new RageComic("https://fimgs.net/images/perfume/nd.207.jpg",
                "Mitsouko","I'm Mitsouko","https://www.fragrantica.com/perfume/Guerlain/Mitsouko-Eau-de-Toilette-207.html"
        ));
        return rageComics;
    }
}
