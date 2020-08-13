package com.example.androidshaper.retrofitpostfromurlencode;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        OurRetrofitClient ourRetrofitClient=retrofit.create(OurRetrofitClient.class);

        Call<ObjectClass> call=ourRetrofitClient.createUser(102,"I am rakib","Resume");
        call.enqueue(new Callback<ObjectClass>() {
            @Override
            public void onResponse(Call<ObjectClass> call, Response<ObjectClass> response) {
                if(response.isSuccessful())
                {
                    Log.d("Response", "onResponse: Success ");
                    Log.d("Id", "onResponse: "+String.valueOf(response.body().getUserId()));
                    Log.d("Title", "onResponse: "+response.body().getTitle());
                    Log.d("Body", "onResponse: "+response.body().getBody());
                }
                else{
                    Log.d("Response", "onResponse: not Success ");
                }
            }

            @Override
            public void onFailure(Call<ObjectClass> call, Throwable t) {

                Log.d("Error", "onFailure: message");


            }
        });
    }
}