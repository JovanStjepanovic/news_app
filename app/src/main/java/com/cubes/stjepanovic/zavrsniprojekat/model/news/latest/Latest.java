package com.cubes.stjepanovic.zavrsniprojekat.model.news.latest;

import com.cubes.stjepanovic.zavrsniprojekat.model.news.home.PageInfo;
import com.cubes.stjepanovic.zavrsniprojekat.model.news.home.News;

import java.io.Serializable;
import java.util.ArrayList;

public class Latest implements Serializable {

    public PageInfo pagination;
public ArrayList<News>news;

}
