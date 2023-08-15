package com.cubes.stjepanovic.zavrsniprojekat.fragments.home.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.cubes.stjepanovic.zavrsniprojekat.databinding.VpHomepageEditorChoiceItemBinding;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.home.News;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomePageViewPagerEditor extends RecyclerView.Adapter<HomePageViewPagerEditor.HomePageVPEditHolder>{


   private ArrayList<News>list;

   private RvEditorClick listener;

    public HomePageViewPagerEditor(ArrayList<News> list, RvEditorClick listener) {
        this.list = list;
        this.listener=listener;
    }

    @NonNull
    @Override
    public HomePageVPEditHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        VpHomepageEditorChoiceItemBinding binding = VpHomepageEditorChoiceItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);


        return new HomePageVPEditHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HomePageVPEditHolder holder, int position) {

        News news  =  list.get(position);


        if (news.category.color==null){
            news.category.color="#FF000000";
        }




        if (news.title == null || news.category == null || news.image == null){







      }


      else {


          holder.binding.textViewTitle.setText(news.title);

          Picasso.get().load(news.image).into(holder.binding.imageView);

          holder.binding.textViewCategoryTime.setText(news.created_at);


                if (news.category.subcategory != null) {

                    holder.binding.textViewCategory.setText(news.category.subcategory.name);

                    holder.binding.textViewCategory.setTextColor(ContextCompat.getColor(holder.binding.getRoot().getContext(), Integer.parseInt(news.category.subcategory.color)));

                }


          holder.binding.textViewCategory.setText(news.category.name);

          holder.binding.textViewCategory.setTextColor(Color.parseColor(news.category.color));


      }



      holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if (listener!=null){

                  listener.onEditorClick(news);
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

    public class HomePageVPEditHolder extends RecyclerView.ViewHolder{

    private VpHomepageEditorChoiceItemBinding binding;


        public HomePageVPEditHolder(VpHomepageEditorChoiceItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }

    public void setList(ArrayList<News>news){
        this.list=news;
    notifyDataSetChanged();
    }

public interface RvEditorClick{

      void   onEditorClick(News news);
}



}
