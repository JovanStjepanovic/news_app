package com.cubes.stjepanovic.zavrsniprojekat.fragments.search.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvTopItemBinding;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.home.News;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchHolder> {



    private ArrayList<News>list;
    private SearchClick listener;

    public SearchAdapter(ArrayList<News> news) {
        this.list = news;
    }

    public void setListener(SearchClick listener) {
        this.listener = listener;
    }

    public SearchAdapter() {

    }






    @NonNull
    @Override
    public SearchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RvTopItemBinding binding= RvTopItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);


        return new SearchHolder(binding);



    }

    @Override
    public void onBindViewHolder(@NonNull SearchHolder holder, int position) {


        News n = list.get(position);


        if (n.title ==null || n.image ==null || n.category ==null){

            Toast.makeText(holder.binding.getRoot().getContext(), "EMPTY", Toast.LENGTH_SHORT).show();

        }
        else {

            holder.binding.textViewTitleTop.setText(n.title);

            holder.binding.textviewTime.setText(n.created_at);

            Picasso.get().load(n.image).into(holder.binding.imageViewTop);


            if (n.category.subcategory != null) {


                holder.binding.textViewCategory.setText(n.category.subcategory.name);


                holder.binding.textViewCategory.setTextColor(Color.parseColor(n.category.subcategory.color));
            }
            else {

                holder.binding.textViewCategory.setText(n.category.name);

                holder.binding.textViewCategory.setTextColor(Color.parseColor(n.category.color));
            }

        }


        holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener!=null){
                    listener.onClick(n);
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



    public class SearchHolder extends RecyclerView.ViewHolder{


    private RvTopItemBinding binding;

    public SearchHolder( RvTopItemBinding binding) {
        super(binding.getRoot());
    this.binding=binding;
    }
}

public void setList(ArrayList<News>news){

        this.list=news;
notifyDataSetChanged();
    }


public interface SearchClick{
        void onClick(News news);
}


}
