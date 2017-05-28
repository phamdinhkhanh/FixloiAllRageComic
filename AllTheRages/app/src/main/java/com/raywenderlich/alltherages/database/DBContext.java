package com.raywenderlich.alltherages.database;

import com.raywenderlich.alltherages.database.model.RageComic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laptopTCC on 5/27/2017.
 */

public class DBContext {
    //public static DBContext instance = new DBContext();

    public static final List<RageComic> getAllRage(){
        List<RageComic> rageComics = new ArrayList<>();
        rageComics.add(new RageComic(
                "cereal-guy","I'm cereal-guy"));
        rageComics.add(new RageComic(
                "fck-yea","I'm fck-yea guy"
                ));
        return rageComics;
    }
}
