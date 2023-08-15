package com.cubes.stjepanovic.zavrsniprojekat.fragments.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cubes.stjepanovic.zavrsniprojekat.databinding.VpHomepageItemSliderBinding;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.home.News;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomePageViewPagerSliderAdapter extends RecyclerView.Adapter<HomePageViewPagerSliderAdapter.HomePageSliderHolder>  {


    private ArrayList<News> sliderNews;

    private RvSliderClick listener;


    @NonNull
    @Override
    public HomePageViewPagerSliderAdapter.HomePageSliderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

     VpHomepageItemSliderBinding binding = VpHomepageItemSliderBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);



        return new HomePageSliderHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HomePageViewPagerSliderAdapter.HomePageSliderHolder holder, int position) {

          News slider = sliderNews.get(position);


      if (slider.title == null || slider.image == null){

      }

    else {

          holder.binding.textViewTitle.setText(slider.title);


          Picasso.get().load(slider.image).into(holder.binding.imageView);

      }



             holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     if (listener!=null){

                         listener.onSliderClick(slider);
                     }
                 }
             });






    }

    @Override
    public int getItemCount() {

      if (sliderNews ==null){

          return 0;

      }
      else {

          return  sliderNews.size();
      }

    }

    public class HomePageSliderHolder extends RecyclerView.ViewHolder{

      private VpHomepageItemSliderBinding binding;

        public HomePageSliderHolder(VpHomepageItemSliderBinding binding) {
            super(binding.getRoot());
            this.binding=binding;

        }
    }

    public HomePageViewPagerSliderAdapter(ArrayList<News> sliderNews,RvSliderClick listener) {
        this.sliderNews = sliderNews;
        this.listener=listener;
    }

public void setList(ArrayList<News>news){
        this.sliderNews=news;
notifyDataSetChanged();
    }


public interface RvSliderClick{

     void onSliderClick(News news);


}



}
