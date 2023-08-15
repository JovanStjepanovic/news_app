package com.cubes.stjepanovic.zavrsniprojekat.activities.menuAdapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.cubes.stjepanovic.zavrsniprojekat.activities.MenuHoroscopesActivity;
import com.cubes.stjepanovic.zavrsniprojekat.activities.WeatherActivity;
import com.cubes.stjepanovic.zavrsniprojekat.activities.MenuActivity;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvMenuFirstSegmentBinding;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvMenuItem2Binding;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvMenuItem3Binding;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvVerticalRvForCatNewsBinding;
import com.cubes.stjepanovic.zavrsniprojekat.model.categories.Category;
import com.cubes.stjepanovic.zavrsniprojekat.model.categories.subacategory.Subcategory;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuHolder>{


    private ArrayList<Category>list;


 private    ArrayList<Subcategory>subDrustvo;

 private    ArrayList<Subcategory>subKultura;

private     ArrayList<Subcategory>subRegion;
 private    ArrayList<Subcategory>subZabava;





    public MenuAdapter(ArrayList<Category> list) {
        this.list = list;

    }

    @NonNull
    @Override
    public MenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      MenuHolder holder= null;


      if (viewType==0){

          RvMenuFirstSegmentBinding binding = RvMenuFirstSegmentBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

          holder=new MenuHolder(binding);



      }
      else if (viewType==1) {


          RvVerticalRvForCatNewsBinding binding= RvVerticalRvForCatNewsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

          holder=new MenuHolder(binding);






      }

      else if (viewType==2) {


          RvMenuItem2Binding binding= RvMenuItem2Binding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

          holder=new MenuHolder(binding);



      }


      else if (viewType==3) {

          RvMenuItem3Binding binding= RvMenuItem3Binding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

          holder=new MenuHolder(binding);


      }






        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MenuHolder holder, int position) {

        Category category= list.get(position);



        if (getItemViewType(position)==0){


            ((RvMenuFirstSegmentBinding)holder.binding).imageViewMenuBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    ((MenuActivity) holder.binding.getRoot().getContext()).onBackPressed();

                }
            });


        }

      else if (getItemViewType(position)==1){



            ((RvVerticalRvForCatNewsBinding)holder.binding).recyclerViewCategory.setAdapter(new MenuInnerAdapter(list, subDrustvo, subKultura, subRegion, subZabava, new MenuInnerAdapter.RvCatagoryClick() {
                @Override
                public void onTextClick(int id) {

                    Intent i = new Intent(holder.binding.getRoot().getContext(),CategoryListClick.class);

                   i.putExtra("category",id);

                  holder.binding.getRoot().getContext().startActivity(i);
                }
            }));

            ((RvVerticalRvForCatNewsBinding)holder.binding).recyclerViewCategory.setLayoutManager(new LinearLayoutManager(holder.binding.getRoot().getContext()));



        }



        else if (getItemViewType(position)==2){

            ((RvMenuItem2Binding)holder.binding).textViewWeather.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    holder.binding.getRoot().getContext().startActivity(new Intent(holder.binding.getRoot().getContext(),
                            WeatherActivity.class));
                }
            });


            ((RvMenuItem2Binding)holder.binding).textViewHoroscope.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    holder.binding.getRoot().getContext().startActivity(new Intent(holder.binding.getRoot().getContext(),
                            MenuHoroscopesActivity.class));


                }
            });



            ((RvMenuItem2Binding)holder.binding).textViewCurrency.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    holder.binding.getRoot().getContext().startActivity(new Intent(holder.binding.getRoot().getContext(),
                            ConversionRatesListActivity.class));


                }
            });





        }


        else if (getItemViewType(position)==3){





        }



    }

    @Override
    public int getItemCount() {

       if (list==null){

           return 0;
       }

       else {

           return 4;
       }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        }
        else if (position == 1) {

            return 1;
        } else if (position == 2) {

            return 2;
        }
     else if (position == 3) {

        return 3;
    }

        else {

            return 5;
        }
    }
    public class MenuHolder extends RecyclerView.ViewHolder{

private ViewBinding binding;

    public MenuHolder(ViewBinding binding) {
        super(binding.getRoot());
      this.binding=binding;
    }
}

public void setList(ArrayList<Category>categories,ArrayList<Subcategory>subDrustvo,
                    ArrayList<Subcategory>subKultura,
                    ArrayList<Subcategory>subRegion, ArrayList<Subcategory>subZabava

){
        this.list=categories;
        this.subDrustvo=subDrustvo;
        this.subKultura=subKultura;
        this.subRegion=subRegion;
        this.subZabava=subZabava;
        notifyDataSetChanged();

    }







}
