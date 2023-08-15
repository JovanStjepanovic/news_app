package com.cubes.stjepanovic.zavrsniprojekat.fragments.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cubes.stjepanovic.zavrsniprojekat.R;
import com.cubes.stjepanovic.zavrsniprojekat.fragments.home.adapter.HomePageCategoriesAdapter;
import com.cubes.stjepanovic.zavrsniprojekat.fragments.home.adapter.HomePagePrimaryAdapter;
import com.cubes.stjepanovic.zavrsniprojekat.activities.MenuActivity;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.FragmentHomeBinding;
import com.cubes.stjepanovic.zavrsniprojekat.model.categories.CategoriesResponse;
import com.cubes.stjepanovic.zavrsniprojekat.model.categories.Category;
import com.cubes.stjepanovic.zavrsniprojekat.model.horoscope.DataHoroscopeResponse;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.home.DataResponse;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.video.DataVideoResponse;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.home.HomePageNewsByCategory;
import com.cubes.stjepanovic.zavrsniprojekat.model.horoscope.Horoscope;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.home.News;
import com.cubes.stjepanovic.zavrsniprojekat.networking.RetrofitClient;
import com.cubes.stjepanovic.zavrsniprojekat.networking.RetrofitService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

private FragmentHomeBinding binding;

private HomePagePrimaryAdapter adapter;

private RetrofitService service;


private static ArrayList<News>slider;
private static ArrayList<News>top;
private static ArrayList<News>editors_choice;
private static ArrayList<News>latest;
private static ArrayList<News>most_read;
private static ArrayList<News>most_commented;
private static ArrayList<News>videosHomePage;
private static ArrayList<HomePageNewsByCategory>categoires;
private static ArrayList<Category>horizontalCategories= new ArrayList<>();



private static ArrayList<News>aktuelno = new ArrayList<>();
private static ArrayList<News>drustvo= new ArrayList<>();
private static ArrayList<News>svet= new ArrayList<>();
private static ArrayList<News>region= new ArrayList<>();
private  static ArrayList<News>sport= new ArrayList<>();
private  static ArrayList<News>zabava= new ArrayList<>();
private static ArrayList<News>beograd= new ArrayList<>();
private static ArrayList<News>kultura= new ArrayList<>();
private static ArrayList<News>ekonomija= new ArrayList<>();
private static ArrayList<News>politika= new ArrayList<>();


    private static ArrayList<News>filteredAktuelno = new ArrayList<>();
    private static ArrayList<News>filteredDrustvo= new ArrayList<>();
    private static ArrayList<News>filteredSvet= new ArrayList<>();
    private static ArrayList<News>filteredRegion= new ArrayList<>();
    private  static ArrayList<News>filteredSport= new ArrayList<>();
    private  static ArrayList<News>filteredZabava= new ArrayList<>();
    private static ArrayList<News>filteredBeograd= new ArrayList<>();
    private static ArrayList<News>filteredKultura= new ArrayList<>();
    private static ArrayList<News>filteredEkonomija= new ArrayList<>();
    private static ArrayList<News>filteredPolitika= new ArrayList<>();

    private static ArrayList<News>filteredVesti= new ArrayList<>();



   private static ArrayList<Horoscope>horoscopes= new ArrayList<>() ;
    private static ArrayList<News>allVideos= new ArrayList<>();

   private static ArrayList<News>filterHelper2= new ArrayList<>();




  private HomePageCategoriesAdapter adapter3;









    private static ArrayList<News>filterHelper= new ArrayList<>();




    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentHomeBinding.inflate(inflater,container,false);

        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);






            loadData();












        adapter3= new HomePageCategoriesAdapter(null, new HomePageCategoriesAdapter.RvItemClick() {
                   @Override
                   public void onItemClick(String name, int position) {


                       if (name.equalsIgnoreCase("Naslonva")){

                           adapter.sendSecondList(aktuelno,drustvo,svet,region,sport,zabava,beograd,kultura,ekonomija,politika);
                           adapter.setList(slider,top,editors_choice,latest,most_read,most_commented,videosHomePage,horizontalCategories);


                           adapter.sendFilteredLists(null,null,null,
                                   null,null,null,null,
                                   null,null,null,null,null,null);



                       }



                       else   if (name.equalsIgnoreCase("Aktuelno")){






                           adapter.sendFilteredLists(filteredAktuelno,null,null,
                                   null,null,null,null,
                                   null,null,null,null,null,null);


                       }
                       else   if (name.equalsIgnoreCase("Beograd")){


                           adapter.sendFilteredLists(null,null,null,
                                   null,null,null,filteredBeograd,
                                   null,null,null,null,null,null);





                       }
                       else    if (name.equalsIgnoreCase("Društvo")){
                           adapter.sendFilteredLists(null,filteredDrustvo,null,
                                   null,null,null,null,
                                   null,null,null,null,null,null);



                       }



                       else if (name.equalsIgnoreCase("Ekonomija")){
                           adapter.sendFilteredLists(null,null,null,
                                   null,null,null,null,
                                   null,filteredEkonomija,null,null,null,null);



                       }

                       else     if (name.equalsIgnoreCase("Horoskop")){

                           adapter.sendFilteredLists(null,null,null,
                                   null,null,null,null,
                                   null,null,null,null,horoscopes,null);




                       }

                       else   if (name.equalsIgnoreCase("Kultura")) {

                           adapter.sendFilteredLists(null,null,null,
                                   null,null,null,null,
                                   filteredKultura,null,null,null,null,null);


                       }

                       else   if (name.equalsIgnoreCase("Politika")){

                           adapter.sendFilteredLists(null,null,null,
                                   null,null,null,null,
                                   null,null,filteredPolitika,null,null,null);



                       }

                       else   if (name.equalsIgnoreCase("Region")){

                           adapter.sendFilteredLists(null,null,null,
                                   filteredRegion,null,null,null,
                                   null,null,null,null,null,null);



                       }
                       else   if (name.equalsIgnoreCase("Sport")){

                           adapter.sendFilteredLists(null,null,null,
                                   null,filteredSport,null,null,
                                   null,null,null,null,null,null);



                       }
                       else   if (name.equalsIgnoreCase("Svet")){

                           adapter.sendFilteredLists(null,null,filteredSvet,
                                   null,null,null,null,
                                   null,null,null,null,null,null);



                       }
                       else   if (name.equalsIgnoreCase("Vesti")){



                           adapter.sendFilteredLists(null,null,null,
                                   null,null,null,null,
                                   null,null,null,filteredVesti,null,null);





                       }
                       else   if (name.equalsIgnoreCase("Video/Intervju")){





                           adapter.sendFilteredLists(null,null,null,
                                   null,null,null,null,
                                   null,null,null,null,null,allVideos);


                       }

                       else   if (name.equalsIgnoreCase("Zabava")){

                           adapter.sendFilteredLists(null,null,null,
                                   null,null,filteredZabava,null,
                                   null,null,null,null,null,null);



                       }






                   }
               });




        binding.recyclerViewCategory.setAdapter(adapter3);
        binding.recyclerViewCategory.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext(),LinearLayoutManager.HORIZONTAL,false));


        binding.recyclerViewNews.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));

        adapter= new HomePagePrimaryAdapter();









        binding.recyclerViewNews.setAdapter(adapter);

           binding.imageViewMenu.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   startActivity(new Intent(binding.getRoot().getContext(), MenuActivity.class));
               }
           });













    }


    private void loadData(){

        service = RetrofitClient.getInstance().getRetrofit().create(RetrofitService.class) ;

        loadHorizontalCategories();
        sendCategoriesFiltered();
        getHoroscope();
        getVideos();

        service.getHomePageData().enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {




                slider=response.body().data.slider;
                top=response.body().data.top;
                editors_choice=response.body().data.editors_choice;
                latest=response.body().data.latest;
                most_commented=response.body().data.most_comented;
                most_read=response.body().data.most_read;
                videosHomePage=response.body().data.videos;
                categoires=response.body().data.category;

                adapter.setList(slider,top,editors_choice,latest,most_read,most_commented,videosHomePage,horizontalCategories);



                filterHelper.addAll(slider);
                filterHelper.addAll(top);
                filterHelper.addAll(editors_choice);
                filterHelper.addAll(latest);
                filterHelper.addAll(most_read);
                filterHelper.addAll(most_commented);





                for (News n : filterHelper){

                    if (n.category.name.equalsIgnoreCase("Aktuelno")){

                        filteredAktuelno.add(n);
                    }
                    else   if (n.category.name.equalsIgnoreCase("Sport")){

                        filteredSport.add(n);
                    }
                    else    if (n.category.name.equalsIgnoreCase("Svet")){

                        filteredSvet.add(n);
                    }

                    else   if (n.category.name.equalsIgnoreCase("Društvo")){

                        filteredDrustvo.add(n);
                    }

                    else if (n.category.name.equalsIgnoreCase("Kultura")){

                        filteredKultura.add(n);
                    }

                    else     if (n.category.name.equalsIgnoreCase("Politika")){

                        filteredPolitika.add(n);
                    }

                    else   if (n.category.name.equalsIgnoreCase("Beograd")){

                        filteredBeograd.add(n);
                    }

                    else   if (n.category.name.equalsIgnoreCase("Ekonomija")){

                        filteredEkonomija.add(n);
                    }

                    else   if (n.category.name.equalsIgnoreCase("Zabava")){

                        filteredZabava.add(n);
                    }
                    else   if (n.category.name.equalsIgnoreCase("Vesti")){

                        filteredVesti.add(n);
                    }

                    else   if (n.category.name.equalsIgnoreCase("Region")){

                        filteredRegion.add(n);
                    }







                }






                binding.progressBar.setVisibility(View.GONE);



            }









            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {

                Toast.makeText(binding.getRoot().getContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void loadHorizontalCategories(){


        service=RetrofitClient.getInstance().getRetrofit().create(RetrofitService.class);

        service.getCategories().enqueue(new Callback<CategoriesResponse>() {
            @Override
            public void onResponse(Call<CategoriesResponse> call, Response<CategoriesResponse> response) {


                Category naslovna =  new Category();


                naslovna.name="Naslonva";
                naslovna.color="#ffffff";


                horizontalCategories=  response.body().data;
                horizontalCategories.add(0,naslovna);

                adapter3.setList(horizontalCategories);

            }

            @Override
            public void onFailure(Call<CategoriesResponse> call, Throwable t) {
                Toast.makeText(binding.getRoot().getContext(), R.string.failed_to_load, Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void sendCategoriesFiltered(){

        service=RetrofitClient.getInstance().getRetrofit().create(RetrofitService.class);

        service.getHomePageData().enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                categoires=response.body().data.category;




                for  (HomePageNewsByCategory n :categoires) {

                    if (n.id == 36) {


                        aktuelno.addAll(n.news);

                    } else if (n.id == 2) {

                        politika.addAll(n.news);

                    } else if (n.id == 3) {

                        drustvo.addAll(n.news);

                    } else if (n.id == 4) {

                        svet.addAll(n.news);

                    } else if (n.id == 18) {

                        region.addAll(n.news);

                    } else if (n.id == 8) {

                        sport.addAll(n.news);

                    } else if (n.id == 13) {

                        zabava.addAll(n.news);

                    } else if (n.id == 19) {

                        beograd.addAll(n.news);

                    } else if (n.id == 9) {

                        kultura.addAll(n.news);

                    } else if (n.id == 20) {

                        ekonomija.addAll(n.news);

                    }

                }


                filterHelper2.addAll(aktuelno);
                filterHelper2.addAll(svet);
                filterHelper2.addAll(region);
                filterHelper2.addAll(sport);
                filterHelper2.addAll(zabava);
                filterHelper2.addAll(beograd);
                filterHelper2.addAll(kultura);
                filterHelper2.addAll(ekonomija);
                filterHelper2.addAll(politika);





                adapter.sendSecondList(aktuelno,drustvo,svet,region,sport,zabava,beograd,kultura,ekonomija,politika);



                for (News n : filterHelper2){

                    if (n.category.name.equalsIgnoreCase("Aktuelno")){

                        filteredAktuelno.add(n);
                    }
                    else   if (n.category.name.equalsIgnoreCase("Sport")){

                        filteredSport.add(n);
                    }
                    else    if (n.category.name.equalsIgnoreCase("Svet")){

                        filteredSvet.add(n);
                    }

                    else   if (n.category.name.equalsIgnoreCase("Društvo")){

                        filteredDrustvo.add(n);
                    }

                    else if (n.category.name.equalsIgnoreCase("Kultura")){

                        filteredKultura.add(n);
                    }

                    else     if (n.category.name.equalsIgnoreCase("Politika")){

                        filteredPolitika.add(n);
                    }

                    else   if (n.category.name.equalsIgnoreCase("Beograd")){

                        filteredBeograd.add(n);
                    }

                    else   if (n.category.name.equalsIgnoreCase("Ekonomija")){

                        filteredEkonomija.add(n);
                    }

                    else   if (n.category.name.equalsIgnoreCase("Zabava")){

                        filteredZabava.add(n);
                    }
                    else   if (n.category.name.equalsIgnoreCase("Vesti")){

                        filteredVesti.add(n);
                    }

                    else   if (n.category.name.equalsIgnoreCase("Region")){

                        filteredRegion.add(n);
                    }







                }












            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {

             Toast.makeText(binding.getRoot().getContext(), R.string.failed_to_load, Toast.LENGTH_SHORT).show();

            }
        });



    }


    private void getHoroscope(){

        service=RetrofitClient.getInstance().getRetrofit().create(RetrofitService.class);

        service.getHoroscope().enqueue(new Callback<DataHoroscopeResponse>() {
            @Override
            public void onResponse(Call<DataHoroscopeResponse> call, Response<DataHoroscopeResponse> response) {







                horoscopes.add(response.body().data);



            }

            @Override
            public void onFailure(Call<DataHoroscopeResponse> call, Throwable t) {
                Toast.makeText(binding.getRoot().getContext(), R.string.failed_to_load, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getVideos(){


        service=RetrofitClient.getInstance().getRetrofit().create(RetrofitService.class);

        service.getVideo().enqueue(new Callback<DataVideoResponse>() {
            @Override
            public void onResponse(Call<DataVideoResponse> call, Response<DataVideoResponse> response) {

                allVideos=response.body().data.news;



            }

            @Override
            public void onFailure(Call<DataVideoResponse> call, Throwable t) {

                Toast.makeText(binding.getRoot().getContext(), R.string.failed_to_load, Toast.LENGTH_SHORT).show();
            }
        });
    }





}