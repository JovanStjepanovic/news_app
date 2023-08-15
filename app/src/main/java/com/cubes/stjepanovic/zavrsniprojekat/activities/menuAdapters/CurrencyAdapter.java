package com.cubes.stjepanovic.zavrsniprojekat.activities.menuAdapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvCurrencyItemBinding;
import com.cubes.stjepanovic.zavrsniprojekat.model.Currencies;

import java.util.ArrayList;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.MenuHolderInner>{

    private ArrayList<Currencies> list;





    public CurrencyAdapter(ArrayList<Currencies> list) {
        this.list = list;

    }


    @NonNull
    @Override
    public MenuHolderInner onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RvCurrencyItemBinding binding=  RvCurrencyItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);


        return new MenuHolderInner(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuHolderInner holder, int position) {


        Currencies currencies= list.get(position);


          if (currencies.name == null || currencies.rate==null || currencies.symbol == null){


          }

        else {
              holder.binding.textViewCountry.setText(currencies.name);
              holder.binding.textViewRate.setText(currencies.rate);
              holder.binding.textViewSymbol.setText(currencies.symbol);
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

    private RvCurrencyItemBinding binding;


    public MenuHolderInner( RvCurrencyItemBinding binding) {
        super(binding.getRoot());
      this.binding=binding;
    }
}

public void setList(ArrayList<Currencies>list){
        this.list=list;
notifyDataSetChanged();
    }






}
