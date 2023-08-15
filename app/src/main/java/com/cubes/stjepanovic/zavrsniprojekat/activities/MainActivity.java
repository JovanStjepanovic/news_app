package com.cubes.stjepanovic.zavrsniprojekat.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.cubes.stjepanovic.zavrsniprojekat.R;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.ActivityMainBinding;
import com.cubes.stjepanovic.zavrsniprojekat.fragments.home.HomeFragment;
import com.cubes.stjepanovic.zavrsniprojekat.fragments.newest.NewestFragment;
import com.cubes.stjepanovic.zavrsniprojekat.fragments.search.SearchFragment;
import com.cubes.stjepanovic.zavrsniprojekat.fragments.video.VideoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

   private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


          getSupportFragmentManager().beginTransaction().replace(R.id.Container, HomeFragment.newInstance()).commit();



          binding.bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
              @Override
              public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                  Fragment selectedFragment=null;


                  switch (item.getItemId()){


                      case  R.id.home:

                      selectedFragment=HomeFragment.newInstance();
                          break;


                      case  R.id.newest:

                          selectedFragment= NewestFragment.newInstance();
                          break;

                      case  R.id.video:

                          selectedFragment= VideoFragment.newInstance();
                          break;

                      case  R.id.search:

                          selectedFragment= SearchFragment.newInstance();
                          break;


                  }


                  getSupportFragmentManager().beginTransaction().replace(R.id.Container,selectedFragment).commit();



                  return true;
              }
          });























    }
}