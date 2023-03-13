package com.example.superhelte_v4_springboot_jdbc.dto;

import java.util.List;

public class City_superhero {

    private String cityName;
    private List <String> heroName;

    public City_superhero(String cityName, List <String> heroName) {
        this.cityName = cityName;
        this.heroName = heroName;
    }

    public void setCityID(String cityID) {
        this.cityName = cityID;
    }

    public List<String> getHeroName() {
        return heroName;
    }

    public String getCityID() {
        return cityName;
    }


    @Override
    public String toString() {
        return "City_superhero{" +
                "cityName='" + cityName + '\'' +
                ", heroName='" + heroName + '\'' +
                '}';
    }
}
