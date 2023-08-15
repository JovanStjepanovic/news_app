package com.cubes.stjepanovic.zavrsniprojekat.networking;

import com.cubes.stjepanovic.zavrsniprojekat.model.GalleryResponse;
import com.cubes.stjepanovic.zavrsniprojekat.model.categories.CategoriesResponse;
import com.cubes.stjepanovic.zavrsniprojekat.model.categories.CategoriesResponse2;
import com.cubes.stjepanovic.zavrsniprojekat.model.comments.CommentResponse;
import com.cubes.stjepanovic.zavrsniprojekat.model.horoscope.DataHoroscopeResponse;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.home.DataResponse;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.video.DataVideoResponse;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.latest.LatestResponse;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.newsdetail.NewsDetailResponse;
import com.cubes.stjepanovic.zavrsniprojekat.model.weather.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {


    @GET("categories")
    Call<CategoriesResponse>getCategories();

    @GET("homepage")
    Call<DataResponse>getHomePageData();

    @GET("horoscope")
    Call<DataHoroscopeResponse>getHoroscope();


    @GET("videos")
    Call<DataVideoResponse>getVideo();


    @GET("weather")
    Call<WeatherResponse>getWeather();



    @GET("latest")
    Call<LatestResponse>getLatestSecond(@Query("page") int page);


    @GET("search")
    Call<LatestResponse>getSearchedNews(@Query("search_parameter") String search_parameter);



    @GET("newsdetails")
    Call<NewsDetailResponse>getNewsDetail(@Query("id") int id);



    @GET("comments")
    Call<CommentResponse>getComments(@Query("id") int id);


  @FormUrlEncoded
  @POST("commentinsert")
   Call<CommentResponse>postComment(@Field("name") String name, @Field("content")String content, @Field("news") int news);

    @FormUrlEncoded
    @POST("commentinsert")
    Call<CommentResponse>postReply(@Field("name") String name, @Field("content")String content, @Field("parent_comment") int parent_comment);




    @FormUrlEncoded
    @POST("commentvote")
    Call<CommentResponse>upVoteComment(@Field("comment") int comment, @Query("vote") boolean vote);

    @FormUrlEncoded
    @POST("commentvote")
    Call<CommentResponse>downVoteComment(@Field("comment") int comment, @Query("downvote") boolean downvote);




    @GET("gallery/{id}")
    Call<GalleryResponse>getGallery(@Path("id") int id);




    @GET("category/{id}")
    Call<CategoriesResponse2>getCategoryMenu(@Path("id") int id, @Query("page")int page, @Query("per_page")int per_page);







}
