package com.cubes.stjepanovic.zavrsniprojekat.activities.menuAdapters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cubes.stjepanovic.zavrsniprojekat.activities.NewsDetailActivity;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.ActivityCategoryListClickBinding;
import com.cubes.stjepanovic.zavrsniprojekat.model.categories.CategoriesResponse2;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.home.News;
import com.cubes.stjepanovic.zavrsniprojekat.networking.RetrofitClient;
import com.cubes.stjepanovic.zavrsniprojekat.networking.RetrofitService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryListClick extends AppCompatActivity {

    private ActivityCategoryListClickBinding binding;

    private int i;
    private RetrofitService service;
    private CategoryAdapter adapter;
    private ArrayList<News>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCategoryListClickBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        i= getIntent().getIntExtra("category",0);



        binding.imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



        loadData();

         adapter= new CategoryAdapter(null, new CategoryAdapter.RvTopClick() {
             @Override
             public void onClick(News news) {

                 Intent intent= new Intent(binding.getRoot().getContext(), NewsDetailActivity.class);

                 intent.putExtra("news", news);

                startActivity(intent);
             }
         });

         binding.recyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));
        binding.recyclerView.setAdapter(adapter);


    }


    private void loadData(){

        service= RetrofitClient.getInstance().getRetrofit().create(RetrofitService.class);



        service.getCategoryMenu(i,1,60).enqueue(new Callback<CategoriesResponse2>() {
            @Override
            public void onResponse(Call<CategoriesResponse2> call, Response<CategoriesResponse2> response) {

                list=response.body().data.news;


                adapter.setList(list);
                  binding.progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<CategoriesResponse2> call, Throwable t) {

            }
        });
    }


}