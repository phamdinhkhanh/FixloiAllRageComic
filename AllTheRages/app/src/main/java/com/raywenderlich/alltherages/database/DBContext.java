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
        rageComics.add(new RageComic("https://fimgs.net/images/perfume/nd.7222.jpg",
                "Sophie Guerlain","Sophie Guerlain","https://www.fragrantica.com/perfume/Guerlain/Les-Secrets-de-Sophie-7222.html"));
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
