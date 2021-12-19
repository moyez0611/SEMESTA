package com.example.semesta.apihelper;

public class ApiUtils {

    //public static final String api_url = Resources.getSystem().getString(R.string.api_server);

    public static final String BASE_URL = "http://192.168.3.6:8080/user/";

    public static UserService getUserService(){
        return RetrofitClient.getClient(BASE_URL).create(UserService.class);
    }
}
