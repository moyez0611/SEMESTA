package com.example.semesta.apihelper;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ResObj {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("data")
    @Expose
    private ResObjData data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ResObjData getData() {
        return data;
    }

    public void setData(ResObjData data) {
        this.data = data;
    }

}

