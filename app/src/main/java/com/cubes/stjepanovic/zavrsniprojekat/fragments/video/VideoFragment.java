package com.cubes.stjepanovic.zavrsniprojekat.fragments.video;

import android.content.Intent;
import android.net.Uri;
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
import com.cubes.stjepanovic.zavrsniprojekat.fragments.home.adapter.HomePageVideoAdapter;
import com.cubes.stjepanovic.zavrsniprojekat.activities.MenuActivity;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.FragmentVideoBinding;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.video.DataVideoResponse;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.home.News;
import com.cubes.stjepanovic.zavrsniprojekat.networking.RetrofitClient;
import com.cubes.stjepanovic.zavrsniprojekat.networking.RetrofitService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class VideoFragment extends Fragment {

    private FragmentVideoBinding binding;
    private HomePageVideoAdapter adapter;
    private RetrofitService service;

    private static ArrayList<News>videos;


    public VideoFragment() {

    }


    public static VideoFragment newInstance() {
        VideoFragment fragment = new VideoFragment();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentVideoBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


       adapter= new HomePageVideoAdapter(null, new HomePageVideoAdapter.RvVideoClick() {
           @Override
           public void OnVideoClick(News news) {

               Intent intent= new Intent(Intent.ACTION_VIEW);

               intent.setData(Uri.parse(news.url));

              binding.getRoot().getContext().startActivity(intent);

           }
       });


        binding.progressBar.setVisibility(View.VISIBLE);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));
        binding.recyclerView.setAdapter(adapter);


      loadVideos();


            binding.imageViewMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    startActivity(new Intent(binding.getRoot().getContext(), MenuActivity.class));
                }
            });




    }

public void loadVideos(){


    service= RetrofitClient.getInstance().getRetrofit().create(RetrofitService.class);


    service.getVideo().enqueue(new Callback<DataVideoResponse>() {
        @Override
        public void onResponse(Call<DataVideoResponse> call, Response<DataVideoResponse> response) {

           videos=response.body().data.news;


           adapter.setList(videos);

           binding.progressBar.setVisibility(View.GONE);

        }

        @Override
        public void onFailure(Call<DataVideoResponse> call, Throwable t) {
            Toast.makeText(binding.getRoot().getContext(), R.string.failed_to_load, Toast.LENGTH_SHORT).show();
        }
    });


}


}


