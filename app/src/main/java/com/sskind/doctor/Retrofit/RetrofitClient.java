package com.sskind.doctor.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofitClient=null;

    public static Retrofit getClient(){
        if(retrofitClient==null){
            retrofitClient=new Retrofit.Builder()
                    .baseUrl("http://192.168.43.53:5000")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
        }
        return retrofitClient;
    }
}
