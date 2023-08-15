package com.cubes.stjepanovic.zavrsniprojekat.activities.newsdetailAdapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.cubes.stjepanovic.zavrsniprojekat.R;
import com.cubes.stjepanovic.zavrsniprojekat.activities.AddCommentActivity;
import com.cubes.stjepanovic.zavrsniprojekat.activities.NewsDetailActivity;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvNewsDetailAllCommentsBinding;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvNewsDetailCommentsBinding;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvNewsDetailGalleryBinding;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvNewsDetailRelatedNewsBinding;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvNewsDetailShareBinding;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvNewsDetailTagsBinding;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvNewsDetailTextBinding;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvNewsDetailTitleBinding;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvVerticalRvForCatNewsBinding;
import com.cubes.stjepanovic.zavrsniprojekat.fragments.home.adapter.HomePageTopAdapter;
import com.cubes.stjepanovic.zavrsniprojekat.model.Gallery;
import com.cubes.stjepanovic.zavrsniprojekat.model.comments.Comment;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.home.News;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.newsdetail.Tag;

import java.util.ArrayList;

public class NewsDetailAdapter extends RecyclerView.Adapter<NewsDetailAdapter.HolderNewsDetail> {


    private News news ;
    private ArrayList<News>related_news;
    private ArrayList<Tag>tags;
    private ArrayList<Comment>comment;
    private  ArrayList<Comment>firstCoupleOfComments;


    private RvonGalleryclick listener;

    private static int b,c;

    public NewsDetailAdapter( News news,ArrayList<News> related_news, ArrayList<Tag> tags, ArrayList<Comment>comment,RvonGalleryclick listener) {
        this.news = news;
        this.related_news = related_news;
        this.tags = tags;
         this.comment=comment;
       this.listener=listener;
    }

    @NonNull
    @Override
    public HolderNewsDetail onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      HolderNewsDetail holder= null;


      if (viewType==0){

          RvNewsDetailTitleBinding binding= RvNewsDetailTitleBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

          holder=new HolderNewsDetail(binding);
      }
      else if (viewType==1){

          RvNewsDetailTextBinding binding= RvNewsDetailTextBinding .inflate(LayoutInflater.from(parent.getContext()),parent,false);

          holder=new HolderNewsDetail(binding);

      }
      else if (viewType==2){

          RvNewsDetailGalleryBinding binding= RvNewsDetailGalleryBinding .inflate(LayoutInflater.from(parent.getContext()),parent,false);

          holder=new HolderNewsDetail(binding);


      }
      else if (viewType==3){

          RvNewsDetailShareBinding binding= RvNewsDetailShareBinding .inflate(LayoutInflater.from(parent.getContext()),parent,false);

          holder=new HolderNewsDetail(binding);

      }
      else if (viewType==4){

          RvNewsDetailTagsBinding binding= RvNewsDetailTagsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

          holder=new HolderNewsDetail(binding);

      }
      else if (viewType==5){

          RvNewsDetailCommentsBinding binding=   RvNewsDetailCommentsBinding .inflate(LayoutInflater.from(parent.getContext()),parent,false);

          holder=new HolderNewsDetail(binding);

      }
      else if (viewType==6){

          RvVerticalRvForCatNewsBinding binding=  RvVerticalRvForCatNewsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

          holder=new HolderNewsDetail(binding);

      }


      else if (viewType==7){

          RvNewsDetailAllCommentsBinding binding=  RvNewsDetailAllCommentsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

          holder=new HolderNewsDetail(binding);

      }



      else if (viewType==8){

          RvNewsDetailRelatedNewsBinding binding=  RvNewsDetailRelatedNewsBinding .inflate(LayoutInflater.from(parent.getContext()),parent,false);

          holder=new HolderNewsDetail(binding);

      }








        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderNewsDetail holder, int position) {




        if (comment!= null) {

           b = comment.size();
       }

        if (getItemViewType(position)==0){



            if (news.title == null && news.image==null && news.url== null ){




            }

            else {

                ((RvNewsDetailTitleBinding) holder.binding).textViewCommentNumber.setText("" + b);


                ((RvNewsDetailTitleBinding) holder.binding).textViewTitle.setText(news.title);

                ((RvNewsDetailTitleBinding) holder.binding).textViewAuthorBlue.setText(news.author_name);


                if (news.source != null && news.source.length()>0) {

                    ((RvNewsDetailTitleBinding) holder.binding).textViewAuthorSourceBlue.setText(news.source);


                } else {
                    ((RvNewsDetailTitleBinding) holder.binding).textViewAuthorSourceBlue.setText("GNN");
                }

                if (news.created_at != null) {

                    ((RvNewsDetailTitleBinding) holder.binding).textViewDate.setText(news.created_at);


                } else {
                    ((RvNewsDetailTitleBinding) holder.binding).textViewDate.setText("21.02.2015");

                }


            }



        }
        else if (getItemViewType(position)==1) {

            ((RvNewsDetailTextBinding)holder.binding).webView.setWebViewClient(new WebViewClient());


            if (news.url != null){
                ((RvNewsDetailTextBinding)holder.binding).webView.loadUrl(news.url);
            }

            else {

            }



        }

        else if (getItemViewType(position)==2) {




            ((RvNewsDetailGalleryBinding)holder.binding).imageViewGallery.setImageResource(R.drawable.stockgallery);


            ((RvNewsDetailGalleryBinding)holder.binding).frameLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (listener!=null){

                        listener.onGalleryClick();
                    }


                }
            });




        }

        else if (getItemViewType(position)==3) {



            ((RvNewsDetailShareBinding)holder.binding).imageviewFace.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Intent i = new Intent(Intent.ACTION_SEND);

                    i.setType("text/plain");

                    i.setPackage("com.facebook.katana");

                    i.putExtra(Intent.EXTRA_TEXT,news.url);


                    holder.binding.getRoot().getContext().startActivity(Intent.createChooser(i,"share"));


                }
            });



            ((RvNewsDetailShareBinding)holder.binding).imageviewInstagram.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(Intent.ACTION_SEND);

                    i.setType("text/plain");

                    i.setPackage("com.instagram.android");

                    i.putExtra(Intent.EXTRA_TEXT,news.url);


                    holder.binding.getRoot().getContext().startActivity(Intent.createChooser(i,"share"));

                }
            });


            ((RvNewsDetailShareBinding)holder.binding).imageviewTwitter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(Intent.ACTION_SEND);

                    i.setType("text/plain");

                    i.setPackage("com.twitter.android");

                    i.putExtra(Intent.EXTRA_TEXT,news.url);


                    holder.binding.getRoot().getContext().startActivity(Intent.createChooser(i,"share"));


                }
            });

            ((RvNewsDetailShareBinding)holder.binding).imageviewViber.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(Intent.ACTION_SEND);

                    i.setType("text/plain");

                    i.setPackage("com.viber.voip");

                    i.putExtra(Intent.EXTRA_TEXT,news.url);


                    holder.binding.getRoot().getContext().startActivity(Intent.createChooser(i,"share"));




                }
            });




            ((RvNewsDetailShareBinding)holder.binding).imageviewWhatsApp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(Intent.ACTION_SEND);

                    i.setType("text/plain");

                    i.setPackage("com.whatsapp");

                    i.putExtra(Intent.EXTRA_TEXT,news.url);


                    holder.binding.getRoot().getContext().startActivity(Intent.createChooser(i,"share"));





                }
            });





        }  else if (getItemViewType(position)==4) {


            ((RvNewsDetailTagsBinding)holder.binding).recyclerView.setAdapter(new TagAdapter(tags));

            ((RvNewsDetailTagsBinding)holder.binding).recyclerView.setLayoutManager(new GridLayoutManager(holder.binding.getRoot().getContext(),3));




        }  else if (getItemViewType(position)==5) {



            ((RvNewsDetailCommentsBinding)holder.binding).textViewCommentNumber.setText(""+b);


            ((RvNewsDetailCommentsBinding)holder.binding).frameLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                  Intent   intent= new Intent(holder.binding.getRoot().getContext(), AddCommentActivity.class);


                    intent.putExtra("news", news);


                    holder.binding.getRoot().getContext().startActivity(intent);







                }
            });


        }  else if (getItemViewType(position)==6) {


            if (c==0){

                ((RvVerticalRvForCatNewsBinding) holder.binding).recyclerViewCategory.setAdapter(new CommentsAdapter(firstCoupleOfComments));

                ((RvVerticalRvForCatNewsBinding) holder.binding).recyclerViewCategory.setLayoutManager(new LinearLayoutManager(holder.binding.getRoot().getContext()));


            }


            else if (c==1){

                ((RvVerticalRvForCatNewsBinding) holder.binding).recyclerViewCategory.setAdapter(new CommentsAdapter(comment));

                ((RvVerticalRvForCatNewsBinding) holder.binding).recyclerViewCategory.setLayoutManager(new LinearLayoutManager(holder.binding.getRoot().getContext()));

            }







        }



        else if (getItemViewType(position)==7) {


            ((RvNewsDetailAllCommentsBinding)holder.binding).textViewCommentNumber.setText(""+b);


            ((RvNewsDetailAllCommentsBinding)holder.binding).frameLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {





                    if (c==0){

                        c=c+1;


                    }

                    else if (c==1) {
                       c=c-1;



                    }


                    notifyDataSetChanged();

                }
            });


        }

        else if (getItemViewType(position)==8) {



            ((RvNewsDetailRelatedNewsBinding)holder.binding).recyclerView.setAdapter(new HomePageTopAdapter(related_news, new HomePageTopAdapter.RvTopClick() {
                @Override
                public void onClick(News news) {

                    Intent intent = new Intent(holder.binding.getRoot().getContext(), NewsDetailActivity.class);

                    intent.putExtra("news",news);

                    holder.binding.getRoot().getContext().startActivity(intent);
                }
            }));
            ((RvNewsDetailRelatedNewsBinding)holder.binding).recyclerView.setLayoutManager(new LinearLayoutManager(null));



        }







    }

    @Override
    public int getItemCount() {
        return 9;
    }

    @Override
    public int getItemViewType(int position) {

        if (position==0){

            return 0;
        }
        else if (position==1) {

            return 1;
        }

        else if (position==2) {

            return 2;
        }
        else if (position==3) {

            return 3;
        }
        else if (position==4) {

            return 4;
        }
        else if (position==5) {

            return 5;
        }
        else if (position==6) {

            return 6;
        }

        else if (position==7) {

        return 7;
    }
        else if (position==8) {

            return 8;
        }

        else {
           return 10;
        }
    }

    public  class HolderNewsDetail extends RecyclerView.ViewHolder{

    private ViewBinding binding;


    public HolderNewsDetail(ViewBinding binding) {
        super(binding.getRoot());

     this.binding=binding;

    }
}


public void setList( News news,ArrayList<Tag>tags,ArrayList<News>related_news,
                    ArrayList<Comment>comment, ArrayList<Comment>firstCoupleOfComments){

        this.news=news;
        this.tags=tags;
        this.related_news=related_news;
        this.firstCoupleOfComments=firstCoupleOfComments;
        this.comment=comment;
        notifyDataSetChanged();

    }

public interface RvonGalleryclick{
     void   onGalleryClick();
}



}
