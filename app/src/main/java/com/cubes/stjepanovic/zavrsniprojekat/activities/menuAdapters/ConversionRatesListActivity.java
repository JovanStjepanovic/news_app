package com.cubes.stjepanovic.zavrsniprojekat.activities.menuAdapters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.cubes.stjepanovic.zavrsniprojekat.databinding.ActivityConversionRatesListBinding;
import com.cubes.stjepanovic.zavrsniprojekat.model.Currencies;

import java.util.ArrayList;

public class ConversionRatesListActivity extends AppCompatActivity {

   private ActivityConversionRatesListBinding binding;
   private CurrencyAdapter adapter;
   private static ArrayList<Currencies>currencies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      binding=ActivityConversionRatesListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


       adapter= new CurrencyAdapter(null);


        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        loadList();


    }

   public void loadList() {

       currencies= new ArrayList<>();

       Currencies currency1 = new Currencies("EMU","EUR","117.2699 RSD");
       Currencies currency2 = new Currencies("SAD","USD","109.7416 RSD");
       Currencies currency3 = new Currencies("Švajcarska","CHF","120.8594 RSD");
       Currencies currency4 = new Currencies("VB","GBP","136.2494 RSD");
       Currencies currency5 = new Currencies("Hrvatska","HRK","15.5275 RSD");
       Currencies currency6 = new Currencies("BIH","BAM","59.9591 RSD");
       Currencies currency7 = new Currencies("UAE","AED","29.7468 RSD");
       Currencies currency8 = new Currencies("Australija","AUD","72.9524 RSD");


        currencies.add(currency1);
       currencies.add(currency2);
       currencies.add(currency3);
       currencies.add(currency4);
       currencies.add(currency5);
       currencies.add(currency6);
       currencies.add(currency7);
       currencies.add(currency8);


       currencies.add(currency1);
       currencies.add(currency2);
       currencies.add(currency3);
       currencies.add(currency4);
       currencies.add(currency5);
       currencies.add(currency6);
       currencies.add(currency7);
       currencies.add(currency8);

       currencies.add(currency1);
       currencies.add(currency2);
       currencies.add(currency3);
       currencies.add(currency4);
       currencies.add(currency5);
       currencies.add(currency6);
       currencies.add(currency7);
       currencies.add(currency8);

       currencies.add(currency1);
       currencies.add(currency2);
       currencies.add(currency3);
       currencies.add(currency4);
       currencies.add(currency5);
       currencies.add(currency6);
       currencies.add(currency7);
       currencies.add(currency8);

       currencies.add(currency1);
       currencies.add(currency2);
       currencies.add(currency3);
       currencies.add(currency4);
       currencies.add(currency5);
       currencies.add(currency6);
       currencies.add(currency7);
       currencies.add(currency8);

       currencies.add(currency1);
       currencies.add(currency2);
       currencies.add(currency3);
       currencies.add(currency4);
       currencies.add(currency5);
       currencies.add(currency6);
       currencies.add(currency7);
       currencies.add(currency8);



       adapter.setList(currencies);




   }


}