package com.epam.lab.xml;
public class Seasons {
    private int year;
    private String name;
    private String country;
    public Seasons() { }
    public Seasons(int id, String name, String country) {
        super();
        this.year = id;
        this.name = name;
        this.country = country;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getName() {
        return name;
    }
    public void setName(String answername) {
        this.name = answername;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String postedby) {
        this.country = postedby;
    }

}