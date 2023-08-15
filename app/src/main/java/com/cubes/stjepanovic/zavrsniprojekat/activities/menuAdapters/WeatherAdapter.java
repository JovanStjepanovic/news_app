package com.cubes.stjepanovic.zavrsniprojekat.activities.menuAdapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvWeatherItemBinding;
import com.cubes.stjepanovic.zavrsniprojekat.model.weather.WeatherDay;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.MenuHolderInner>{

    private ArrayList<WeatherDay> list;





    public WeatherAdapter(ArrayList<WeatherDay> list) {
        this.list = list;

    }


    @NonNull
    @Override
    public MenuHolderInner onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RvWeatherItemBinding binding =  RvWeatherItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);


        return new MenuHolderInner(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuHolderInner holder, int position) {



        WeatherDay weatherDay= list.get(position);



        if (weatherDay.icon_url ==null || weatherDay.temp_min ==null || weatherDay.temp_max ==null){



        }


        else {

            holder.binding.textViewTempMax.setText(weatherDay.temp_max + "°C");
            holder.binding.textViewTempMin.setText(weatherDay.temp_min + "°C");
            holder.binding.textViewTempDivider.setText("/");
            Picasso.get().load(weatherDay.icon_url).into(holder.binding.imageViewIcon);










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

    public  class MenuHolderInner extends RecyclerView.ViewHolder{

    private RvWeatherItemBinding binding;


    public MenuHolderInner(   RvWeatherItemBinding binding) {
        super(binding.getRoot());
      this.binding=binding;
    }
}


public void setList(ArrayList<WeatherDay>list){
        this.list=list;
notifyDataSetChanged();
    }




}
