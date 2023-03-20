package com.example.superheltev5.dto;

import java.util.List;

public class HeroPowersDTO {
    String hname, rname;
    List<String> powers;

    public HeroPowersDTO(String hname, String rname, List<String> powers) {
        this.hname = hname;
        this.rname = rname;
        this.powers = powers;
    }

    public String getHname() {
        return hname;
    }

    public String getRname() {
        return rname == null ? "Unknown" : rname;
    }

    public List<String> getPowers() {
        return powers;
    }

    public void addPower(String power) {
        powers.add(power);
    }
}
