package com.example.superhelte_v4_springboot_jdbc.dto;

public class SuperheroPowerByName {

    private String realName;
    private String heroName;
    private String superpower;

    public SuperheroPowerByName(String heroName, String realName, String superpower) {
        this.realName = realName;
        this.heroName = heroName;
        this.superpower = superpower;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getSuperpower() {
        return superpower;
    }

    public void setSuperpower(String superpower) {
        this.superpower = superpower;
    }

    @Override
    public String toString() {
        return "SuperheroPowerByName{" +
                "realName='" + realName + '\'' +
                ", heroName='" + heroName + '\'' +
                ", superpower='" + superpower + '\'' +
                '}';
    }
}
