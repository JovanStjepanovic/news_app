package com.cubes.stjepanovic.zavrsniprojekat.fragments.search;

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
import com.cubes.stjepanovic.zavrsniprojekat.activities.MenuActivity;
import com.cubes.stjepanovic.zavrsniprojekat.activities.NewsDetailActivity;
import com.cubes.stjepanovic.zavrsniprojekat.fragments.search.adapter.SearchAdapter;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.FragmentSearchBinding;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.latest.LatestResponse;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.home.News;
import com.cubes.stjepanovic.zavrsniprojekat.networking.RetrofitClient;
import com.cubes.stjepanovic.zavrsniprojekat.networking.RetrofitService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SearchFragment extends Fragment {

 private FragmentSearchBinding binding;
 private RetrofitService service;
 private static ArrayList<News>allNews = new ArrayList<>();

 private SearchAdapter adapter;






    public SearchFragment() {

    }


    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();

        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       binding=FragmentSearchBinding.inflate(inflater,container,false);

        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



          adapter= new SearchAdapter(null);


          adapter.setListener(new SearchAdapter.SearchClick() {
              @Override
              public void onClick(News news) {

                  Intent intent= new Intent(binding.getRoot().getContext(), NewsDetailActivity.class);

                  intent.putExtra("news", news);

                  binding.getRoot().getContext().startActivity(intent);

              }
          });




          binding.recyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));



         binding.recyclerView.setAdapter(adapter);


        binding.imageviewSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (binding.editTextSearch.getText().length()>3) {


                    service= RetrofitClient.getInstance().getRetrofit().create(RetrofitService.class);




                    service.getSearchedNews(binding.editTextSearch.getText().toString().toLowerCase()).enqueue(new Callback<LatestResponse>() {
                        @Override
                        public void onResponse(Call<LatestResponse> call, Response<LatestResponse> response) {

                            allNews =response.body().data.news;


                            adapter.setList(allNews);
                        }

                        @Override
                        public void onFailure(Call<LatestResponse> call, Throwable t) {

                            Toast.makeText(binding.getRoot().getContext(), R.string.failed_to_load, Toast.LENGTH_SHORT).show();
                        }
                    });
                }



                else {


                    Toast.makeText(binding.getRoot().getContext(), "Morate uneti minimum 4 karaktera", Toast.LENGTH_SHORT).show();
                }






            }
        });



      binding.imageViewMenu.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              binding.getRoot().getContext().startActivity(new Intent(binding.getRoot().getContext(), MenuActivity.class));
          }
      });




    }


}