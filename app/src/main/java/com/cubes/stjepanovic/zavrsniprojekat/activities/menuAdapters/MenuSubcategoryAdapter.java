package com.cubes.stjepanovic.zavrsniprojekat.activities.menuAdapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvMenuSubcatItemBinding;
import com.cubes.stjepanovic.zavrsniprojekat.model.categories.subacategory.Subcategory;

import java.util.ArrayList;

public class MenuSubcategoryAdapter extends RecyclerView.Adapter<MenuSubcategoryAdapter.MenuHolderInner>{

    private ArrayList<Subcategory> list;

    private String color;

    private RvSubcatClick listener;

    public MenuSubcategoryAdapter(ArrayList<Subcategory> list, String color,RvSubcatClick listener) {
        this.list = list;
        this.color=color;
       this.listener=listener;

    }


    @NonNull
    @Override
    public MenuHolderInner onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RvMenuSubcatItemBinding binding=  RvMenuSubcatItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);


        return new MenuHolderInner(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuHolderInner holder, int position) {


        Subcategory subcat= list.get(position);

         if (subcat!=null) {

             holder.binding.textViewExpanded.setText(subcat.name);
             holder.binding.viewLine2.setBackgroundColor(Color.parseColor(color));

         }


         holder.binding.textViewExpanded.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (listener!= null){

                     listener.onTextClick(subcat.id);
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

    public  class MenuHolderInner extends RecyclerView.ViewHolder{

    private  RvMenuSubcatItemBinding binding;


    public MenuHolderInner(  RvMenuSubcatItemBinding binding) {
        super(binding.getRoot());
      this.binding=binding;
    }
}

public interface RvSubcatClick{

        void onTextClick(int id);
}





}
