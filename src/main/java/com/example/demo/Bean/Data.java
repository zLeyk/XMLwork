package com.example.demo.Bean;

public class Data {
    String city;
    String County;
    String Prov;

    public Data(String city, String county, String prov) {
        this.city = city;
        County = county;
        Prov = prov;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return County;
    }

    public void setCounty(String county) {
        County = county;
    }

    public String getProv() {
        return Prov;
    }

    public void setProv(String prov) {
        Prov = prov;
    }
}
