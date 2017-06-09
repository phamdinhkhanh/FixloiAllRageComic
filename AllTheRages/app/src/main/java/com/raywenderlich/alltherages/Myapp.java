package com.raywenderlich.alltherages;

import android.app.Application;

import com.raywenderlich.alltherages.database.DBContext;
import com.raywenderlich.alltherages.utils.SharedPref;

/**
 * Created by laptopTCC on 6/8/2017.
 */

public class Myapp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SharedPref.setInstance(this);
        DBContext.setInstance(this);
    }
}
