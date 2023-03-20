package com.example.superheltev5.dto;

public class HeroCityDTO {
    String hname, city;

    public HeroCityDTO(String hname, String city) {
        this.hname = hname;
        this.city = city;
    }

    public String getHname() {
        return hname;
    }

    public String getCity() {
        return city;
    }
}
