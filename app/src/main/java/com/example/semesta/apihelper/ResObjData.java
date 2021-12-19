package com.example.semesta.apihelper;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResObjData {

    @SerializedName("gid")
    @Expose
    private String gid;
    @SerializedName("uid")
    @Expose
    private Integer uid;
    @SerializedName("eid")
    @Expose
    private String eid;
    @SerializedName("ll")
    @Expose
    private String ll;
    @SerializedName("uname")
    @Expose
    private String uname;
    @SerializedName("logged_in")
    @Expose
    private Boolean loggedIn;
    @SerializedName("join")
    @Expose
    private String join;
    @SerializedName("avatar")
    @Expose
    private String avatar;

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getLl() {
        return ll;
    }

    public void setLl(String ll) {
        this.ll = ll;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getJoin() {
        return join;
    }

    public void setJoin(String join) {
        this.join = join;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
