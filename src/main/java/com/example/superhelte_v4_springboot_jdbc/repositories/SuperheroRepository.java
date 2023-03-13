package com.example.superhelte_v4_springboot_jdbc.repositories;

import com.example.superhelte_v4_springboot_jdbc.dto.City_superhero;
import com.example.superhelte_v4_springboot_jdbc.model.Superhero;
import com.example.superhelte_v4_springboot_jdbc.dto.SuperheroPowerByName;
import com.example.superhelte_v4_springboot_jdbc.model.SuperheroPowerCount;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SuperheroRepository implements Irepository {


    private final String db_url = "jdbc:mysql://localhost:3306/superpower_hero_city";


    private final String db_username = "root";


    private final String db_password = "root";


    public List<Superhero> getAllSuperheros() {
        List<Superhero> superheroes = new ArrayList<Superhero>();
        try (Connection con = DriverManager.getConnection(db_url, db_username, db_password)) {
            String SQL = "SELECT * FROM superhero;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                int ID = rs.getInt("superheroID");
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                int creationYear = rs.getInt("creationYear");
                superheroes.add(new Superhero(ID, heroName, realName, creationYear));
            }
            return superheroes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Superhero getSuperhero(String name) {
        Superhero superheroObj = null;
        try (Connection con = DriverManager.getConnection(db_url, db_username, db_password)) {
            String SQL1 = "SELECT * FROM superhero WHERE heroname =?;";
            PreparedStatement pstmt = con.prepareStatement(SQL1);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int ID = rs.getInt("superheroID");
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                int creationYear = rs.getInt("creationYear");
                superheroObj = new Superhero(ID, realName, heroName, creationYear);
            }
            return superheroObj;
        } catch (SQLException e1) {
            throw new RuntimeException(e1);
        }

    }

    public List<SuperheroPowerCount> getSuperheroPower(String name) {
        List<SuperheroPowerCount> superheroObj = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(db_url, db_username, db_password)) {
            String SQL2 = "SELECT heroName, realName, COUNT(*) AS numPowers FROM superhero_superpower JOIN Superhero ON Superhero.superheroID = superhero_superpower.superheroID WHERE heroName = ? GROUP BY Superhero.superheroID;";
            PreparedStatement pstmt = con.prepareStatement(SQL2);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                int numpower = rs.getInt("numPowers");
                superheroObj.add(new SuperheroPowerCount(heroName, realName, numpower));
            }
            return superheroObj;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<SuperheroPowerByName> getSuperPowerByName(String name) {
        List<SuperheroPowerByName> powerObj = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(db_url, db_username, db_password)) {
            String SQL3 = "SELECT heroName, realName, superpowerName FROM superpower " +
                    "JOIN superhero join superhero_superpower " +
                    "ON superpower.superpowerID = superhero_superpower.superpowerID " +
                    "AND  superhero.superheroID = superhero_superpower.superheroID " +
                    "WHERE superHero.heroName = ?;";
            PreparedStatement pstmt = con.prepareStatement(SQL3);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                String superpower = rs.getString("superpowerName");
                powerObj.add(new SuperheroPowerByName(heroName, realName, superpower));
            }
            return powerObj;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<City_superhero> getCitySuperhero(String name) {
        List<City_superhero> cityObj = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(db_url, db_username, db_password)) {
            String SQL4 = "SELECT heroName, cityName FROM superhero JOIN city JOIN city_superhero on " +
                    "city.cityID = city_superhero.cityID AND " +
                    "superhero.superheroID = city_superhero.superheroID " +
                    "WHERE superhero.heroName = ?;";
            PreparedStatement pstmt = con.prepareStatement(SQL4);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String cityName = rs.getString("cityName");
                String heroName = rs.getString("heroName");
                cityObj.add(new City_superhero(cityName, new ArrayList<>(List.of(heroName))));
            }
            return cityObj;
        } catch (SQLException e) {
            throw new RuntimeException(e);


        }
    }
}
