package com.example.superheltev5.model;


import java.util.List;

public class Superhero {
    private String city;
    private String name;
    private String superheroName;
    private List<String> superPowers;
    private Integer creationYear;

    public Superhero(String name, String city, String superheroName, List<String> superPowers, int creationYear) {
        this.name = name;
        this.city = city;
        this.superheroName = superheroName;
        this.superPowers = superPowers;
        this.creationYear = creationYear;
    }

    public Superhero() {

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuperheroName() {
        return superheroName;
    }

    public void setSuperheroName(String superheroName) {
        this.superheroName = superheroName;
    }

    public List<String> getSuperPowers() {
        return superPowers;
    }

    public void setSuperPowers(List<String> superPowers) {
        this.superPowers = superPowers;
    }

    public void addSuperPower(String superpower){
        superPowers.add(superpower);
    }

    public Integer getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(Integer creationYear) {
        this.creationYear = creationYear;
    }

    @Override
    public String toString() {
        return "Superhero{" +
                "superheroName='" + superheroName + '\'' +
                ", name='" + name + '\'' +
                ", superPowers=" + superPowers +
                ", creationYear=" + creationYear +
                ", city='" + city + '\'' +
                '}';
    }
}
