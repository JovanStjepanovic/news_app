package com.cubes.stjepanovic.zavrsniprojekat.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import com.cubes.stjepanovic.zavrsniprojekat.R;
import com.cubes.stjepanovic.zavrsniprojekat.activities.menuAdapters.MenuAdapter;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.MenuBinding;
import com.cubes.stjepanovic.zavrsniprojekat.model.categories.CategoriesResponse;
import com.cubes.stjepanovic.zavrsniprojekat.model.categories.Category;
import com.cubes.stjepanovic.zavrsniprojekat.model.categories.subacategory.Subcategory;
import com.cubes.stjepanovic.zavrsniprojekat.networking.RetrofitClient;
import com.cubes.stjepanovic.zavrsniprojekat.networking.RetrofitService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuActivity extends AppCompatActivity {


    private MenuBinding binding;
    private static  ArrayList<Category>categories;
    private MenuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=MenuBinding.inflate(getLayoutInflater());


        setContentView(binding.getRoot());



        adapter = new MenuAdapter(null);


        binding.recyclerViewCategory.setAdapter(adapter);
        binding.recyclerViewCategory.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));

        loaData();





    }


    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }

    private void loaData() {

     RetrofitService service = RetrofitClient.getInstance().getRetrofit().create(RetrofitService.class);


     service.getCategories().enqueue(new Callback<CategoriesResponse>() {
         @Override
         public void onResponse(Call<CategoriesResponse> call, Response<CategoriesResponse> response) {

             categories=response.body().data;

             Category naslovna =  new Category();


             naslovna.name="Naslonva";
             naslovna.color="#ffffff";


             categories.add(0,naslovna);


             ArrayList<Subcategory>subDrustvo= new ArrayList<>();

             ArrayList<Subcategory>subKultura= new ArrayList<>();

             ArrayList<Subcategory>subRegion= new ArrayList<>();
             ArrayList<Subcategory>subZabava= new ArrayList<>();












             for (Category category : categories){




                     if (category.id ==3) {

                         subDrustvo.addAll(category.subcategories);

                     }
                     else if (category.id ==9) {

                         subKultura.addAll(category.subcategories);



                     }

                     else if (category.id ==18) {
                         subRegion.addAll(category.subcategories);

                     }



                 else if (category.id ==13) {
                         subZabava.addAll(category.subcategories);
                     }









            }


             adapter.setList(categories,subDrustvo,subKultura,subRegion,subZabava);
             binding.progressBar.setVisibility(View.GONE);


         }

         @Override
         public void onFailure(Call<CategoriesResponse> call, Throwable t) {
             Toast.makeText(binding.getRoot().getContext(), R.string.failed_to_load, Toast.LENGTH_SHORT).show();
         }
     });







    }




}