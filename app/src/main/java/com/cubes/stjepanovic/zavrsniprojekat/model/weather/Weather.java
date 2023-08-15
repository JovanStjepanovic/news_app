package com.cubes.stjepanovic.zavrsniprojekat.model.weather;

import java.io.Serializable;

public class Weather implements Serializable {

public String name;
public String temp;
public String temp_max;
public String temp_min;
public String pressure;
public String humidity;
public String icon_url;
public String wind;

public String description;
public WeatherDay day_0;
public WeatherDay day_1;
public WeatherDay day_2;
public WeatherDay day_3;
public WeatherDay day_4;
public WeatherDay day_5;
public WeatherDay day_6;
}
