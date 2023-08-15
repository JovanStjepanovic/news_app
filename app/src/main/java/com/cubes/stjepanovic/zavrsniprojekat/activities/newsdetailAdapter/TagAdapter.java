package com.cubes.stjepanovic.zavrsniprojekat.activities.newsdetailAdapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvNewsDetailTagsItemBinding;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.newsdetail.Tag;

import java.util.ArrayList;

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.HomepageTopHolder> {



    private ArrayList<Tag>list;


    public TagAdapter(ArrayList<Tag> tag) {
        this.list = tag;

    }

    @NonNull
    @Override
    public HomepageTopHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RvNewsDetailTagsItemBinding binding=RvNewsDetailTagsItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);


        return new HomepageTopHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HomepageTopHolder holder, int position) {

       Tag tag =list.get(position);


            holder.binding.textViewTag.setText(tag.title);


        if (position==0){

           holder.binding.linerLayout.setBackgroundColor(Color.parseColor("#143e6c"));
            holder.binding.textViewTag.setTextColor(Color.parseColor("#FFFFFFFF"));


        }

        else {

            holder.binding.linerLayout.setBackgroundColor(Color.parseColor("#edf1f2"));
            holder.binding.textViewTag.setTextColor(Color.parseColor("#143e6c"));



        }





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

  private RvNewsDetailTagsItemBinding binding;

    public HomepageTopHolder(RvNewsDetailTagsItemBinding binding) {
        super(binding.getRoot());
        this.binding=binding;
    }
}

public void setList(ArrayList<Tag> tags){
    this.list=tags;
   notifyDataSetChanged();
    }



}
