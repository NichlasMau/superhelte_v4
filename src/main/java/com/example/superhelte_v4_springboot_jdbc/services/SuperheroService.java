package com.example.superhelte_v4_springboot_jdbc.services;

import com.example.superhelte_v4_springboot_jdbc.dto.City_superhero;
import com.example.superhelte_v4_springboot_jdbc.model.Superhero;
import com.example.superhelte_v4_springboot_jdbc.dto.SuperheroPowerByName;
import com.example.superhelte_v4_springboot_jdbc.model.SuperheroPowerCount;
import com.example.superhelte_v4_springboot_jdbc.repositories.SuperheroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SuperheroService {

        private SuperheroRepository superheroRepository;


        public SuperheroService(){
            this.superheroRepository = new SuperheroRepository();

        }
        public List<Superhero> getSuperheroAll(){
            return superheroRepository.getAllSuperheros();
        }

        public Superhero getSuperhero(String name) {
            return superheroRepository.getSuperhero(name);
        }

        public List<SuperheroPowerCount> getSuperheroPower(String name) {
            return superheroRepository.getSuperheroPower(name);
        }

        public List<SuperheroPowerByName> getSuperpowerByName(String name) {
            return superheroRepository.getSuperPowerByName(name);
        }

        public List<City_superhero> getCityAndHero(String name) {
            return superheroRepository.getCitySuperhero(name);
        }


    }


