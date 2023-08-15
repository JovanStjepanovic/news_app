package com.cubes.stjepanovic.zavrsniprojekat.activities.menuAdapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvTopItemBinding;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.home.News;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.HomepageTopHolder> {



    private ArrayList<News>list;
     private RvTopClick listener;

    public CategoryAdapter(ArrayList<News> news, RvTopClick listener) {
        this.list = news;
        this.listener=listener;
    }

    @NonNull
    @Override
    public HomepageTopHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RvTopItemBinding binding=RvTopItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);


        return new HomepageTopHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HomepageTopHolder holder, int position) {

         News news = list.get(position);


        if (news.category.color==null){
            news.category.color="#FF000000";
        }




       if (news.title ==null || news.category.name == null || news.created_at ==null  || news.image == null){



         }

        else {

             holder.binding.textViewTitleTop.setText(news.title);
             holder.binding.textviewTime.setText(news.created_at);




             holder.binding.textViewCategory.setText(news.category.name);
             holder.binding.textViewCategory.setTextColor(Color.parseColor(news.category.color));




             Picasso.get().load(news.image).into(holder.binding.imageViewTop);





        }


               holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       if (listener!=null){

                           listener.onClick(news);
                       }
                   }
               });







    }

    @Override
    public int getItemCount() {

        if (list==null){
            return 0;
        }

       else {
           return list.size();
        }
    }

    public class HomepageTopHolder extends RecyclerView.ViewHolder{

  private RvTopItemBinding binding;

    public HomepageTopHolder(RvTopItemBinding binding) {
        super(binding.getRoot());
        this.binding=binding;
    }
}

public void setList(ArrayList<News> news){
    this.list=news;
   notifyDataSetChanged();
    }

public interface RvTopClick{

        void onClick(News news);
}


}
