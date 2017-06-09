package com.raywenderlich.alltherages.database;

import android.content.Context;
import android.util.Log;

import com.raywenderlich.alltherages.database.model.RageComic;
import com.raywenderlich.alltherages.utils.SharedPref;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by laptopTCC on 5/27/2017.
 */

public class DBContext {
    private static final String TAG = DBContext.class.toString();
    public Realm realm;
    public static DBContext instance;
    //public List<RageComic> rageComics;

    private DBContext(Context context){
        //rageComics = new Vector<>();
        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }

    public static void setInstance(Context context) {
        instance = new DBContext(context);

    }

    public void DeleteAllRealm(){
        try {
            realm.close();
            Realm.deleteRealm(realm.getConfiguration());
            //Realm file has been deleted.
        } catch (Exception ex){
            ex.printStackTrace();
            //No Realm file to remove.
        }
    }

    //1. Get all Ragecomic
    public List<RageComic> getAllRageComic(){
        RealmResults<RageComic> allRageComics = realm.where(RageComic.class).findAll();
        Log.d(TAG,String.format("getAllRageComic:%s" ,allRageComics.toString()));
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
}
