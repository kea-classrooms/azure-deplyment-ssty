package com.example.superheltev5.repositories;

import com.example.superheltev5.dto.*;
import com.example.superheltev5.model.Superhero;

import java.util.List;

public interface IRepository {
    List<HeroYearDTO> getSuperheroesWithYear();
    List<HeroPowerCountDTO> getSuperheroesWithNumberOfPowers();
    List<HeroPowersDTO> getSuperheroesWithPowers();
    List<HeroCityDTO> getSuperheroesWithCity();

    HeroYearDTO searchSuperheroWithYear(String name);
    HeroPowerCountDTO searchSuperheroWithNumberOfPowers(String name);
    HeroPowersDTO searchSuperheroWithPowers(String name);
    HeroCityDTO searchSuperheroWithCity(String name);

    List<String> getCities();

    List<String> getPowers();

    void postHero(Superhero hero);

    Superhero getHero(String name);
}
