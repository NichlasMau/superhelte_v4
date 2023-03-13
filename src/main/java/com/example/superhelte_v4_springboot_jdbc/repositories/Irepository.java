package com.example.superhelte_v4_springboot_jdbc.repositories;

import com.example.superhelte_v4_springboot_jdbc.dto.City_superhero;
import com.example.superhelte_v4_springboot_jdbc.dto.SuperheroPowerByName;
import com.example.superhelte_v4_springboot_jdbc.model.Superhero;
import com.example.superhelte_v4_springboot_jdbc.model.SuperheroPowerCount;

import java.util.List;

public interface Irepository {

    default Superhero getSuperhero(String name){
        return null;
    }

    default List<Superhero> getAllSuperheros() {
        return null;
    }

    default List<SuperheroPowerCount> getSuperheroPower(String name){
        return null;
    }

    default List<SuperheroPowerByName> getSuperPowerByName(String name){
        return null;
    }

    default List<City_superhero> getCitySuperhero(String name){
        return null;
    }


}
