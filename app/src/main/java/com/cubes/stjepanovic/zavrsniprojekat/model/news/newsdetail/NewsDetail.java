package com.cubes.stjepanovic.zavrsniprojekat.model.news.newsdetail;

import com.cubes.stjepanovic.zavrsniprojekat.model.categories.Category;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.home.News;

import java.util.ArrayList;

public class NewsDetail {


    public int id;
    public String image;
    public String title;
    public Category category ;
    public String created_at;
    public String url;

    public ArrayList<Tag>tags;

    public ArrayList<News>related_news;


}
