package com.cubes.stjepanovic.zavrsniprojekat.activities.menuAdapters;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cubes.stjepanovic.zavrsniprojekat.R;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvMenuItemBinding;
import com.cubes.stjepanovic.zavrsniprojekat.model.categories.Category;
import com.cubes.stjepanovic.zavrsniprojekat.model.categories.subacategory.Subcategory;

import java.util.ArrayList;

public class MenuInnerAdapter extends RecyclerView.Adapter<MenuInnerAdapter.MenuHolderInner>{

    private ArrayList<Category> list;

    private    ArrayList<Subcategory>subDrustvo;

    private    ArrayList<Subcategory>subKultura;

    private     ArrayList<Subcategory>subRegion;
    private    ArrayList<Subcategory>subZabava;

    private static int a,b,c,d;


  private RvCatagoryClick listener;

    public MenuInnerAdapter(ArrayList<Category> list  ,  ArrayList<Subcategory>subDrustvo,
                            ArrayList<Subcategory>subKultura,
                            ArrayList<Subcategory>subRegion, ArrayList<Subcategory>subZabava,RvCatagoryClick listener) {
        this.list = list;
        this.subDrustvo=subDrustvo;
        this.subRegion=subRegion;
        this.subKultura=subKultura;
        this.subZabava=subZabava;
       this.listener=listener;

    }
    @NonNull
    @Override
    public MenuHolderInner onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RvMenuItemBinding binding= RvMenuItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);


        return new MenuHolderInner(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuHolderInner holder, int position) {



        Category category =list.get(position);


        holder.binding.textView.setText(category.name);
        holder.binding.viewLine.setBackgroundColor(Color.parseColor(category.color));
        holder.binding.ImageView.setVisibility(View.GONE);
        holder.binding.recyclerView.setVisibility(View.GONE);

        a=0;
        b=0;
        c=0;
        d=0;


        if (category.name.contains("Društvo")){



            holder.binding.recyclerView.setVisibility(View.GONE);


            holder.binding.ImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                   if (a==0) {


                       holder.binding.ImageView.setImageResource(R.drawable.ic_arrow_up);

                       holder.binding.recyclerView.setVisibility(View.VISIBLE);


                       a=1;

                   }
                   else if (a==1) {

                       holder.binding.ImageView.setImageResource(R.drawable.ic_arrow_down);

                       holder.binding.recyclerView.setVisibility(View.GONE);


                       a=0;


                   }


                }
            });


            holder.binding.recyclerView.setAdapter(new MenuSubcategoryAdapter(subDrustvo, "#1c5497", new MenuSubcategoryAdapter.RvSubcatClick() {
                @Override
                public void onTextClick(int id) {

                    Intent i = new Intent(holder.binding.getRoot().getContext(),CategoryListClick.class);

                    i.putExtra("category",id);

                    holder.binding.getRoot().getContext().startActivity(i);
                }
            }));

            holder.binding.recyclerView.setLayoutManager(new LinearLayoutManager(holder.binding.getRoot().getContext()));

            holder.binding.ImageView.setVisibility(View.VISIBLE);
        }

        else if (category.name.contains("Kultura")) {



            holder.binding.recyclerView.setVisibility(View.GONE);

            holder.binding.ImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (b==0) {


                        holder.binding.ImageView.setImageResource(R.drawable.ic_arrow_up);

                        holder.binding.recyclerView.setVisibility(View.VISIBLE);


                        b=1;

                    }
                    else if (b==1) {

                        holder.binding.ImageView.setImageResource(R.drawable.ic_arrow_down);

                        holder.binding.recyclerView.setVisibility(View.GONE);


                        b=0;


                    }



                }
            });



            holder.binding.recyclerView.setAdapter(new MenuSubcategoryAdapter(subKultura, "#fd9526", new MenuSubcategoryAdapter.RvSubcatClick() {
                @Override
                public void onTextClick(int id) {

                    Intent i = new Intent(holder.binding.getRoot().getContext(),CategoryListClick.class);

                    i.putExtra("category",id);

                    holder.binding.getRoot().getContext().startActivity(i);

                }
            }));
            holder.binding.recyclerView.setLayoutManager(new LinearLayoutManager(holder.binding.getRoot().getContext()));
            holder.binding.ImageView.setVisibility(View.VISIBLE);

        }
        else if (category.name.contains("Region")) {


            holder.binding.recyclerView.setVisibility(View.GONE);

            holder.binding.ImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (c==0) {


                        holder.binding.ImageView.setImageResource(R.drawable.ic_arrow_up);

                        holder.binding.recyclerView.setVisibility(View.VISIBLE);


                        c=1;

                    }
                    else if (c==1) {

                        holder.binding.ImageView.setImageResource(R.drawable.ic_arrow_down);

                        holder.binding.recyclerView.setVisibility(View.GONE);


                        c=0;


                    }

                }
            });



            holder.binding.recyclerView.setAdapter(new MenuSubcategoryAdapter(subRegion, "#070751", new MenuSubcategoryAdapter.RvSubcatClick() {
                @Override
                public void onTextClick(int id) {
                    Intent i = new Intent(holder.binding.getRoot().getContext(),CategoryListClick.class);

                    i.putExtra("category",id);

                    holder.binding.getRoot().getContext().startActivity(i);
                }
            }));
            holder.binding.recyclerView.setLayoutManager(new LinearLayoutManager(holder.binding.getRoot().getContext()));
            holder.binding.ImageView.setVisibility(View.VISIBLE);





        }
        else if (category.name.contains("Zabava")) {


            holder.binding.recyclerView.setVisibility(View.GONE);

            holder.binding.ImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (d==0) {


                        holder.binding.ImageView.setImageResource(R.drawable.ic_arrow_up);

                        holder.binding.recyclerView.setVisibility(View.VISIBLE);


                        d=1;

                    }
                    else if (d==1) {

                        holder.binding.ImageView.setImageResource(R.drawable.ic_arrow_down);

                        holder.binding.recyclerView.setVisibility(View.GONE);


                        d=0;


                    }

                }
            });






            holder.binding.recyclerView.setAdapter(new MenuSubcategoryAdapter(subZabava, "#d82292", new MenuSubcategoryAdapter.RvSubcatClick() {
                @Override
                public void onTextClick(int id) {
                    Intent i = new Intent(holder.binding.getRoot().getContext(),CategoryListClick.class);

                    i.putExtra("category",id);

                    holder.binding.getRoot().getContext().startActivity(i);
                }
            }));
            holder.binding.recyclerView.setLayoutManager(new LinearLayoutManager(holder.binding.getRoot().getContext()));
            holder.binding.ImageView.setVisibility(View.VISIBLE);



        }




        holder.binding.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener!=null){

                    listener.onTextClick(category.id);
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

    private RvMenuItemBinding binding;


    public MenuHolderInner( RvMenuItemBinding binding) {
        super(binding.getRoot());
      this.binding=binding;
    }
}

public interface RvCatagoryClick{
        void onTextClick(int id);
}



}
