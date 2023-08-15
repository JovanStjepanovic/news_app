package com.cubes.stjepanovic.zavrsniprojekat.fragments.home.adapter;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cubes.stjepanovic.zavrsniprojekat.activities.NewsDetailActivity;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvHomepageCategoryBinding;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.home.News;

import java.util.ArrayList;

public class HomePageNewsByCategoryPrimaryAdapter  extends RecyclerView.Adapter<HomePageNewsByCategoryPrimaryAdapter.HomePageNewsByCatHolder2>{


  private ArrayList<News>aktuelno;
    private ArrayList<News>drustvo;
    private ArrayList<News>svet;
    private ArrayList<News>region;
    private ArrayList<News>sport;
    private ArrayList<News>zabava;
    private ArrayList<News>beograd;
    private ArrayList<News>kultura;
    private ArrayList<News>ekonomija;
    private ArrayList<News>politika;

    private int c,b,f;



    public HomePageNewsByCategoryPrimaryAdapter(ArrayList<News> aktuelno,
                                                ArrayList<News> drustvo, ArrayList<News> svet,
                                                ArrayList<News> region, ArrayList<News> sport,
                                                ArrayList<News> zabava, ArrayList<News> beograd,
                                                ArrayList<News> kultura, ArrayList<News> ekonomija,
                                                ArrayList<News> politika, int c,int b,int f) {
        this.aktuelno = aktuelno;
        this.drustvo = drustvo;
        this.svet = svet;
        this.region = region;
        this.sport = sport;
        this.zabava = zabava;
        this.beograd = beograd;
        this.kultura = kultura;
        this.ekonomija = ekonomija;
        this.politika = politika;

        this.b=b;
        this.f=f;
        this.c=c;
    }

    @NonNull
    @Override
    public HomePageNewsByCatHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

     RvHomepageCategoryBinding binding= RvHomepageCategoryBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);


        return new HomePageNewsByCatHolder2(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HomePageNewsByCatHolder2 holder, int position) {


        if (position==0){

            if (aktuelno==null){
                holder.binding.viewLine3.setVisibility(View.GONE);

                holder.binding.textViewCategoryName.setVisibility(View.GONE);

                holder.binding.recyclerViewCategory.setVisibility(View.GONE);

                holder.binding.viewLine2.setVisibility(View.GONE);

            }

            if (c!=0){
                holder.binding.textViewCategoryName.setVisibility(View.GONE);
                holder.binding.viewLine3.setVisibility(View.GONE);

                holder.binding.viewLine2.setVisibility(View.GONE);
            }




            holder.binding.viewLine3.setBackgroundColor(Color.parseColor("#ff0000"));

            holder.binding.textViewCategoryName.setText("AKTUELNO");

            holder.binding.recyclerViewCategory.setAdapter(new HomePageNewsByCategoryAdapter(aktuelno, c, new HomePageNewsByCategoryAdapter.RvHomePageCategoryClick() {
                @Override
                public void onCLick(News news) {

                    Intent intent= new Intent(holder.binding.getRoot().getContext(), NewsDetailActivity.class);

                    intent.putExtra("news",news);


                    holder.binding.getRoot().getContext().startActivity(intent);

                }
            },b,f));

        }
        else if (position==1) {


            if (ekonomija==null){
                holder.binding.viewLine3.setVisibility(View.GONE);

                holder.binding.textViewCategoryName.setVisibility(View.GONE);

                holder.binding.recyclerViewCategory.setVisibility(View.GONE);
                holder.binding.viewLine2.setVisibility(View.GONE);
            }

            if (c!=0){
                holder.binding.textViewCategoryName.setVisibility(View.GONE);
                holder.binding.viewLine3.setVisibility(View.GONE);

                holder.binding.viewLine2.setVisibility(View.GONE);
            }




            holder.binding.viewLine3.setBackgroundColor(Color.parseColor("#123763"));

            holder.binding.textViewCategoryName.setText("EKONOMIJA");

            holder.binding.recyclerViewCategory.setAdapter(new HomePageNewsByCategoryAdapter(ekonomija, c, new HomePageNewsByCategoryAdapter.RvHomePageCategoryClick() {
                @Override
                public void onCLick(News news) {
                    Intent intent= new Intent(holder.binding.getRoot().getContext(),NewsDetailActivity.class);

                    intent.putExtra("news",news);


                    holder.binding.getRoot().getContext().startActivity(intent);
                }
            },b,f));
        }

        else if (position==2) {

            if (sport==null){
                holder.binding.viewLine3.setVisibility(View.GONE);

                holder.binding.textViewCategoryName.setVisibility(View.GONE);

                holder.binding.recyclerViewCategory.setVisibility(View.GONE);
                holder.binding.viewLine2.setVisibility(View.GONE);
            }


            if (c!=0){
                holder.binding.textViewCategoryName.setVisibility(View.GONE);
                holder.binding.viewLine3.setVisibility(View.GONE);

                holder.binding.viewLine2.setVisibility(View.GONE);
            }




            holder.binding.viewLine3.setBackgroundColor(Color.parseColor("#02a4f4"));

            holder.binding.textViewCategoryName.setText("SPORT");

            holder.binding.recyclerViewCategory.setAdapter(new HomePageNewsByCategoryAdapter(sport, c, new HomePageNewsByCategoryAdapter.RvHomePageCategoryClick() {
                @Override
                public void onCLick(News news) {
                    Intent intent= new Intent(holder.binding.getRoot().getContext(),NewsDetailActivity.class);

                    intent.putExtra("news",news);


                    holder.binding.getRoot().getContext().startActivity(intent);
                }
            },b,f));
        }
        else if (position==3) {

            if (svet==null){
                holder.binding.viewLine3.setVisibility(View.GONE);

                holder.binding.textViewCategoryName.setVisibility(View.GONE);

                holder.binding.recyclerViewCategory.setVisibility(View.GONE);
                holder.binding.viewLine2.setVisibility(View.GONE);
            }



            if (c!=0){
                holder.binding.textViewCategoryName.setVisibility(View.GONE);
                holder.binding.viewLine3.setVisibility(View.GONE);

                holder.binding.viewLine2.setVisibility(View.GONE);
            }




            holder.binding.viewLine3.setBackgroundColor(Color.parseColor("#1e73be"));

            holder.binding.textViewCategoryName.setText("SVET");

            holder.binding.recyclerViewCategory.setAdapter(new HomePageNewsByCategoryAdapter(svet, c, new HomePageNewsByCategoryAdapter.RvHomePageCategoryClick() {
                @Override
                public void onCLick(News news) {
                    Intent intent= new Intent(holder.binding.getRoot().getContext(),NewsDetailActivity.class);

                    intent.putExtra("news",news);


                    holder.binding.getRoot().getContext().startActivity(intent);
                }
            },b,f));
        }
        else if (position==4) {

            if (drustvo==null){
                holder.binding.viewLine3.setVisibility(View.GONE);

                holder.binding.textViewCategoryName.setVisibility(View.GONE);

                holder.binding.recyclerViewCategory.setVisibility(View.GONE);
                holder.binding.viewLine2.setVisibility(View.GONE);
            }


            if (c!=0){
                holder.binding.textViewCategoryName.setVisibility(View.GONE);
                holder.binding.viewLine3.setVisibility(View.GONE);

                holder.binding.viewLine2.setVisibility(View.GONE);
            }




            holder.binding.viewLine3.setBackgroundColor(Color.parseColor("#1c5497"));

            holder.binding.textViewCategoryName.setText("DRUŠTVO");

            holder.binding.recyclerViewCategory.setAdapter(new HomePageNewsByCategoryAdapter(drustvo, c, new HomePageNewsByCategoryAdapter.RvHomePageCategoryClick() {
                @Override
                public void onCLick(News news) {
                    Intent intent= new Intent(holder.binding.getRoot().getContext(),NewsDetailActivity.class);

                    intent.putExtra("news",news);


                    holder.binding.getRoot().getContext().startActivity(intent);
                }
            },b,f));
        }
        else if (position==5) {

            if (politika==null){
                holder.binding.viewLine3.setVisibility(View.GONE);

                holder.binding.textViewCategoryName.setVisibility(View.GONE);

                holder.binding.recyclerViewCategory.setVisibility(View.GONE);
                holder.binding.viewLine2.setVisibility(View.GONE);
            }

            if (c!=0){
                holder.binding.textViewCategoryName.setVisibility(View.GONE);
                holder.binding.viewLine3.setVisibility(View.GONE);

                holder.binding.viewLine2.setVisibility(View.GONE);
            }





            holder.binding.viewLine3.setBackgroundColor(Color.parseColor("#1e73be"));

            holder.binding.textViewCategoryName.setText("POLITIKA");

            holder.binding.recyclerViewCategory.setAdapter(new HomePageNewsByCategoryAdapter(politika, c, new HomePageNewsByCategoryAdapter.RvHomePageCategoryClick() {
                @Override
                public void onCLick(News news) {
                    Intent intent= new Intent(holder.binding.getRoot().getContext(),NewsDetailActivity.class);

                    intent.putExtra("news",news);


                    holder.binding.getRoot().getContext().startActivity(intent);
                }
            },b,f));
        }
        else if (position==6) {

            if (zabava==null){
                holder.binding.viewLine3.setVisibility(View.GONE);

                holder.binding.textViewCategoryName.setVisibility(View.GONE);

                holder.binding.recyclerViewCategory.setVisibility(View.GONE);
                holder.binding.viewLine2.setVisibility(View.GONE);
            }

            if (c!=0){
                holder.binding.textViewCategoryName.setVisibility(View.GONE);
                holder.binding.viewLine3.setVisibility(View.GONE);

                holder.binding.viewLine2.setVisibility(View.GONE);
            }





            holder.binding.viewLine3.setBackgroundColor(Color.parseColor("#d82292"));

            holder.binding.textViewCategoryName.setText("ZABAVA");

            holder.binding.recyclerViewCategory.setAdapter(new HomePageNewsByCategoryAdapter(zabava, c, new HomePageNewsByCategoryAdapter.RvHomePageCategoryClick() {
                @Override
                public void onCLick(News news) {
                    Intent intent= new Intent(holder.binding.getRoot().getContext(),NewsDetailActivity.class);

                    intent.putExtra("news",news);


                    holder.binding.getRoot().getContext().startActivity(intent);
                }
            },b,f));
        }
        else if (position==7) {


            if (kultura==null){
                holder.binding.viewLine3.setVisibility(View.GONE);

                holder.binding.textViewCategoryName.setVisibility(View.GONE);

                holder.binding.recyclerViewCategory.setVisibility(View.GONE);
                holder.binding.viewLine2.setVisibility(View.GONE);
            }


            if (c!=0){
                holder.binding.textViewCategoryName.setVisibility(View.GONE);
                holder.binding.viewLine3.setVisibility(View.GONE);

                holder.binding.viewLine2.setVisibility(View.GONE);
            }



            holder.binding.viewLine3.setBackgroundColor(Color.parseColor("#fd9526"));

            holder.binding.textViewCategoryName.setText("KULTURA");

            holder.binding.recyclerViewCategory.setAdapter(new HomePageNewsByCategoryAdapter(kultura, c, new HomePageNewsByCategoryAdapter.RvHomePageCategoryClick() {
                @Override
                public void onCLick(News news) {
                    Intent intent= new Intent(holder.binding.getRoot().getContext(),NewsDetailActivity.class);

                    intent.putExtra("news",news);


                    holder.binding.getRoot().getContext().startActivity(intent);
                }
            },b,f));
        }
        else if (position==8) {

            if (region==null){
                holder.binding.viewLine3.setVisibility(View.GONE);

                holder.binding.textViewCategoryName.setVisibility(View.GONE);

                holder.binding.recyclerViewCategory.setVisibility(View.GONE);
                holder.binding.viewLine2.setVisibility(View.GONE);
            }

            if (c!=0){
                holder.binding.textViewCategoryName.setVisibility(View.GONE);
                holder.binding.viewLine3.setVisibility(View.GONE);

                holder.binding.viewLine2.setVisibility(View.GONE);
            }



            holder.binding.viewLine3.setBackgroundColor(Color.parseColor("#070751"));

            holder.binding.textViewCategoryName.setText("REGION");

            holder.binding.recyclerViewCategory.setAdapter(new HomePageNewsByCategoryAdapter(region, c, new HomePageNewsByCategoryAdapter.RvHomePageCategoryClick() {
                @Override
                public void onCLick(News news) {
                    Intent intent= new Intent(holder.binding.getRoot().getContext(),NewsDetailActivity.class);

                    intent.putExtra("news",news);


                    holder.binding.getRoot().getContext().startActivity(intent);
                }
            },b,f));
        }
        else if (position==9) {


            if (beograd==null){
                holder.binding.viewLine3.setVisibility(View.GONE);

                holder.binding.textViewCategoryName.setVisibility(View.GONE);

                holder.binding.recyclerViewCategory.setVisibility(View.GONE);
                holder.binding.viewLine2.setVisibility(View.GONE);
            }


              if (c!=0){
                  holder.binding.textViewCategoryName.setVisibility(View.GONE);
                  holder.binding.viewLine3.setVisibility(View.GONE);

                  holder.binding.viewLine2.setVisibility(View.GONE);
              }





            holder.binding.viewLine3.setBackgroundColor(Color.parseColor("#1e73be"));

            holder.binding.textViewCategoryName.setText("BEOGRAD");

            holder.binding.recyclerViewCategory.setAdapter(new HomePageNewsByCategoryAdapter(beograd, c, new HomePageNewsByCategoryAdapter.RvHomePageCategoryClick() {
                @Override
                public void onCLick(News news) {
                    Intent intent= new Intent(holder.binding.getRoot().getContext(),NewsDetailActivity.class);

                    intent.putExtra("news",news);


                    holder.binding.getRoot().getContext().startActivity(intent);
                }
            },b,f));
        }











    }

    @Override
    public int getItemCount() {

         return 10;

    }

    public class HomePageNewsByCatHolder2 extends RecyclerView.ViewHolder{

    public RvHomepageCategoryBinding binding;


    public HomePageNewsByCatHolder2(RvHomepageCategoryBinding binding) {
        super(binding.getRoot());
        this.binding=binding;

        binding.recyclerViewCategory.setLayoutManager
                (new LinearLayoutManager(binding.getRoot().getContext(),LinearLayoutManager.VERTICAL,false));

    }
}

public void setList(ArrayList<News> aktuelno,
                    ArrayList<News> drustvo, ArrayList<News> svet,
                    ArrayList<News> region, ArrayList<News> sport,
                    ArrayList<News> zabava, ArrayList<News> beograd,
                    ArrayList<News> kultura, ArrayList<News> ekonomija,
                    ArrayList<News> politika){

    this.aktuelno = aktuelno;
    this.drustvo = drustvo;
    this.svet = svet;
    this.region = region;
    this.sport = sport;
    this.zabava = zabava;
    this.beograd = beograd;
    this.kultura = kultura;
    this.ekonomija = ekonomija;
    this.politika = politika;


notifyDataSetChanged();









    }





}
