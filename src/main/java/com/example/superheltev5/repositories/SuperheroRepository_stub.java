package com.example.superheltev5.repositories;

import com.example.superheltev5.dto.HeroCityDTO;
import com.example.superheltev5.dto.HeroPowerCountDTO;
import com.example.superheltev5.dto.HeroPowersDTO;
import com.example.superheltev5.dto.HeroYearDTO;
import com.example.superheltev5.model.Superhero;

import java.util.List;

public class SuperheroRepository_stub implements IRepository{
    @Override
    public List<HeroYearDTO> getSuperheroesWithYear() {
        return null;
    }

    @Override
    public List<HeroPowerCountDTO> getSuperheroesWithNumberOfPowers() {
        return null;
    }

    @Override
    public List<HeroPowersDTO> getSuperheroesWithPowers() {
        return null;
    }

    @Override
    public List<HeroCityDTO> getSuperheroesWithCity() {
        return null;
    }

    @Override
    public HeroYearDTO searchSuperheroWithYear(String name) {
        return null;
    }

    @Override
    public HeroPowerCountDTO searchSuperheroWithNumberOfPowers(String name) {
        return null;
    }

    @Override
    public HeroPowersDTO searchSuperheroWithPowers(String name) {
        return null;
    }

    @Override
    public HeroCityDTO searchSuperheroWithCity(String name) {
        return null;
    }

    @Override
    public List<String> getCities() {
        return null;
    }

    @Override
    public List<String> getPowers() {
        return null;
    }

    @Override
    public void postHero(Superhero hero) {

    }

    @Override
    public Superhero getHero(String name) {
        return null;
    }
}
