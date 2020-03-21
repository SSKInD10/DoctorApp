package com.sskind.doctor.Retrofit;

import com.sskind.doctor.Patient;

import org.json.JSONObject;

import java.util.HashMap;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface IUploadAPI {

    String ENDPOINT = "http://192.168.43.16";

    //@Headers("Content-Type: application/json")
    @POST("/api/upload")
    Call<String> uploadFile(@Body JSONObject body);

}
