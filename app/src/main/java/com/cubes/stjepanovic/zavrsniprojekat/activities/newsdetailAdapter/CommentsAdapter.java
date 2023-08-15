package com.cubes.stjepanovic.zavrsniprojekat.activities.newsdetailAdapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cubes.stjepanovic.zavrsniprojekat.activities.ReplyActivity;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.RvNewsDetailCommentsItemBinding;
import com.cubes.stjepanovic.zavrsniprojekat.model.comments.Comment;
import com.cubes.stjepanovic.zavrsniprojekat.model.comments.CommentResponse;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.home.News;
import com.cubes.stjepanovic.zavrsniprojekat.networking.RetrofitClient;
import com.cubes.stjepanovic.zavrsniprojekat.networking.RetrofitService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.MenuHolderInner>{

    private ArrayList<Comment> list;






    public CommentsAdapter(ArrayList<Comment> list) {
        this.list = list;

    }


    @NonNull
    @Override
    public MenuHolderInner onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RvNewsDetailCommentsItemBinding binding=   RvNewsDetailCommentsItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);


        return new MenuHolderInner(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuHolderInner holder, int position) {




                        Comment comment = list.get(position);

                        holder.binding.textviewName.setText(comment.name);
                        holder.binding.textviewContent.setText(comment.content);
                        holder.binding.textviewDate.setText(comment.created_at);
                        holder.binding.textViewDislikes.setText("" + comment.negative_votes);
                        holder.binding.textViewLikes.setText("" + comment.positive_votes);


                        if (comment.children != null) {

                            holder.binding.recyclerView.setLayoutManager(new LinearLayoutManager(holder.binding.getRoot().getContext()));
                            holder.binding.recyclerView.setAdapter(new CommentsAdapter(comment.children));


                        }



                 holder.binding.imageView2.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {

                         Intent intent =new Intent(holder.binding.getRoot().getContext(), ReplyActivity.class);

                         intent.putExtra("comment",comment.id);

                          holder.binding.getRoot().getContext().startActivity(intent);


                     }
                 });



                        holder.binding.textviewReply.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                Intent intent =new Intent(holder.binding.getRoot().getContext(), ReplyActivity.class);

                                intent.putExtra("comment",comment.id);

                                holder.binding.getRoot().getContext().startActivity(intent);

                            }
                        });



                          holder.binding.imageViewLike.setOnClickListener(new View.OnClickListener() {
                              @Override
                              public void onClick(View v) {


                                  RetrofitService service  = RetrofitClient.getInstance().getRetrofit().create(RetrofitService.class);

                                  service.upVoteComment(comment.id,true).enqueue(new Callback<CommentResponse>() {
                                      @Override
                                      public void onResponse(Call<CommentResponse> call, Response<CommentResponse> response) {




                                      }

                                      @Override
                                      public void onFailure(Call<CommentResponse> call, Throwable t) {

                                      }
                                  });


                                  comment.positive_votes=comment.positive_votes+1;
                                  holder.binding.textViewLikes.setText("" + comment.positive_votes);
                                   notifyDataSetChanged();



                              }
                          });




        holder.binding.imageViewDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RetrofitService service  = RetrofitClient.getInstance().getRetrofit().create(RetrofitService.class);


                service.downVoteComment(comment.id,true).enqueue(new Callback<CommentResponse>() {
                    @Override
                    public void onResponse(Call<CommentResponse> call, Response<CommentResponse> response) {

                    }

                    @Override
                    public void onFailure(Call<CommentResponse> call, Throwable t) {

                    }
                });

                comment.negative_votes=comment.negative_votes+1;
                holder.binding.textViewDislikes.setText("" + comment.negative_votes);
                notifyDataSetChanged();



            }
        });







    }

    @Override
    public int getItemCount() {

       if (list==null){

           return 0;
       }
     else  {

           return list.size();

       }



    }

    public  class MenuHolderInner extends RecyclerView.ViewHolder{

    private RvNewsDetailCommentsItemBinding binding;


    public MenuHolderInner(RvNewsDetailCommentsItemBinding binding) {
        super(binding.getRoot());
      this.binding=binding;
    }
}

public void setList(ArrayList<Comment>list ){
        this.list=list;
        notifyDataSetChanged();
    }

private void onUpVote(Comment comment){

        comment.positive_votes = comment.positive_votes+0;

    notifyDataSetChanged();
    }


}
