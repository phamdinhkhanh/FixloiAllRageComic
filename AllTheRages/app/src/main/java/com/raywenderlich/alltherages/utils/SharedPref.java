package com.raywenderlich.alltherages.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by laptopTCC on 5/27/2017.
 */

public class SharedPref {
    private final String KEY_PREF = "rageComic";
    private final String URL_PIC = "urlpic";
    private final String NAME = "name";
    private final String DESCRIPTION= "description";
    private final String URL = "url";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    private SharedPref(Context context){
        sharedPreferences = context.getSharedPreferences(
                KEY_PREF, Context.MODE_PRIVATE);
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    private void putUrlPic(String urlpic){
        editor.putString(URL_PIC,urlpic);
    }

    private void putName(String name){
        editor.putString(NAME, name);
    }
    private void putDescription(String description){
        editor.putString(DESCRIPTION,description);
    }
    private void putUrl(String url){
        editor.putString(URL,url);
    }
    public String getUrlPic(){
        return sharedPreferences.getString(URL_PIC,null);
    }
    public String getName(){
        return sharedPreferences.getString(NAME,null);
    }
    public String getDescription(){
        return sharedPreferences.getString(DESCRIPTION,null);
    }
    public String getUrl(){
        return sharedPreferences.getString(URL,null);
    }
}
