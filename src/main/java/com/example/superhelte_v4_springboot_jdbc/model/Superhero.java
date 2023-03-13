package com.example.superhelte_v4_springboot_jdbc.model;

public class Superhero {
        private int superheroId;
        private String name;
        private String alias;
        private int year;


        //------------------------------------------------------------------------------------------------
        //Konstruktører
        public Superhero(int superheroId, String name, String alias, int year) {
            this.superheroId = superheroId;
            this.name = name;
            this.alias = alias;
            this.year = year;
        }


        //------------------------------------------------------------------------------------------------
        // Getter & Setter

        public int getSuperheroId(){
            return superheroId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }


        //------------------------------------------------------------------------------------------------
        // ToString - Dette printer info om en superhelt
        public String toString() {
            return "> Real name: " + name
                    + "\n> Alias: " + alias
                    + "\n> Year of publication: " + year;
        }
    }


