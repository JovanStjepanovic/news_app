package com.cubes.stjepanovic.zavrsniprojekat.fragments.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvNewestLatestMostReadItemBinding;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.home.News;

import java.util.ArrayList;

public class HomePageLatMcMrAdapter extends RecyclerView.Adapter<HomePageLatMcMrAdapter.HomePageLatMcMrHolder> {


    private ArrayList<News> list;

    private RvLatMrMcClick listener;


    public HomePageLatMcMrAdapter(ArrayList<News> list,RvLatMrMcClick listener) {
        this.list = list;
       this.listener=listener;
    }

    @NonNull
    @Override
    public HomePageLatMcMrHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RvNewestLatestMostReadItemBinding binding = RvNewestLatestMostReadItemBinding.inflate
                (LayoutInflater.from(parent.getContext()),parent,false);


        return new HomePageLatMcMrHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HomePageLatMcMrHolder holder, int position) {

        News lt = list.get(position);

             if (lt.title == null || lt.created_at == null){

             }

             else {

                 holder.binding.textViewTitle.setText(lt.title);

                 holder.binding.textViewTime.setText(lt.created_at);

             }



             holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     if (listener!=null){

                         listener.onTextViewClick(lt);
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

    public class HomePageLatMcMrHolder extends RecyclerView.ViewHolder{

        private RvNewestLatestMostReadItemBinding binding;

        public HomePageLatMcMrHolder(RvNewestLatestMostReadItemBinding binding) {
            super(binding.getRoot());
          this.binding=binding;
        }
    }

public void setList (ArrayList<News>lm){

        this.list=lm;
notifyDataSetChanged();
    }


public interface RvLatMrMcClick{

     void   onTextViewClick(News news);
}


}

