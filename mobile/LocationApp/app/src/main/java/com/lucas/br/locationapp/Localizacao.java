package com.lucas.br.locationapp;

public class Localizacao {
    private String country;
    private String region;
    private String city;

    public Localizacao(String country,
                       String region, String city){
        this.country = country;
        this.region = region;
        this.city = city;
    }

    public String getCountry(){ return this.country; }
    public String getRegion(){ return this.region; }
    public String getCity(){ return this.city; }

}
