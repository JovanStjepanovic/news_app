package com.cubes.stjepanovic.zavrsniprojekat.model.categories;

import com.cubes.stjepanovic.zavrsniprojekat.model.categories.subacategory.Subcategory;

import java.io.Serializable;
import java.util.ArrayList;

public class Category implements Serializable {


public int id;
public String name;
public String color;
public ArrayList<Subcategory> subcategories;

public Subcategory subcategory;


}
