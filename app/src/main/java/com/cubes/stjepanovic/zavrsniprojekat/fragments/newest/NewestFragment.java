package com.cubes.stjepanovic.zavrsniprojekat.fragments.newest;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cubes.stjepanovic.zavrsniprojekat.R;
import com.cubes.stjepanovic.zavrsniprojekat.fragments.home.adapter.HomePageTopAdapter;
import com.cubes.stjepanovic.zavrsniprojekat.activities.MenuActivity;
import com.cubes.stjepanovic.zavrsniprojekat.activities.NewsDetailActivity;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.FragmentNewestBinding;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.latest.LatestResponse;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.home.News;
import com.cubes.stjepanovic.zavrsniprojekat.networking.RetrofitClient;
import com.cubes.stjepanovic.zavrsniprojekat.networking.RetrofitService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NewestFragment extends Fragment {

    private FragmentNewestBinding binding;
    private ArrayList<News>newest;
    private HomePageTopAdapter adapter;
    private RetrofitService service;
    public NewestFragment() {

    }

    public static NewestFragment newInstance() {
        NewestFragment fragment = new NewestFragment();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding= FragmentNewestBinding.inflate(inflater,container,false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        adapter= new HomePageTopAdapter(null, new HomePageTopAdapter.RvTopClick() {
            @Override
            public void onClick(News news) {
                Intent intent = new Intent(binding.getRoot().getContext(), NewsDetailActivity.class);

                intent.putExtra("news",news);

                binding.getRoot().getContext().startActivity(intent);
            }
        });


        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));


        loadNewest();



        binding.imageViewMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               binding.getRoot().getContext().startActivity(new Intent(binding.getRoot().getContext(), MenuActivity.class));




            }
        });







    }


private void loadNewest(){


    service= RetrofitClient.getInstance().getRetrofit().create(RetrofitService.class);


    service.getLatestSecond(2).enqueue(new Callback<LatestResponse>() {
        @Override
        public void onResponse(Call<LatestResponse> call, Response<LatestResponse> response) {
            newest = response.body().data.news;


            adapter.setList(newest);



            binding.progressBar.setVisibility(View.GONE);
        }

        @Override
        public void onFailure(Call<LatestResponse> call, Throwable t) {
            Toast.makeText(binding.getRoot().getContext(), R.string.failed_to_load, Toast.LENGTH_SHORT).show();
        }
    });

}



}