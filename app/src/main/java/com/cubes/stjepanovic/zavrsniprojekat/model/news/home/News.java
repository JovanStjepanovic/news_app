package com.cubes.stjepanovic.zavrsniprojekat.model.news.home;

import com.cubes.stjepanovic.zavrsniprojekat.model.categories.Category;

import java.io.Serializable;

public class News implements Serializable {

public int id;
public String image;
public String title;
public Category category ;
public String created_at;
public String url;
public String source;
public String author_name;

}
