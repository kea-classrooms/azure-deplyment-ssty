package com.example.superheltev5.controllers;


import com.example.superheltev5.dto.*;
import com.example.superheltev5.model.Superhero;
import com.example.superheltev5.repositories.IRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("superheroes")
public class SuperheroController {

    private IRepository superHeroRepository;

    public SuperheroController(ApplicationContext context, @Value("${superhero.repository.impl}") String impl) {
        this.superHeroRepository = (IRepository) context.getBean(impl);
    }

    @GetMapping("/")
    public String getSuperheroes(Model model){
        List<HeroYearDTO> superheroList = superHeroRepository.getSuperheroesWithYear();
        model.addAttribute("superheroList", superheroList);
        return "index";
    }

    @GetMapping("/superpowers/count")
    public ResponseEntity<?> getSuperheroesWithPowerCount(@RequestParam(required = false) String format){
        List<HeroPowerCountDTO> superheroList = superHeroRepository.getSuperheroesWithNumberOfPowers();
        //hname, rname, powercount
        if (format != null && format.equals("html")){
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("<h1> %s </h1>", "SUPERHELTE:"));
            for (HeroPowerCountDTO superhero : superheroList) {
                sb.append(String.format("<h2> %s:</h2>", superhero.gethName()));
                sb.append("<ul>");
                sb.append(String.format("<li> Ægte navn: %s </li>", superhero.getrName()));
                sb.append(String.format("<li> Antal kræfter: %d </li>", superhero.getNumberOfPowers()));
                sb.append("</ul>");
            }
            HttpHeaders header = new HttpHeaders();
            header.set("Superhero header", "content-type:text/html");
            return new ResponseEntity<>(sb.toString(), header, HttpStatus.OK);
        }
        return new ResponseEntity<>(superheroList, HttpStatus.OK);
    }

    @GetMapping("/superpowers")
    public ResponseEntity<?> getSuperheroesWithPowers(@RequestParam(required = false) String format){
        List<HeroPowersDTO> superheroList = superHeroRepository.getSuperheroesWithPowers();
        //hname, rname, powers
        if (format != null && format.equals("html")){
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("<h1> %s </h1>", "SUPERHELTE:"));
            for (HeroPowersDTO superhero : superheroList) {
                sb.append(String.format("<h2> %s:</h2>", superhero.getHname()));
                sb.append("<ul>");
                sb.append(String.format("<li> Ægte navn: %s </li>", superhero.getRname()));
                sb.append(String.format("<li> Kræfter: %s </li>", superhero.getPowers()));
                sb.append("</ul>");
            }
            HttpHeaders header = new HttpHeaders();
            header.set("Superhero header", "content-type:text/html");
            return new ResponseEntity<>(sb.toString(), header, HttpStatus.OK);
        }
        return new ResponseEntity<>(superheroList, HttpStatus.OK);
    }

    @GetMapping("/city")
    public ResponseEntity<?> getSuperheroesWithCity(@RequestParam(required = false) String format){
        List<HeroCityDTO> superheroList = superHeroRepository.getSuperheroesWithCity();
        //hname, city
        if (format != null && format.equals("html")){
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("<h1> %s </h1>", "SUPERHELTE:"));
            for (HeroCityDTO superhero : superheroList) {
                sb.append(String.format("<h2> %s:</h2>", superhero.getHname()));
                sb.append("<ul>");
                sb.append(String.format("<li> By: %s </li>", superhero.getCity()));
                sb.append("</ul>");
            }
            HttpHeaders header = new HttpHeaders();
            header.set("Superhero header", "content-type:text/html");
            return new ResponseEntity<>(sb.toString(), header, HttpStatus.OK);
        }
        return new ResponseEntity<>(superheroList, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getSuperhero(@RequestParam(required = false) String format, @PathVariable String name){
        //hname, rname, creationyear
        HeroYearDTO superhero = superHeroRepository.searchSuperheroWithYear(name);
        if (format != null && format.equals("html")) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("<h2> %s:</h2>", superhero.gethName()));
            sb.append("<ul>");
            sb.append(String.format("<li> Ægte navn: %s </li>", superhero.getrName()));
            sb.append(String.format("<li> Lavet i år: %d </li>", superhero.getCreationYear()));
            sb.append("</ul>");
            HttpHeaders header = new HttpHeaders();
            header.set("Superhero header", "content-type:text/html");
            return new ResponseEntity<>(sb.toString(), header, HttpStatus.OK);
        }
        return new ResponseEntity<>(superhero, HttpStatus.OK);
    }

    @GetMapping("/superpowers/count/{name}")
    public ResponseEntity<?> getSuperheroWithPowerCount(@RequestParam(required = false) String format, @PathVariable String name){
        //hname, rname, powercount
        HeroPowerCountDTO superhero = superHeroRepository.searchSuperheroWithNumberOfPowers(name);
        if (format != null && format.equals("html")) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("<h2> %s:</h2>", superhero.gethName()));
            sb.append("<ul>");
            sb.append(String.format("<li> Ægte navn: %s </li>", superhero.getrName()));
            sb.append(String.format("<li> Antal kræfter: %d </li>", superhero.getNumberOfPowers()));
            sb.append("</ul>");
            HttpHeaders header = new HttpHeaders();
            header.set("Superhero header", "content-type:text/html");
            return new ResponseEntity<>(sb.toString(), header, HttpStatus.OK);
        }
        return new ResponseEntity<>(superhero, HttpStatus.OK);
    }

    @GetMapping("/superpowers/{name}")
    public String getSuperheroWithPowers(Model model, @PathVariable String name){
        //hname, rname, powers
        HeroPowersDTO superhero = superHeroRepository.searchSuperheroWithPowers(name);
        model.addAttribute("hero", superhero);
        return "heroSuperpowers";
    }

    @GetMapping("/add")
    public String showForm(Model model){
        Superhero hero = new Superhero();
        model.addAttribute("hero", hero);
        List<String> cities = superHeroRepository.getCities();
        List<String> powers = superHeroRepository.getPowers();
        model.addAttribute("cities", cities);
        model.addAttribute("powers", powers);
        return "addHeroForm";
    }

    @PostMapping("/add")
    public String submitForm(@ModelAttribute("hero") Superhero hero){
        System.out.println(hero);
        superHeroRepository.postHero(hero);
        return "addHeroForm_success";
    }

    @GetMapping("/edit/{name}")
    public String editHero(Model model, @PathVariable String name){
        Superhero hero = superHeroRepository.getHero(name);
        model.addAttribute("hero", hero);
        List<String> cities = superHeroRepository.getCities();
        List<String> powers = superHeroRepository.getPowers();
        model.addAttribute("cities", cities);
        model.addAttribute("powers", powers);
        return "addHeroForm";
    }

    @GetMapping("/city/{name}")
    public ResponseEntity<?> getSuperheroWithCity(@RequestParam(required = false) String format, @PathVariable String name){
        //hname, city
        HeroCityDTO superhero = superHeroRepository.searchSuperheroWithCity(name);
        if (format != null && format.equals("html")) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("<h2> %s:</h2>", superhero.getHname()));
            sb.append("<ul>");
            sb.append(String.format("<li> By: %s </li>", superhero.getCity()));
            sb.append("</ul>");
            HttpHeaders header = new HttpHeaders();
            header.set("Superhero header", "content-type:text/html");
            return new ResponseEntity<>(sb.toString(), header, HttpStatus.OK);
        }
        return new ResponseEntity<>(superHeroRepository.searchSuperheroWithCity(name), HttpStatus.OK);
    }
}