package com.cubes.stjepanovic.zavrsniprojekat.model;

import java.io.Serializable;

public class Currencies implements Serializable {

public String name;
public String symbol;
public String rate;

    public Currencies(String name, String symbol, String rate) {
        this.name = name;
        this.symbol = symbol;
        this.rate = rate;
    }
}
