package com.cubes.stjepanovic.zavrsniprojekat.model.comments;

import java.io.Serializable;
import java.util.ArrayList;

public class Comment implements Serializable {

   public int negative_votes;
    public int   positive_votes;
    public String created_at;
    public  int   news;
    public String   name;
    public int  parent_comment;
    public int   id;
    public String  content;
    public ArrayList <Comment>  children;


}
