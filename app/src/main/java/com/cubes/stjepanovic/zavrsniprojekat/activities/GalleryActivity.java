package com.cubes.stjepanovic.zavrsniprojekat.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cubes.stjepanovic.zavrsniprojekat.GalleryAdapter;
import com.cubes.stjepanovic.zavrsniprojekat.R;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.ActivityGalleryBinding;
import com.cubes.stjepanovic.zavrsniprojekat.model.Gallery;
import com.cubes.stjepanovic.zavrsniprojekat.model.GalleryResponse;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.home.News;
import com.cubes.stjepanovic.zavrsniprojekat.networking.RetrofitClient;
import com.cubes.stjepanovic.zavrsniprojekat.networking.RetrofitService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryActivity extends AppCompatActivity {

  private ActivityGalleryBinding binding;
  private GalleryAdapter adapter;
  private RetrofitService service;
  private ArrayList<Gallery>galleries;

  private News news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      binding=ActivityGalleryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        news= (News) getIntent().getSerializableExtra("news");

          adapter= new GalleryAdapter(null);


             binding.recyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));
             binding.recyclerView.setAdapter(adapter);


            loadGallery();




            binding.imageViewBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    onBackPressed();
                }
            });




    }

    private void loadGallery(){

        service= RetrofitClient.getInstance().getRetrofit().create(RetrofitService.class);

        //Proseđeno 1386 kao primer , jer mnoge vesti nemaju galeriju, inače ovde proslediti news.id

        service.getGallery(1386).enqueue(new Callback<GalleryResponse>() {
            @Override
            public void onResponse(Call<GalleryResponse> call, Response<GalleryResponse> response) {

             galleries=response.body().data;


             adapter.setList(galleries);

              binding.progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<GalleryResponse> call, Throwable t) {
                Toast.makeText(binding.getRoot().getContext(), R.string.failed_to_load, Toast.LENGTH_SHORT).show();
            }
        });



    }




}