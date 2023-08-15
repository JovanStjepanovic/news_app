package com.cubes.stjepanovic.zavrsniprojekat.networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {


private static RetrofitClient instance;
private  Retrofit retrofit;




public static RetrofitClient getInstance(){

    if (instance==null){


        instance = new RetrofitClient();

    }

    return instance;
}



public Retrofit getRetrofit(){


    if (retrofit == null){


        retrofit= new Retrofit.Builder().baseUrl("https://komentar.rs/wp-json/api/").addConverterFactory(GsonConverterFactory.create()).build();

    }

    return  retrofit;
}






private RetrofitClient(){

}









}
