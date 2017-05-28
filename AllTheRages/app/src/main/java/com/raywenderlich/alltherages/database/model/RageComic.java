package com.raywenderlich.alltherages.database.model;

/**
 * Created by laptopTCC on 5/27/2017.
 */

public class RageComic {
    private String urlPic;
    private String name;
    private String description;
    private String url;

    public RageComic(String urlPic, String name, String description, String url) {
        this.urlPic = urlPic;
        this.name = name;
        this.description = description;
        this.url = url;
    }

    public String getUrlPic() {
        return urlPic;
    }

    public void setUrlPic(String urlPic) {
        this.urlPic = urlPic;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "RageComic{" +
                "urlPic='" + urlPic + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

}
