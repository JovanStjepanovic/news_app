package com.cubes.stjepanovic.zavrsniprojekat.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cubes.stjepanovic.zavrsniprojekat.R;
import com.cubes.stjepanovic.zavrsniprojekat.databinding.ActivityReplyBinding;
import com.cubes.stjepanovic.zavrsniprojekat.model.comments.Comment;
import com.cubes.stjepanovic.zavrsniprojekat.model.comments.CommentResponse;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.home.News;
import com.cubes.stjepanovic.zavrsniprojekat.networking.RetrofitClient;
import com.cubes.stjepanovic.zavrsniprojekat.networking.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReplyActivity extends AppCompatActivity {

    private ActivityReplyBinding binding;
    private RetrofitService service;
    private int commentID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityReplyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        commentID= (int) getIntent().getSerializableExtra("comment");



        binding.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });





        binding.buttonAddComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((binding.editTextContent.getText().length()>5 && binding.editTextContent.getText().length()<120) && (binding.editTextName.getText().length()>0 && binding.editTextName.getText().length()<250)) {


                    service = RetrofitClient.getInstance().getRetrofit().create(RetrofitService.class);


                    service.postReply(binding.editTextName.getText().toString(),binding.editTextContent.getText().toString(),commentID).enqueue(new Callback<CommentResponse>() {
                        @Override
                        public void onResponse(Call<CommentResponse> call, Response<CommentResponse> response) {

                            finish();
                        }

                        @Override
                        public void onFailure(Call<CommentResponse> call, Throwable t) {

                        }
                    });


                }

                else if (binding.editTextContent.getText().length()>5 && binding.editTextName.getText().length()==0) {


                    Toast.makeText(ReplyActivity.this, R.string.more_than_one_char, Toast.LENGTH_SHORT).show();

                }

                else if (binding.editTextContent.getText().length()<5 && binding.editTextName.getText().length()>0) {


                    Toast.makeText(ReplyActivity.this, R.string.more_than_five_char, Toast.LENGTH_SHORT).show();

                }


                else if (binding.editTextContent.getText().length()==0 && binding.editTextName.getText().length()==0) {


                    Toast.makeText(ReplyActivity.this, R.string.cant_be_empty, Toast.LENGTH_SHORT).show();

                }

                else if (binding.editTextContent.getText().length()>120 && binding.editTextName.getText().length()>250) {


                    Toast.makeText(ReplyActivity.this, R.string.max_char, Toast.LENGTH_SHORT).show();

                }

                else if (binding.editTextContent.getText().length()<120 && binding.editTextName.getText().length()>250) {


                    Toast.makeText(ReplyActivity.this, R.string.max_char, Toast.LENGTH_SHORT).show();

                }

                else if (binding.editTextContent.getText().length()>120 && binding.editTextName.getText().length()<250) {


                    Toast.makeText(ReplyActivity.this, R.string.max_char, Toast.LENGTH_SHORT).show();

                }






            }
        });




    }
}