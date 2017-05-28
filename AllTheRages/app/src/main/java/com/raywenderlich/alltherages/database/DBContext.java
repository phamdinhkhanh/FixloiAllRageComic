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
        rageComics.add(new RageComic("http://i3.kym-cdn.com/photos/images/original/000/030/404/1260585284155.png",
                "cereal-guy","I'm cereal-guy","http://knowyourmeme.com/memes/cereal-guy"));
        rageComics.add(new RageComic("http://i2.kym-cdn.com/photos/images/original/000/039/879/Fuck_Yea.PNG",
                "fck-yea","I'm fck-yea guy","http://knowyourmeme.com/memes/fuck-yea--5"
                ));
        return rageComics;
    }
}
