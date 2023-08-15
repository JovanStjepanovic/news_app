package com.cubes.stjepanovic.zavrsniprojekat.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cubes.stjepanovic.zavrsniprojekat.databinding.ActivityMenuHoroscopesBinding;
import com.cubes.stjepanovic.zavrsniprojekat.fragments.home.adapter.HomePageTopAdapter;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.latest.LatestResponse;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.home.News;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.newsdetail.NewsDetail;
import com.cubes.stjepanovic.zavrsniprojekat.networking.RetrofitClient;
import com.cubes.stjepanovic.zavrsniprojekat.networking.RetrofitService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuHoroscopesActivity extends AppCompatActivity {

   private ActivityMenuHoroscopesBinding binding;
   private HomePageTopAdapter adapter;
   private RetrofitService service;
   private static ArrayList<News>horoscopes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding=ActivityMenuHoroscopesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        adapter=new HomePageTopAdapter(null, new HomePageTopAdapter.RvTopClick() {
            @Override
            public void onClick(News news) {

                Intent intent = new Intent(getApplicationContext(), NewsDetailActivity.class);

               intent.putExtra("news",news);

                startActivity(intent);
            }
        });

        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

       loadData();


    }

    private void loadData(){

        service= RetrofitClient.getInstance().getRetrofit().create(RetrofitService.class);


        service.getSearchedNews("horoskop").enqueue(new Callback<LatestResponse>() {
            @Override
            public void onResponse(Call<LatestResponse> call, Response<LatestResponse> response) {

                horoscopes=response.body().data.news;


                adapter.setList(horoscopes);


                binding.progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<LatestResponse> call, Throwable t) {

                Toast.makeText(MenuHoroscopesActivity.this, "FAILED", Toast.LENGTH_SHORT).show();

            }
        });



    }



}