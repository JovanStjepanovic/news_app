package com.cubes.stjepanovic.zavrsniprojekat.fragments.home.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvHpVideoCategoryItemBinding;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.home.News;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomePageHorizontalCategoryVideoAdapter extends  RecyclerView.Adapter<HomePageHorizontalCategoryVideoAdapter.HomePageVideoHolder> {

private ArrayList<News>list;
private RvVideoInterviewClick listener;

    public HomePageHorizontalCategoryVideoAdapter(ArrayList<News> list, RvVideoInterviewClick listener) {
        this.list = list;
        this.listener=listener;
    }

    @NonNull
    @Override
    public HomePageVideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RvHpVideoCategoryItemBinding binding = RvHpVideoCategoryItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);



        return new HomePageVideoHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HomePageVideoHolder holder, int position) {


        News video = list.get(position);


        if (video.category.color==null){
            video.category.color="#FF000000";
        }




        if (video.category == null || video.image == null || video.title == null || video.url == null){

        }



       else {

            holder.binding.textViewTitleImage.setText(video.title);


            if (video.category.subcategory != null) {

                holder.binding.textViewCategory.setText(video.category.subcategory.name);

                holder.binding.textViewCategory.setTextColor(Color.parseColor(video.category.subcategory.color));
            } else {

                holder.binding.textViewCategory.setText(video.category.name);


                holder.binding.textViewCategory.setTextColor(Color.parseColor(video.category.color));

            }

            holder.binding.textViewTime.setText(video.created_at);


            Picasso.get().load(video.image).into(holder.binding.imageViewVideo);


        }


       holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               if (listener!=null){

                   listener.onVideoInterViewClick(video);
               }
           }
       });











    }

    @Override
    public int getItemCount() {

      if (list == null){

          return 0;
      }

      else {

          return list.size();
      }

    }


    public class HomePageVideoHolder extends RecyclerView.ViewHolder{

        private  RvHpVideoCategoryItemBinding binding;


        public HomePageVideoHolder( RvHpVideoCategoryItemBinding binding) {
            super(binding.getRoot());
          this.binding=binding;
        }
    }

    public void  setList(ArrayList<News>videos){
        this.list=videos;
    notifyDataSetChanged();
    }

 public interface RvVideoInterviewClick{
        void  onVideoInterViewClick(News video);
 }


}
