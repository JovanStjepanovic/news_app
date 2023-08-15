package com.cubes.stjepanovic.zavrsniprojekat;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvGalleryItemBinding;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvGalleryNameBinding;
import com.cubes.stjepanovic.zavrsniprojekat.model.Gallery;
import com.cubes.stjepanovic.zavrsniprojekat.model.GalleryImages;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GalleryInnerAdapter extends RecyclerView.Adapter<GalleryInnerAdapter.HomepageTopHolder> {



    private ArrayList<GalleryImages>list;


    public GalleryInnerAdapter(ArrayList<GalleryImages> galleries) {
        this.list = galleries;

    }

    @NonNull
    @Override
    public HomepageTopHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RvGalleryItemBinding binding=  RvGalleryItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);


        return new HomepageTopHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HomepageTopHolder holder, int position) {

       GalleryImages gallery=list.get(position);



        if (gallery.url!=null && gallery.signature!=null && gallery.source!=null) {


            if (gallery.url.length()>0 && gallery.signature.length()>0 && gallery.source.length()>0) {


                holder.binding.textViewSignatureBlue.setText(gallery.signature);

                holder.binding.textViewSourceBlue.setText(gallery.source);

                Picasso.get().load(gallery.url).into(holder.binding.imageView);

            }
            else if (gallery.url.length()==0 && gallery.signature.length()>0 && gallery.source.length()>0) {


                holder.binding.textViewSignatureBlue.setText(gallery.signature);

                holder.binding.textViewSourceBlue.setText(gallery.source);

                holder.binding.imageView.setImageResource(R.drawable.stockgallery);


            }

            else if (gallery.url.length()>0 && gallery.signature.length()==0 && gallery.source.length()>0) {



                holder.binding.textViewSignatureBlue.setText("Anonimus");

                holder.binding.textViewSourceBlue.setText(gallery.source);

                Picasso.get().load(gallery.url).into(holder.binding.imageView);


            }


            else if (gallery.url.length()>0 && gallery.signature.length()>0 && gallery.source.length()==0) {


                holder.binding.textViewSignatureBlue.setText(gallery.signature);

                holder.binding.textViewSourceBlue.setText("Anonimus");

                Picasso.get().load(gallery.url).into(holder.binding.imageView);


            }


            else if (gallery.url.length()==0 && gallery.signature.length()==0 && gallery.source.length()==0) {




            }







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

  private RvGalleryItemBinding binding;

    public HomepageTopHolder( RvGalleryItemBinding binding) {
        super(binding.getRoot());
        this.binding=binding;
    }
}

public void setList(ArrayList<GalleryImages> galleries){
    this.list=galleries;
   notifyDataSetChanged();
    }



}
