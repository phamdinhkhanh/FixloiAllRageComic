package com.raywenderlich.alltherages.networks.jsonmodels;

import android.net.Uri;

import com.google.gson.annotations.SerializedName;

/**
 * Created by laptopTCC on 6/2/2017.
 */

public class UserRegisterResponseJson {
    @SerializedName("id")
    private String idUser;
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("total_spend")
    private String totalSpend;
    @SerializedName("_id")
    private Id Id;
    @SerializedName("token")
    private String token;

    public static class Id {

        @SerializedName("$oid")
        private String $oid;

        @Override
        public String toString() {
            return "Id{" +
                    "$oid='" + $oid + '\'' +
                    '}';
        }
        public String get$oid() {
            return $oid;
        }

    }

    public UserRegisterResponseJson(String idUser, String totalSpend, UserRegisterResponseJson.Id id) {
        this.idUser = idUser;
        this.totalSpend = totalSpend;
        this.Id = id;
    }

    public UserRegisterResponseJson(String username, String password, String token) {
        this.username = username;
        this.password = password;
        this.token = token;
    }

    public UserRegisterResponseJson(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserRegisterResponseJson(Uri linkUri, String token){
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getTotalSpend() {
        return totalSpend;
    }

    public void setTotalSpend(String totalSpend) {
        this.totalSpend = totalSpend;
    }

    public UserRegisterResponseJson.Id getId() {
        return Id;
    }

    public void setId(UserRegisterResponseJson.Id id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "UserRegisterResponseJson{" +
                "idUser='" + idUser + '\'' +
                ", totalSpend='" + totalSpend + '\'' +
                ", Id=" + Id +
                ", token='" + token + '\'' +
                '}';
    }

}
