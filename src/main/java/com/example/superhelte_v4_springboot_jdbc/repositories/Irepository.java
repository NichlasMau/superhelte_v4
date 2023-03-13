package com.example.superhelte_v4_springboot_jdbc.repositories;

import com.example.superhelte_v4_springboot_jdbc.dto.City_superhero;
import com.example.superhelte_v4_springboot_jdbc.dto.SuperheroPowerByName;
import com.example.superhelte_v4_springboot_jdbc.model.Superhero;
import com.example.superhelte_v4_springboot_jdbc.model.SuperheroPowerCount;
import com.example.superhelte_v4_springboot_jdbc.services.SuperheroService;

import java.util.List;

public interface Irepository {

    default Superhero getSuperHero(String name){
        return null;
    }

    default List<Superhero> getSuperheroes() {
        return null;
    }

    default List<SuperheroPowerCount> getSuperheroPowerCount(){
        return null;
    }

    default List<SuperheroPowerByName> getSuperpowerByName(){
        return null;
    }

    default List<City_superhero> getCitySuperhero(){
        return null;
    }


}
