package com.cubes.stjepanovic.zavrsniprojekat;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvGalleryItemBinding;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvGalleryNameBinding;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvNewsDetailTagsItemBinding;
import com.cubes.stjepanovic.zavrsniprojekat.model.Gallery;
import com.cubes.stjepanovic.zavrsniprojekat.model.GalleryImages;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.newsdetail.Tag;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.HomepageTopHolder> {



    private ArrayList<Gallery>list;


    public GalleryAdapter(ArrayList<Gallery> galleries) {
        this.list = galleries;

    }

    @NonNull
    @Override
    public HomepageTopHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RvGalleryNameBinding binding= RvGalleryNameBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);


        return new HomepageTopHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HomepageTopHolder holder, int position) {

       Gallery gallery=list.get(position);


       if (gallery.gallery_images!=null && gallery.gallery_title!=null) {


           holder.binding.textViewGalleryName.setText(gallery.gallery_title);

           holder.binding.recyclerView.setAdapter(new GalleryInnerAdapter(gallery.gallery_images));

          holder.binding.recyclerView.setLayoutManager(new LinearLayoutManager(holder.binding.getRoot().getContext()));


       }
         else {



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

  private RvGalleryNameBinding binding;

    public HomepageTopHolder( RvGalleryNameBinding binding) {
        super(binding.getRoot());
        this.binding=binding;
    }
}

public void setList(ArrayList<Gallery> galleries){
    this.list=galleries;
   notifyDataSetChanged();
    }



}
