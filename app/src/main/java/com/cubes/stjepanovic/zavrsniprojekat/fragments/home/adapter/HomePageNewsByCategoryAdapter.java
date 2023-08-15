package com.cubes.stjepanovic.zavrsniprojekat.fragments.home.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.cubes.stjepanovic.zavrsniprojekat.R;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvHpCategoryItemBigBinding;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvHpCategoryItemSmallBinding;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.home.News;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomePageNewsByCategoryAdapter extends RecyclerView.Adapter<HomePageNewsByCategoryAdapter.HomepageNewsByCategoryAdapterHolder> {


   private ArrayList<News> list;
  private int c,b,f;

  private RvHomePageCategoryClick listener;




    public HomePageNewsByCategoryAdapter(ArrayList<News> news, int c,RvHomePageCategoryClick listener,int b ,int f) {
        this.list = news;
        this.c=c;
        this.b=b;
        this.f=f;

       this.listener= listener;
    }

    @NonNull
    @Override
    public HomepageNewsByCategoryAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

         HomepageNewsByCategoryAdapterHolder holder= null;


        if (viewType ==0){

            RvHpCategoryItemBigBinding binding= RvHpCategoryItemBigBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

          holder= new HomepageNewsByCategoryAdapterHolder(binding);

        }

        else   {


            RvHpCategoryItemSmallBinding binding= RvHpCategoryItemSmallBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);


            holder= new HomepageNewsByCategoryAdapterHolder(binding);


        }

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomepageNewsByCategoryAdapterHolder holder, int position) {

        News news =list.get(position);



     if (news.category == null || news.image == null || news.title==null) {


      }


       else {


            if (getItemViewType(position) == 0) {

                ((RvHpCategoryItemBigBinding) holder.binding).textViewTitleCategoryBig.setText(list.get(0).title);
                ((RvHpCategoryItemBigBinding) holder.binding).textViewTime.setText(list.get(0).created_at);
                ((RvHpCategoryItemBigBinding) holder.binding).textViewCategory.setText(list.get(0).category.name);
                Picasso.get().load(list.get(0).image).into(((RvHpCategoryItemBigBinding) holder.binding).imageviewCategory);

                ((RvHpCategoryItemBigBinding) holder.binding).textViewCategory.setTextColor(Color.parseColor(news.category.color));



                if (b==0){
                    ((RvHpCategoryItemBigBinding) holder.binding).buttonLoad.setVisibility(View.GONE);
                }

                else {

                    ((RvHpCategoryItemBigBinding) holder.binding).buttonLoad.setVisibility(View.VISIBLE);



                    ((RvHpCategoryItemBigBinding) holder.binding).buttonLoad.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (f==1){

                                f=0;

                                ((RvHpCategoryItemBigBinding) holder.binding).buttonLoad.setText(R.string.less_news);

                            } else if (f==0) {
                                f=1;

                                ((RvHpCategoryItemBigBinding) holder.binding).buttonLoad.setText(R.string.all_news);
                            }




                            notifyDataSetChanged();

                        }
                    });





                }




            } else {


                ((RvHpCategoryItemSmallBinding) holder.binding).textViewCategorySmall.setText(news.category.name);
                ((RvHpCategoryItemSmallBinding) holder.binding).textViewCategoryTimeSmall.setText(news.created_at);
                ((RvHpCategoryItemSmallBinding) holder.binding).textViewTitleCategorySmall.setText(news.title);

                ((RvHpCategoryItemSmallBinding) holder.binding).textViewCategorySmall.setTextColor(Color.parseColor(news.category.color));


                Picasso.get().load(news.image).into(((RvHpCategoryItemSmallBinding) holder.binding).imageViewCategorySmall);













            }

        }



          holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

                  if (listener!=null){

                      listener.onCLick(news);
                  }


              }
          });









    }

    @Override
    public int getItemCount() {

        if (list==null){

            return 0;
        }
        else if (c!=0 && f==0) {

           return list.size();
        }

        else if (c!=0 && f == 1) {

            return 10;

        } else {

            return 5;
        }


    }

    public class HomepageNewsByCategoryAdapterHolder extends RecyclerView.ViewHolder{

        private ViewBinding binding;

        public HomepageNewsByCategoryAdapterHolder(ViewBinding binding) {
            super(binding.getRoot());
        this.binding=binding;
        }
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0){

            return 0;
        }
      else {
          return 1;
        }
    }

public void setList(ArrayList<News>news){
        this.list=news;
notifyDataSetChanged();
    }

public interface RvHomePageCategoryClick{

        void onCLick(News news);
}

}
