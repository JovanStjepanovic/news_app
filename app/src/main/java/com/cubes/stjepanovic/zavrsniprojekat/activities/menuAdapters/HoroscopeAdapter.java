package com.cubes.stjepanovic.zavrsniprojekat.activities.menuAdapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvHoroscopeItemBinding;
import com.cubes.stjepanovic.zavrsniprojekat.model.horoscope.Horoscope;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HoroscopeAdapter  extends RecyclerView.Adapter<HoroscopeAdapter.HoroscopeHolder> {


    private ArrayList<Horoscope>list;

    public HoroscopeAdapter(ArrayList<Horoscope> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public HoroscopeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       RvHoroscopeItemBinding binding=RvHoroscopeItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new HoroscopeHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HoroscopeHolder holder, int position) {

        Horoscope horoscope= list.get(position);


        if (holder.binding.textViewName == null || holder.binding.textViewDate == null ||
                holder.binding.imageView== null || holder.binding.textViewContnet ==null){



        }
        else {

            holder.binding.textViewContnet.setText(horoscope.horoscope);
            holder. binding.textViewDate.setText(horoscope.date);
            holder.binding.textViewName.setText(horoscope.name);

            Picasso.get().load(horoscope.image_url).into(holder.binding.imageView);


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

    public class HoroscopeHolder extends RecyclerView.ViewHolder{

    private RvHoroscopeItemBinding binding;

    public HoroscopeHolder( RvHoroscopeItemBinding binding) {
        super(binding.getRoot());
    this.binding=binding;
    }
}

public void setList(ArrayList<Horoscope>horoscopes){
        this.list=horoscopes;
        notifyDataSetChanged();
}


}
