package com.cubes.stjepanovic.zavrsniprojekat.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cubes.stjepanovic.zavrsniprojekat.R;
import com.cubes.stjepanovic.zavrsniprojekat.activities.menuAdapters.WeatherAdapter;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.ActivityWeatherBinding;
import com.cubes.stjepanovic.zavrsniprojekat.model.weather.Weather;
import com.cubes.stjepanovic.zavrsniprojekat.model.weather.WeatherDay;
import com.cubes.stjepanovic.zavrsniprojekat.model.weather.WeatherResponse;
import com.cubes.stjepanovic.zavrsniprojekat.networking.RetrofitClient;
import com.cubes.stjepanovic.zavrsniprojekat.networking.RetrofitService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherActivity extends AppCompatActivity {

    private ActivityWeatherBinding binding;
    private RetrofitService service;
   private  static  Weather weather;
   private static ArrayList<WeatherDay>days= new ArrayList<>();
   private WeatherAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityWeatherBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.textViewWeather.setVisibility(View.INVISIBLE);
        binding.textViewCity.setVisibility(View.INVISIBLE);
        binding.textViewPressure.setVisibility(View.INVISIBLE);
        binding.textViewHumidity.setVisibility(View.INVISIBLE);
        binding.textViewTemperature.setVisibility(View.INVISIBLE);
        binding.textViewWind.setVisibility(View.INVISIBLE);


        loadData();




        adapter=new WeatherAdapter(null);

           binding.recyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));
           binding.recyclerView.setAdapter(adapter);



    }


private void loadData(){

        service= RetrofitClient.getInstance().getRetrofit().create(RetrofitService.class);


        service.getWeather().enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {


                weather=response.body().data;



                days.add(weather.day_0);
                days.add(weather.day_1);
                days.add(weather.day_2);
                days.add(weather.day_3);
                days.add(weather.day_4);
                days.add(weather.day_5);
                days.add(weather.day_6);


                binding.textViewWeather.setVisibility(View.VISIBLE);
                binding.textViewCity.setVisibility(View.VISIBLE);
                binding.textViewPressure.setVisibility(View.VISIBLE);
                binding.textViewHumidity.setVisibility(View.VISIBLE);
                binding.textViewTemperature.setVisibility(View.VISIBLE);
                binding.textViewWind.setVisibility(View.VISIBLE);




                binding.porgressBar.setVisibility(View.GONE);

                binding.textViewCity.setText(weather.name);
                binding.textViewPressure.setText("Pritisak:" +" "+weather.pressure+" "+"mBar");
                binding.textViewHumidity.setText("Vlažnost:"+" "+weather.humidity+" "+"%");
                binding.textViewTemperature.setText("Temperatura:"+" "+weather.temp+"°C");
                binding.textViewWind.setText("Brzina Vetra:"+" "+weather.wind+"km/h");

                Picasso.get().load(weather.icon_url).into(binding.imageViewIcon);


                adapter.setList(days);





            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Toast.makeText(binding.getRoot().getContext(), R.string.failed_to_load, Toast.LENGTH_SHORT).show();
            }
        });

}



}