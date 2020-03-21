package com.sskind.doctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sskind.doctor.Retrofit.IUploadAPI;
import com.sskind.doctor.Retrofit.RetrofitClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.Timestamp;
import java.util.HashMap;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class TemplateActivity extends AppCompatActivity {

    private EditText name,age,gender,symptom,pre_diagnosis,curr_diagnosis,drug_name1,drug_name2,dosage1,dosage2;
    private EditText dosage3,drug_name3,duration1,duration2,duration3,advice;
    private String s_name,s_age,s_gender,s_symptom,s_pre_diagnosis,s_curr_diagnosis,s_drug_name1,s_drug_name2,s_drug_name3,s_dosage1,s_dosage2;
    private String s_dosage3,s_duration1,s_duration2,s_duration3,s_advice;
    private TextView result_txt;
    private Button confirm_btn,cancel_btn;
    String res;

    IUploadAPI mService;

    private IUploadAPI getAPIUpload(){
        return RetrofitClient.getClient().create(IUploadAPI.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);
        //Recording.mIsRecording=false;

        final JSONObject patient=new JSONObject();
        //final JSONObject patient=new JSONObject();

        name=findViewById(R.id.edit_name);
        age=findViewById(R.id.edit_age);
        gender=findViewById(R.id.edit_gender);
        symptom=findViewById(R.id.edit_symptom);
        pre_diagnosis=findViewById(R.id.edit_diagnosis);
        curr_diagnosis=findViewById(R.id.edit_diagnosis_curr);
        drug_name1=findViewById(R.id.edit_drug1);
        drug_name2=findViewById(R.id.edit_drug2);
        drug_name3=findViewById(R.id.edit_drug3);
        dosage1=findViewById(R.id.edit_dosage1);
        dosage2=findViewById(R.id.edit_dosage2);
        dosage3=findViewById(R.id.edit_dosage3);
        duration1=findViewById(R.id.edit_duration1);
        duration2=findViewById(R.id.edit_duration2);
        duration3=findViewById(R.id.edit_duration3);
        advice=findViewById(R.id.edit_advice);
        result_txt=findViewById(R.id.result_text);

        confirm_btn=findViewById(R.id.confirm_btn);
        cancel_btn=findViewById(R.id.cancel_btn);

        /*mService = getAPIUpload();

        final MultipartBody.Part body= MultipartBody.Part.createFormData("object",patient.toString());

        new Thread(new Runnable(){

            @Override
            public void run() {
                mService.uploadFile(body)
                        .enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
                                if(!response.isSuccessful()){
                                    Toast.makeText(TemplateActivity.this,"Response Successful",Toast.LENGTH_SHORT).show();
                                }

                                String result=response.body();

                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {
                                Toast.makeText(TemplateActivity.this, "Server"+t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

            }
        }).start();

*/

        confirm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                s_name=name.getText().toString();
                if(s_name.matches("")){
                    name.setHint(R.string.pname);
                }else{

            try {
                    patient.put("name",s_name);
            } catch (JSONException e) {
                e.printStackTrace();
            }
                }

                s_age=age.getText().toString();
                if(s_age.matches("")){
                    age.setHint(R.string.age);
                }else{

            try {
                patient.put("age",s_age);
            } catch (JSONException e) {

                e.printStackTrace();
            }
                }

                s_gender=gender.getText().toString();
                if(s_gender.matches("")){
                    gender.setHint(R.string.gender);
                }else{

            try {
                patient.put("gender",s_gender);
            } catch (JSONException e) {
                e.printStackTrace();
            }
                }

                s_symptom=symptom.getText().toString();
                if(s_symptom.matches("")){
                    symptom.setHint(R.string.symptoms);
                }else{

            try {
                patient.put("symptoms",s_symptom);
            } catch (JSONException e) {
                e.printStackTrace();
            }
                }

                s_pre_diagnosis=pre_diagnosis.getText().toString();
                if(s_pre_diagnosis.matches("")){
                    pre_diagnosis.setHint(R.string.diagnosis);
                }else{

            try {
                patient.put("prelim_diagnosis",s_pre_diagnosis);
            } catch (JSONException e) {
                e.printStackTrace();
            }
                }

                s_curr_diagnosis=curr_diagnosis.getText().toString();
                if(s_curr_diagnosis.matches("")){
                    curr_diagnosis.setHint(R.string.diagnosis_curr);
                }else{
            try {
                patient.put("current_diagnosis",s_curr_diagnosis);
            } catch (JSONException e) {
                e.printStackTrace();
            }
                }

                s_advice=advice.getText().toString();
                if(s_advice.matches("")){
                    advice.setHint(R.string.advice);
                }else{

            try {
                  patient.put("advice",s_advice);
            } catch (JSONException e) {
                e.printStackTrace();
            }
                }

                s_drug_name1=drug_name1.getText().toString();
                if(s_drug_name1.matches("")){
                    drug_name1.setHint(R.string.drug1);
                    s_drug_name1="";
                }else{

            try {
                    patient.put("drug1",s_drug_name1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
                }

                s_drug_name2=drug_name2.getText().toString();
                if(s_drug_name2.matches("")){
                    drug_name2.setHint(R.string.drug2);
                }else{

            try {
                    patient.put("drug2",s_drug_name2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
                }

                s_drug_name3=drug_name3.getText().toString();
                if(s_drug_name3.matches("")){
                    drug_name3.setHint(R.string.drug3);
                }else{

            try {
                patient.put("drug3",s_drug_name3);
                drug_name3.setText(s_drug_name3);
            } catch (JSONException e) {
                e.printStackTrace();
            }
                }

                s_dosage1=dosage1.getText().toString();
                if(s_dosage1.matches("")){
                    dosage1.setHint(R.string.dosage1);
                }else{

            try {
                      patient.put("dosage1",s_dosage1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
                }

                s_dosage2=dosage2.getText().toString();
                if(s_dosage2.matches("")){
                    dosage2.setHint(R.string.dosage2);
                }else{

            try {
                patient.put("dosage2",s_dosage2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
                }

                s_dosage3=dosage3.getText().toString();
                if(s_dosage3.matches("")){
                    dosage3.setHint(R.string.dosage3);
                }else{

            try {
                patient.put("dosage3",s_dosage3);
            } catch (JSONException e) {
                e.printStackTrace();
            }
                }

                s_duration1=duration1.getText().toString();
                if(s_duration1.matches("")){
                    duration1.setHint(R.string.duration1);
                }else{

            try {
                patient.put("duration1",s_duration1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
                }

                s_duration2=duration2.getText().toString();
                if(s_duration2.matches("")){
                    duration2.setHint(R.string.duration2);
                }else{

                try {
                patient.put("duration2",s_duration2);
                } catch (JSONException e) {
                e.printStackTrace();
                }
                }

                s_duration3=duration3.getText().toString();
                if(s_duration3.matches("")){
                    duration3.setHint(R.string.duration3);
                }else{


            try {
                     patient.put("duration3",s_duration3);
                //Toast.makeText(this, ""+s_duration3, Toast.LENGTH_SHORT).show();
                //result_txt.setVisibility(View.VISIBLE);
                //result_txt.setText(s_duration3);
            } catch (JSONException e) {
                e.printStackTrace();
            }
                }


                //Toast.makeText(TemplateActivity.this, ""+patient.get("drug2"), Toast.LENGTH_SHORT).show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.16:5000")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IUploadAPI service = retrofit.create(IUploadAPI.class);

        Call<String> call=service.uploadFile(patient);
        //Call<String> call=service.uploadFile(new Patient(s_name,s_age,s_gender,s_symptom,s_pre_diagnosis,s_curr_diagnosis,s_drug_name1,s_drug_name2,
         //       s_dosage1,s_dosage2,s_dosage3,s_drug_name3,s_duration1,s_duration2,s_duration3,s_advice));

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(TemplateActivity.this,"Not Successful! Retry after sometime",Toast.LENGTH_SHORT).show();
                }else{
                    //result_txt.setVisibility(View.VISIBLE);
                    //result_txt.setText(response.body().toString());
                    Toast.makeText(TemplateActivity.this,"Sent Successfully",Toast.LENGTH_SHORT).show();

                    Intent temp=new Intent(TemplateActivity.this,NextActivity.class);
                    startActivity(temp);
                    finish();
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(TemplateActivity.this,"Server error:"+t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });


            }
        });

        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TemplateActivity.this, "Closing Application", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
      //  Recording.mIsRecording=false;
    }
}
