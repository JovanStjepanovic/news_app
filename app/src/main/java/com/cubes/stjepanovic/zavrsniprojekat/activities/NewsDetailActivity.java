package com.cubes.stjepanovic.zavrsniprojekat.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cubes.stjepanovic.zavrsniprojekat.activities.newsdetailAdapter.NewsDetailAdapter;
import com.cubes.stjepanovic.zavrsniprojekat.R;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.ActivityNewsDetailBinding;
import com.cubes.stjepanovic.zavrsniprojekat.model.comments.Comment;
import com.cubes.stjepanovic.zavrsniprojekat.model.comments.CommentResponse;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.home.News;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.newsdetail.NewsDetailResponse;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.newsdetail.Tag;
import com.cubes.stjepanovic.zavrsniprojekat.networking.RetrofitClient;
import com.cubes.stjepanovic.zavrsniprojekat.networking.RetrofitService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsDetailActivity extends AppCompatActivity {

    private ActivityNewsDetailBinding binding;
  private RetrofitService service;
  private News news;


  private static ArrayList<Comment>allComments;
  private static ArrayList<Comment>firstCoupleOfComments;


  private NewsDetailAdapter adapter;

     private static ArrayList<News>related_news;
    private static ArrayList<Tag>tags;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityNewsDetailBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());



        news= (News) getIntent().getSerializableExtra("news");


        adapter= new NewsDetailAdapter(news, null, null, null, new NewsDetailAdapter.RvonGalleryclick() {
            @Override
            public void onGalleryClick() {

              Intent intent = new Intent(binding.getRoot().getContext(),GalleryActivity.class);

             intent.putExtra("news",news);

                startActivity(intent);
            }
        });


       binding.recyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));

       binding.recyclerView.setAdapter(adapter);


      binding.imageViewShare.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

            Intent intent = new Intent(Intent.ACTION_SEND);

            intent.setType("text/plain");

           intent.putExtra(Intent.EXTRA_TEXT,news.url);


           startActivity(Intent.createChooser(intent,"share"));

          }
      });






        loadData();



        binding.imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

         binding.imageViewComments.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {


                 Intent   intent= new Intent(binding.getRoot().getContext(), AddCommentActivity.class);


                intent.putExtra("news", news);


              binding.getRoot().getContext().startActivity(intent);



             }
         });







    }



   public void loadData() {

       loadComments();



service= RetrofitClient.getInstance().getRetrofit().create(RetrofitService.class);

    service.getNewsDetail(news.id).enqueue(new Callback<NewsDetailResponse>() {
        @Override
        public void onResponse(Call<NewsDetailResponse> call, Response<NewsDetailResponse> response) {







           related_news=response.body().data.related_news;

           tags=response.body().data.tags;




                adapter.setList(news,tags,related_news,allComments,firstCoupleOfComments);



                binding.progressBar.setVisibility(View.GONE);

        }

        @Override
        public void onFailure(Call<NewsDetailResponse> call, Throwable t) {
            Toast.makeText(binding.getRoot().getContext(), R.string.failed_to_load, Toast.LENGTH_SHORT).show();
        }
    });

}

public  void loadComments(){

        service= RetrofitClient.getInstance().getRetrofit().create(RetrofitService.class);

        service.getComments(1667).enqueue(new Callback<CommentResponse>() {
            @Override
            public void onResponse(Call<CommentResponse> call, Response<CommentResponse> response) {
                allComments = response.body().data;


                  if (allComments != null && allComments.size()>3) {

                     firstCoupleOfComments= new ArrayList<>();

                      firstCoupleOfComments.add(allComments.get(0));

                      firstCoupleOfComments.add(allComments.get(1));

                      firstCoupleOfComments.add(allComments.get(2));




                  }





            }

            @Override
            public void onFailure(Call<CommentResponse> call, Throwable t) {
                Toast.makeText(binding.getRoot().getContext(), R.string.failed_to_load, Toast.LENGTH_SHORT).show();
            }
        });

    }




}