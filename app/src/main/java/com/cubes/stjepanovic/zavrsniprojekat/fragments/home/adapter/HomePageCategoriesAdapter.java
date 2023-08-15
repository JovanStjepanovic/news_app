package com.cubes.stjepanovic.zavrsniprojekat.fragments.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.cubes.stjepanovic.zavrsniprojekat.R;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvHomepageCategoryItemBinding;
import com.cubes.stjepanovic.zavrsniprojekat.model.categories.Category;

import java.util.ArrayList;

public class HomePageCategoriesAdapter extends RecyclerView.Adapter<HomePageCategoriesAdapter.HomePageCategoriesHolder> {


    private ArrayList<Category>categories;
    private RvItemClick listener;

    private int currentPosition = 0;



    public HomePageCategoriesAdapter(ArrayList<Category> categories,RvItemClick listener) {
        this.categories = categories;
       this.listener=listener;
    }

    @NonNull
    @Override
    public HomePageCategoriesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      RvHomepageCategoryItemBinding binding =RvHomepageCategoryItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);


        return new HomePageCategoriesHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HomePageCategoriesHolder holder, int position) {

       Category category = categories.get(position);


     if (category.name == null){

     }

     else {

         holder.binding.textViewCategory.setText(category.name);

     }



        holder.binding.textViewCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (listener!= null){


                    listener.onItemClick(category.name, holder.getAdapterPosition());

                    currentPosition=holder.getAdapterPosition();



                    notifyDataSetChanged();



                }


            }
        });



        if (currentPosition== holder.getAdapterPosition()) {


            holder.binding.textViewCategory.setTextColor(ContextCompat.getColor(holder.binding.getRoot().getContext(), R.color.white));

            holder.binding.viewLine.setBackgroundColor(ContextCompat.getColor(holder.binding.getRoot().getContext(), R.color.white));
        }




        else {
            holder.binding.textViewCategory.setTextColor(ContextCompat.getColor(holder.binding.getRoot().getContext(), R.color.lighter_blue_category_name));

            holder.binding.viewLine.setBackgroundColor(ContextCompat.getColor(holder.binding.getRoot().getContext(), R.color.blue_category_background));


        }








    }

    @Override
    public int getItemCount() {

        if (categories==null){

            return 0;
        }
        else {

            return categories.size();
        }


    }

    public class HomePageCategoriesHolder extends RecyclerView.ViewHolder{

     private RvHomepageCategoryItemBinding binding;

        public HomePageCategoriesHolder(RvHomepageCategoryItemBinding binding) {
        super(binding.getRoot());

        this.binding=binding;


        }
}


public void setList(ArrayList<Category>categories){
      this.categories=categories;
notifyDataSetChanged();
    }

public interface RvItemClick{

        void onItemClick(String name,int position);

}

    public void setListener(RvItemClick listener) {
        this.listener = listener;
    }
}
