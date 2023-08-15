package com.cubes.stjepanovic.zavrsniprojekat.fragments.home.adapter;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.cubes.stjepanovic.zavrsniprojekat.activities.menuAdapters.HoroscopeAdapter;
import com.cubes.stjepanovic.zavrsniprojekat.activities.NewsDetailActivity;
import com.cubes.stjepanovic.zavrsniprojekat.R;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvNewestLatestMostReadBinding;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvVerticalRvForCatNews2Binding;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvVerticalRvForCatNewsBinding;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvVideoBinding;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.VpHomepageEditorChoiceBinding;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.VpHomepageSliderBinding;
import com.cubes.stjepanovic.zavrsniprojekat.model.categories.Category;
import com.cubes.stjepanovic.zavrsniprojekat.model.horoscope.Horoscope;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.home.News;


import java.util.ArrayList;

public class HomePagePrimaryAdapter extends RecyclerView.Adapter<HomePagePrimaryAdapter.HomePagePrimaryHolder> {


    private static int c;

    private  ArrayList<News> slider;
    private  ArrayList<News>top;
    private  ArrayList<News>editors_choice;
    private  ArrayList<News>latest;
    private  ArrayList<News>most_read;
    private  ArrayList<News>most_commented;
    private  ArrayList<News>videosHomePage;
    private  ArrayList<News>allVideos;



  private ArrayList<Horoscope>horoscopes;


    private ArrayList<News>aktuelno;
    private ArrayList<News>drustvo;
    private ArrayList<News>svet;
    private ArrayList<News>region;
    private ArrayList<News>sport;
    private ArrayList<News>zabava;
    private ArrayList<News>beograd;
    private ArrayList<News>kultura;
    private ArrayList<News>ekonomija;
    private ArrayList<News>politika;



    private  ArrayList<News>filteredAktuelno;
    private  ArrayList<News>filteredDrustvo;
    private  ArrayList<News>filteredSvet;
    private ArrayList<News>filteredRegion;
    private   ArrayList<News>filteredSport;
    private  ArrayList<News>filteredZabava;
    private  ArrayList<News>filteredBeograd;
    private  ArrayList<News>filteredKultura;
    private  ArrayList<News>filteredEkonomija;
    private  ArrayList<News>filteredPolitika;

    private  ArrayList<News>filteredVesti;















    public HomePagePrimaryAdapter(ArrayList<News> slider, ArrayList<News> top, ArrayList<News> editors_choice,
                                  ArrayList<News> latest, ArrayList<News> most_read,
                                  ArrayList<News> most_commented, ArrayList<News> videosHomePage) {

        this.slider = slider;
        this.top = top;
        this.editors_choice = editors_choice;
        this.latest = latest;
        this.most_read = most_read;
        this.most_commented = most_commented;
        this.videosHomePage = videosHomePage;



    }


    public HomePagePrimaryAdapter(){

    }










    @NonNull
    @Override
    public HomePagePrimaryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {



        HomePagePrimaryHolder holder= null;




       if (viewType==0) {



               RvVerticalRvForCatNews2Binding binding =  RvVerticalRvForCatNews2Binding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

               holder = new HomePagePrimaryHolder(binding);





       }



        else if (viewType==1){

            VpHomepageSliderBinding binding=VpHomepageSliderBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

            holder= new HomePagePrimaryHolder(binding);

        }


        else   if (viewType==2) {

            RvVerticalRvForCatNewsBinding binding = RvVerticalRvForCatNewsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

            holder= new HomePagePrimaryHolder(binding);


        }



        else if (viewType==3) {

            RvNewestLatestMostReadBinding binding=RvNewestLatestMostReadBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

            holder= new HomePagePrimaryHolder(binding);

        }



        else   if (viewType==4) {

            RvVerticalRvForCatNewsBinding binding = RvVerticalRvForCatNewsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

            holder= new HomePagePrimaryHolder(binding);


        }


        else   if (viewType==5) {

            VpHomepageEditorChoiceBinding binding=VpHomepageEditorChoiceBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

            holder= new HomePagePrimaryHolder(binding);

        }


        else    if (viewType==6){


            RvVideoBinding binding = RvVideoBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

            holder= new HomePagePrimaryHolder(binding);
        }

        else    if (viewType==7){

            RvVerticalRvForCatNewsBinding binding = RvVerticalRvForCatNewsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

            holder= new HomePagePrimaryHolder(binding);


        }





        return holder ;





    }

    @Override
    public void onBindViewHolder(@NonNull HomePagePrimaryHolder holder, int position) {



        if (getItemViewType(position) == 0) {



            if (allVideos!=null){

                ((RvVerticalRvForCatNews2Binding) holder.binding).recyclerViewCategory.setVisibility(View.VISIBLE);
                ((RvVerticalRvForCatNews2Binding) holder.binding).recyclerViewCategory.setAdapter(new HomePageHorizontalCategoryVideoAdapter(allVideos, new HomePageHorizontalCategoryVideoAdapter.RvVideoInterviewClick() {
                    @Override
                    public void onVideoInterViewClick(News video) {

                        Intent intent= new Intent(Intent.ACTION_VIEW);

                        intent.setData(Uri.parse(video.url));

                        holder.binding.getRoot().getContext().startActivity(intent);
                    }
                }));

                ((RvVerticalRvForCatNews2Binding) holder.binding).recyclerViewCategory.setLayoutManager(new LinearLayoutManager(holder.binding.getRoot().getContext()));

            }

            else   if (horoscopes != null){

                ((RvVerticalRvForCatNews2Binding) holder.binding).recyclerViewCategory.setAdapter(new HoroscopeAdapter(horoscopes));

                ((RvVerticalRvForCatNews2Binding) holder.binding).recyclerViewCategory.setLayoutManager(new LinearLayoutManager(holder.binding.getRoot().getContext()));

            }

            else   if (filteredVesti != null){




                ((RvVerticalRvForCatNews2Binding) holder.binding).recyclerViewCategory.setAdapter(new HomePageNewsByCategoryPrimaryAdapter(filteredVesti, filteredDrustvo, filteredSvet, filteredRegion
                        , filteredSport, filteredZabava, filteredBeograd,filteredKultura
                        , filteredEkonomija, filteredPolitika, 1,0,0));


                ((RvVerticalRvForCatNews2Binding) holder.binding).recyclerViewCategory.setLayoutManager(new LinearLayoutManager(holder.binding.getRoot().getContext()));

            }

            else {
                ((RvVerticalRvForCatNews2Binding) holder.binding).recyclerViewCategory.setAdapter(new HomePageNewsByCategoryPrimaryAdapter(filteredAktuelno, filteredDrustvo, filteredSvet, filteredRegion
                        , filteredSport, filteredZabava, filteredBeograd,filteredKultura
                        , filteredEkonomija, filteredPolitika, 1,1,1));


                (( RvVerticalRvForCatNews2Binding) holder.binding).recyclerViewCategory.setLayoutManager(new LinearLayoutManager(holder.binding.getRoot().getContext()));

            }




        }












     else    if (getItemViewType(position) == 1) {


            if (filteredAktuelno != null ||  filteredDrustvo != null || filteredSvet != null || filteredRegion
                    != null || filteredSport!= null ||filteredZabava!= null || filteredBeograd!= null ||filteredKultura
                    != null || filteredEkonomija != null ||filteredPolitika !=null|| horoscopes != null||allVideos!=null||filteredVesti!=null){



                ((VpHomepageSliderBinding) holder.binding).viewPagerSlider.setVisibility(View.GONE);
                ((VpHomepageSliderBinding) holder.binding).circleIndicator.setVisibility(View.GONE);

            }

            else {

                ((VpHomepageSliderBinding) holder.binding).viewPagerSlider.setVisibility(View.VISIBLE);
                ((VpHomepageSliderBinding) holder.binding).circleIndicator.setVisibility(View.VISIBLE);
                ((VpHomepageSliderBinding) holder.binding).viewPagerSlider.setAdapter(new HomePageViewPagerSliderAdapter(slider, new HomePageViewPagerSliderAdapter.RvSliderClick() {
                    @Override
                    public void onSliderClick(News news) {

                        Intent intent = new Intent(holder.binding.getRoot().getContext(), NewsDetailActivity.class);

                        intent.putExtra("news", news);

                        holder.binding.getRoot().getContext().startActivity(intent);


                    }
                }));
                ((VpHomepageSliderBinding) holder.binding).circleIndicator.setViewPager(((VpHomepageSliderBinding) holder.binding).viewPagerSlider);

            }





        }
        else if (getItemViewType(position) == 2) {




            if (filteredAktuelno != null ||  filteredDrustvo != null || filteredSvet != null || filteredRegion
                    != null || filteredSport!= null ||filteredZabava!= null || filteredBeograd!= null ||filteredKultura
                    != null || filteredEkonomija != null ||filteredPolitika !=null|| horoscopes != null||allVideos!=null||filteredVesti!=null) {



                ((RvVerticalRvForCatNewsBinding) holder.binding).recyclerViewCategory.setVisibility(View.GONE);

            }
            else {

                ((RvVerticalRvForCatNewsBinding) holder.binding).recyclerViewCategory.setVisibility(View.VISIBLE);

                ((RvVerticalRvForCatNewsBinding) holder.binding).recyclerViewCategory.setAdapter(new HomePageTopAdapter(top, new HomePageTopAdapter.RvTopClick() {
                    @Override
                    public void onClick(News news) {

                        Intent intent = new Intent(holder.binding.getRoot().getContext(),NewsDetailActivity.class);

                        intent.putExtra("news", news);

                        holder.binding.getRoot().getContext().startActivity(intent);
                    }
                }));

                ((RvVerticalRvForCatNewsBinding) holder.binding).recyclerViewCategory.setLayoutManager(new LinearLayoutManager(holder.binding.getRoot().getContext()));


            }







        } else if (getItemViewType(position) == 3) {


            if (filteredAktuelno != null ||  filteredDrustvo != null || filteredSvet != null || filteredRegion
                    != null || filteredSport!= null ||filteredZabava!= null || filteredBeograd!= null ||filteredKultura
                    != null || filteredEkonomija != null ||filteredPolitika !=null|| horoscopes != null||allVideos!=null||filteredVesti!=null){


                ((RvNewestLatestMostReadBinding) holder.binding).textViewNewest.setVisibility(View.GONE);
                ((RvNewestLatestMostReadBinding) holder.binding).textViewMostRead.setVisibility(View.GONE);
                ((RvNewestLatestMostReadBinding) holder.binding).textViewComments.setVisibility(View.GONE);
                ((RvNewestLatestMostReadBinding) holder.binding).viewLine4.setVisibility(View.GONE);
                ((RvNewestLatestMostReadBinding) holder.binding).viewLine5.setVisibility(View.GONE);


                ((RvNewestLatestMostReadBinding) holder.binding).viewLine6.setVisibility(View.GONE);
                ((RvNewestLatestMostReadBinding) holder.binding).recyclerViewLatestNewestMost.setVisibility(View.GONE);

                ((RvNewestLatestMostReadBinding) holder.binding).viewLine1.setVisibility(View.GONE);
                ((RvNewestLatestMostReadBinding) holder.binding).viewLine2.setVisibility(View.GONE);
                ((RvNewestLatestMostReadBinding) holder.binding).viewLine3.setVisibility(View.GONE);






            }

            else {
                ((RvNewestLatestMostReadBinding) holder.binding).textViewNewest.setVisibility(View.VISIBLE);
                ((RvNewestLatestMostReadBinding) holder.binding).textViewMostRead.setVisibility(View.VISIBLE);
                ((RvNewestLatestMostReadBinding) holder.binding).textViewComments.setVisibility(View.VISIBLE);
                ((RvNewestLatestMostReadBinding) holder.binding).viewLine4.setVisibility(View.VISIBLE);
                ((RvNewestLatestMostReadBinding) holder.binding).viewLine5.setVisibility(View.VISIBLE);


                ((RvNewestLatestMostReadBinding) holder.binding).viewLine6.setVisibility(View.VISIBLE);
                ((RvNewestLatestMostReadBinding) holder.binding).recyclerViewLatestNewestMost.setVisibility(View.VISIBLE);

                ((RvNewestLatestMostReadBinding) holder.binding).viewLine1.setVisibility(View.VISIBLE);
                ((RvNewestLatestMostReadBinding) holder.binding).viewLine2.setVisibility(View.VISIBLE);
                ((RvNewestLatestMostReadBinding) holder.binding).viewLine3.setVisibility(View.VISIBLE);


                ((RvNewestLatestMostReadBinding) holder.binding).recyclerViewLatestNewestMost.setAdapter(new HomePageLatMcMrAdapter(latest, new HomePageLatMcMrAdapter.RvLatMrMcClick() {
                    @Override
                    public void onTextViewClick(News news) {
                        Intent intent = new Intent(holder.binding.getRoot().getContext(),NewsDetailActivity.class);

                        intent.putExtra("news", news);

                        holder.binding.getRoot().getContext().startActivity(intent);
                    }
                }));

                ((RvNewestLatestMostReadBinding) holder.binding).recyclerViewLatestNewestMost.setLayoutManager(new LinearLayoutManager(holder.binding.getRoot().getContext()));


                ((RvNewestLatestMostReadBinding) holder.binding).textViewNewest.setTextColor(Color.parseColor("#FF000000"));
                ((RvNewestLatestMostReadBinding) holder.binding).textViewMostRead.setTextColor(Color.parseColor("#a7a7a7"));
                ((RvNewestLatestMostReadBinding) holder.binding).textViewComments.setTextColor(Color.parseColor("#a7a7a7"));

                ((RvNewestLatestMostReadBinding) holder.binding).viewLine4.setBackgroundColor(holder.binding.getRoot().getResources().getColor(R.color.orange));
                ((RvNewestLatestMostReadBinding) holder.binding).viewLine4.setVisibility(View.VISIBLE);

                ((RvNewestLatestMostReadBinding) holder.binding).viewLine5.setVisibility(View.GONE);


                ((RvNewestLatestMostReadBinding) holder.binding).viewLine6.setVisibility(View.GONE);

            }



            ((RvNewestLatestMostReadBinding) holder.binding).textViewMostRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ((RvNewestLatestMostReadBinding) holder.binding).recyclerViewLatestNewestMost.setAdapter(new HomePageLatMcMrAdapter(most_read, new HomePageLatMcMrAdapter.RvLatMrMcClick() {
                        @Override
                        public void onTextViewClick(News news) {

                            Intent intent = new Intent(holder.binding.getRoot().getContext(),NewsDetailActivity.class);

                            intent.putExtra("news", news);

                            holder.binding.getRoot().getContext().startActivity(intent);


                        }
                    }));


                    ((RvNewestLatestMostReadBinding) holder.binding).textViewNewest.setTextColor(Color.parseColor("#a7a7a7"));
                    ((RvNewestLatestMostReadBinding) holder.binding).textViewMostRead.setTextColor(Color.parseColor("#FF000000"));
                    ((RvNewestLatestMostReadBinding) holder.binding).textViewComments.setTextColor(Color.parseColor("#a7a7a7"));

                    ((RvNewestLatestMostReadBinding) holder.binding).viewLine4.setVisibility(View.GONE);


                    ((RvNewestLatestMostReadBinding) holder.binding).viewLine5.setBackgroundColor(holder.binding.getRoot().getResources().getColor(R.color.orange));
                    ((RvNewestLatestMostReadBinding) holder.binding).viewLine5.setVisibility(View.VISIBLE);

                    ((RvNewestLatestMostReadBinding) holder.binding).viewLine6.setVisibility(View.GONE);


                }
            });

            ((RvNewestLatestMostReadBinding) holder.binding).textViewComments.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ((RvNewestLatestMostReadBinding) holder.binding).recyclerViewLatestNewestMost.setAdapter(new HomePageLatMcMrAdapter(most_commented, new HomePageLatMcMrAdapter.RvLatMrMcClick() {
                        @Override
                        public void onTextViewClick(News news) {
                            Intent intent = new Intent(holder.binding.getRoot().getContext(),NewsDetailActivity.class);

                            intent.putExtra("news", news);

                            holder.binding.getRoot().getContext().startActivity(intent);
                        }
                    }));

                    ((RvNewestLatestMostReadBinding) holder.binding).textViewNewest.setTextColor(Color.parseColor("#a7a7a7"));
                    ((RvNewestLatestMostReadBinding) holder.binding).textViewMostRead.setTextColor(Color.parseColor("#a7a7a7"));
                    ((RvNewestLatestMostReadBinding) holder.binding).textViewComments.setTextColor(Color.parseColor("#FF000000"));


                    ((RvNewestLatestMostReadBinding) holder.binding).viewLine4.setVisibility(View.GONE);


                    ((RvNewestLatestMostReadBinding) holder.binding).viewLine5.setVisibility(View.GONE);


                    ((RvNewestLatestMostReadBinding) holder.binding).viewLine6.setBackgroundColor(holder.binding.getRoot().getResources().getColor(R.color.orange));
                    ((RvNewestLatestMostReadBinding) holder.binding).viewLine6.setVisibility(View.VISIBLE);


                }
            });

            ((RvNewestLatestMostReadBinding) holder.binding).textViewNewest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ((RvNewestLatestMostReadBinding) holder.binding).recyclerViewLatestNewestMost.setAdapter(new HomePageLatMcMrAdapter(latest, new HomePageLatMcMrAdapter.RvLatMrMcClick() {
                        @Override
                        public void onTextViewClick(News news) {
                            Intent intent = new Intent(holder.binding.getRoot().getContext(),NewsDetailActivity.class);

                            intent.putExtra("news", news);

                            holder.binding.getRoot().getContext().startActivity(intent);
                        }
                    }));


                    ((RvNewestLatestMostReadBinding) holder.binding).recyclerViewLatestNewestMost.setAdapter(new HomePageLatMcMrAdapter(latest, new HomePageLatMcMrAdapter.RvLatMrMcClick() {
                        @Override
                        public void onTextViewClick(News news) {
                            Intent intent = new Intent(holder.binding.getRoot().getContext(),NewsDetailActivity.class);

                            intent.putExtra("news", news);

                            holder.binding.getRoot().getContext().startActivity(intent);
                        }
                    }));

                    ((RvNewestLatestMostReadBinding) holder.binding).recyclerViewLatestNewestMost.setLayoutManager(new LinearLayoutManager(holder.binding.getRoot().getContext()));


                    ((RvNewestLatestMostReadBinding) holder.binding).textViewNewest.setTextColor(Color.parseColor("#FF000000"));
                    ((RvNewestLatestMostReadBinding) holder.binding).textViewMostRead.setTextColor(Color.parseColor("#a7a7a7"));
                    ((RvNewestLatestMostReadBinding) holder.binding).textViewComments.setTextColor(Color.parseColor("#a7a7a7"));


                    ((RvNewestLatestMostReadBinding) holder.binding).viewLine4.setBackgroundColor(holder.binding.getRoot().getResources().getColor(R.color.orange));
                    ((RvNewestLatestMostReadBinding) holder.binding).viewLine4.setVisibility(View.VISIBLE);

                    ((RvNewestLatestMostReadBinding) holder.binding).viewLine5.setVisibility(View.GONE);


                    ((RvNewestLatestMostReadBinding) holder.binding).viewLine6.setVisibility(View.GONE);


                }
            });










        } else if (getItemViewType(position) == 4) {


            if (filteredAktuelno != null ||  filteredDrustvo != null || filteredSvet != null || filteredRegion
                    != null || filteredSport!= null ||filteredZabava!= null || filteredBeograd!= null ||filteredKultura
                    != null || filteredEkonomija != null ||filteredPolitika !=null|| horoscopes != null||allVideos!=null||filteredVesti!=null) {


                ((RvVerticalRvForCatNewsBinding) holder.binding).recyclerViewCategory.setVisibility(View.GONE);

            }

            else {

                ((RvVerticalRvForCatNewsBinding) holder.binding).recyclerViewCategory.setVisibility(View.VISIBLE);

                ((RvVerticalRvForCatNewsBinding) holder.binding).recyclerViewCategory.setAdapter(new HomePageNewsByCategoryPrimaryAdapter(null, null, null, null
                        , sport, null, null, null
                        , null, null, 0,0,0));


                ((RvVerticalRvForCatNewsBinding) holder.binding).recyclerViewCategory.setLayoutManager(new LinearLayoutManager(holder.binding.getRoot().getContext()));


            }






        }
        else if (getItemViewType(position) == 5) {


            if (filteredAktuelno != null ||  filteredDrustvo != null || filteredSvet != null || filteredRegion
                    != null || filteredSport!= null ||filteredZabava!= null || filteredBeograd!= null ||filteredKultura
                    != null || filteredEkonomija != null ||filteredPolitika !=null|| horoscopes != null||allVideos!=null||filteredVesti!=null){



                ((VpHomepageEditorChoiceBinding) holder.binding).viewPagerSlider.setVisibility(View.GONE);

                ((VpHomepageEditorChoiceBinding) holder.binding).textViewEditorChoice.setVisibility(View.GONE);
                ((VpHomepageEditorChoiceBinding) holder.binding).viewLine2.setVisibility(View.GONE);
                ((VpHomepageEditorChoiceBinding) holder.binding).viewLine2.setVisibility(View.GONE);
                ((VpHomepageEditorChoiceBinding) holder.binding).viewLine.setVisibility(View.GONE);
                ((VpHomepageEditorChoiceBinding) holder.binding).circleIndicator.setVisibility(View.GONE);


            }

            else {

                ((VpHomepageEditorChoiceBinding) holder.binding).viewPagerSlider.setVisibility(View.VISIBLE);
                ((VpHomepageEditorChoiceBinding) holder.binding).circleIndicator.setVisibility(View.VISIBLE);
                ((VpHomepageEditorChoiceBinding) holder.binding).textViewEditorChoice.setVisibility(View.VISIBLE);
                ((VpHomepageEditorChoiceBinding) holder.binding).viewLine2.setVisibility(View.VISIBLE);
                ((VpHomepageEditorChoiceBinding) holder.binding).viewLine2.setVisibility(View.VISIBLE);
                ((VpHomepageEditorChoiceBinding) holder.binding).viewLine.setVisibility(View.VISIBLE);

            }


            ((VpHomepageEditorChoiceBinding) holder.binding).viewPagerSlider.setAdapter(new HomePageViewPagerEditor(top, new HomePageViewPagerEditor.RvEditorClick() {
                @Override
                public void onEditorClick(News news) {

                    Intent intent = new Intent(holder.binding.getRoot().getContext(),NewsDetailActivity.class);

                    intent.putExtra("news", news);

                    holder.binding.getRoot().getContext().startActivity(intent);
                }
            }));
            ((VpHomepageEditorChoiceBinding) holder.binding).circleIndicator.setViewPager(((VpHomepageEditorChoiceBinding) holder.binding).viewPagerSlider);



        }

        else if (getItemViewType(position) == 6) {



            if (filteredAktuelno != null ||  filteredDrustvo != null || filteredSvet != null || filteredRegion
                    != null || filteredSport!= null ||filteredZabava!= null || filteredBeograd!= null ||filteredKultura
                    != null || filteredEkonomija != null ||filteredPolitika !=null|| horoscopes != null||allVideos!=null||filteredVesti!=null){

                ((RvVideoBinding) holder.binding).recyclerView.setVisibility(View.GONE);
                ((RvVideoBinding) holder.binding).textViewVideo.setVisibility(View.GONE);
                ((RvVideoBinding) holder.binding).viewLine.setVisibility(View.GONE);
                ((RvVideoBinding) holder.binding).viewLine2.setVisibility(View.GONE);

            }




            else {


                ((RvVideoBinding) holder.binding).recyclerView.setVisibility(View.VISIBLE);
                ((RvVideoBinding) holder.binding).textViewVideo.setVisibility(View.VISIBLE);
                ((RvVideoBinding) holder.binding).viewLine.setVisibility(View.VISIBLE);
                ((RvVideoBinding) holder.binding).viewLine2.setVisibility(View.VISIBLE);


                ((RvVideoBinding) holder.binding).recyclerView.setAdapter(new HomePageVideoAdapter(videosHomePage, new HomePageVideoAdapter.RvVideoClick() {
                    @Override
                    public void OnVideoClick(News news) {

                        Intent intent= new Intent(Intent.ACTION_VIEW);

                        intent.setData(Uri.parse(news.url));

                          holder.binding.getRoot().getContext().startActivity(intent);

                    }
                }));
                ((RvVideoBinding) holder.binding).recyclerView.setLayoutManager(new LinearLayoutManager(holder.binding.getRoot().getContext()));


            }












        }

        else if (getItemViewType(position) == 7) {


            if (filteredAktuelno != null ||  filteredDrustvo != null || filteredSvet != null || filteredRegion
                    != null || filteredSport!= null ||filteredZabava!= null || filteredBeograd!= null ||filteredKultura
                    != null || filteredEkonomija != null ||filteredPolitika !=null|| horoscopes != null||allVideos!=null||filteredVesti!=null){


                ((RvVerticalRvForCatNewsBinding) holder.binding).recyclerViewCategory.setVisibility(View.GONE);
            }


            else {

                ((RvVerticalRvForCatNewsBinding) holder.binding).recyclerViewCategory.setVisibility(View.VISIBLE);

                ((RvVerticalRvForCatNewsBinding) holder.binding).recyclerViewCategory.setAdapter(new HomePageNewsByCategoryPrimaryAdapter(aktuelno, drustvo, svet, region
                        , null, zabava, beograd, kultura
                        , ekonomija, politika, 0,0,0));


                ((RvVerticalRvForCatNewsBinding) holder.binding).recyclerViewCategory.setLayoutManager(new LinearLayoutManager(holder.binding.getRoot().getContext()));

            }





        }







    }

    @Override
    public int getItemCount() {



        if ( slider ==null && top == null && editors_choice ==null && latest ==null && most_read ==null && most_commented ==null && videosHomePage ==null ){

            return 0;
        }
        else {

            return 8;
        }



    }






        @Override
    public int getItemViewType(int position) {

       if (position==0){

           return 0;
       }
       else if (position==1){

           return 1;
       }

       else if (position==2){

           return 2;
       }

       else if (position==3){

           return 3;
       }

       else if (position==4){

           return 4;
       }
       else if (position==5){

           return 5;
       }
       else if (position==6){

           return 6;
       }
       else if (position==7){

           return 7;
       }


       else {
          return 8;
       }




    }

    public class HomePagePrimaryHolder extends RecyclerView.ViewHolder{

    private ViewBinding binding;


    public HomePagePrimaryHolder(ViewBinding binding) {
        super(binding.getRoot());
     this.binding=binding;

    }
}


public void setList(ArrayList<News> slider, ArrayList<News> top, ArrayList<News> editors_choice,
                    ArrayList<News> latest, ArrayList<News> most_read,
                    ArrayList<News> most_commented, ArrayList<News> videos,
                    ArrayList<Category>categoriesHorizontal
                    ){



    this.slider = slider;
    this.top = top;
    this.editors_choice = editors_choice;
    this.latest = latest;
    this.most_read = most_read;
    this.most_commented = most_commented;
    this.videosHomePage = videos;


    notifyDataSetChanged();


    }


public void sendSecondList(ArrayList<News>aktuelno, ArrayList<News>drustvo, ArrayList<News>svet,
                            ArrayList<News>region,
                            ArrayList<News>sport,
                            ArrayList<News>zabava,
                            ArrayList<News>beograd,
                            ArrayList<News>kultura,
                            ArrayList<News>ekonomija,
                            ArrayList<News>politika){


    this.aktuelno= aktuelno;
    this.ekonomija= ekonomija;
    this.region= region;
    this.beograd= beograd;
    this.zabava= zabava;
    this.drustvo= drustvo;
    this.svet= svet;
    this.sport=sport;
    this.kultura= kultura;
    this.politika= politika;

notifyDataSetChanged();


}


public void sendFilteredLists(ArrayList<News>filteredAktuelno, ArrayList<News>filteredDrustvo, ArrayList<News>filteredSvet,
                              ArrayList<News>filteredRegion, ArrayList<News>filteredSport, ArrayList<News>filteredZabava,
                              ArrayList<News>filteredBeograd, ArrayList<News>filteredKultura, ArrayList<News>filteredEkonomija,
                              ArrayList<News>filteredPolitika, ArrayList<News>getFilteredVesti, ArrayList<Horoscope>horoscopes,
                              ArrayList<News>allVideos ){


    this.filteredPolitika=filteredPolitika;
    this.filteredAktuelno=filteredAktuelno;
    this.filteredDrustvo=filteredDrustvo;
    this.filteredSvet=filteredSvet;
    this.filteredRegion=filteredRegion;
    this.filteredSport=filteredSport;
    this.filteredZabava=filteredZabava;
    this.filteredBeograd=filteredBeograd;
    this.filteredKultura=filteredKultura;
    this.filteredEkonomija=filteredEkonomija;
    this.filteredVesti=getFilteredVesti;
    this.horoscopes=horoscopes;
   this.allVideos=allVideos;
    notifyDataSetChanged();

    }









}
