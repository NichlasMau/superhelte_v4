package com.example.superhelte_v4_springboot_jdbc.controllers;
import com.example.superhelte_v4_springboot_jdbc.dto.City_superhero;
import com.example.superhelte_v4_springboot_jdbc.model.Superhero;
import com.example.superhelte_v4_springboot_jdbc.dto.SuperheroPowerByName;
import com.example.superhelte_v4_springboot_jdbc.model.SuperheroPowerCount;
import com.example.superhelte_v4_springboot_jdbc.services.SuperheroService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("superhero")
public class SuperheroController {

    private SuperheroService superheroService;

    public SuperheroController(SuperheroService superheroService){
        this.superheroService = superheroService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Superhero>> allSuperheroes(){
        List<Superhero> superheroes = superheroService.getSuperheroAll();
        return new ResponseEntity<>(superheroes,HttpStatus.OK);
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<Superhero> getSuperhero(@PathVariable String name) {
        Superhero superhero = superheroService.getSuperhero(name);
       return new ResponseEntity<>(superhero, HttpStatus.OK);
    }

    @GetMapping(path = "/count/{name}")
    public ResponseEntity<List<SuperheroPowerCount>> getSuperheroPower(@PathVariable String name) {
        List<SuperheroPowerCount> powerCount = superheroService.getSuperheroPower(name);
        return new ResponseEntity<>(powerCount, HttpStatus.OK);
    }

    @GetMapping(path = "/superpower/{name}")
    public ResponseEntity<List<SuperheroPowerByName>> getSuperpowerByname(@PathVariable String name) {
        List<SuperheroPowerByName> powerByName = superheroService.getSuperpowerByName(name);
        return new ResponseEntity<>(powerByName, HttpStatus.OK);
    }

    @GetMapping(path = "/city/{name}")
    public ResponseEntity<List<City_superhero>> getCityAndHero(@PathVariable String name) {
        List<City_superhero> cityHero = superheroService.getCityAndHero(name);
        return new ResponseEntity<>(cityHero, HttpStatus.OK);
    }




}
