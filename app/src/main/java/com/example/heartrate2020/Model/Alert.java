package com.example.heartrate2020.Model;

public class Alert {

    String name;
    String Hrate;
    String timealert;
    Double Latx;
    Double Laty;



    public Alert() {


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHrate() {
        return Hrate;
    }

    public void setHrate(String hrate) {
        Hrate = hrate;
    }

    public String getTimealert() {
        return timealert;
    }

    public void setTimealert(String timealert) {
        this.timealert = timealert;
    }


    public Double getLatx() {
        return Latx;
    }

    public void setLatx(Double latx) {
        Latx = latx;
    }

    public Double getLaty() {
        return Laty;
    }

    public void setLaty(Double laty) {
        Laty = laty;
    }
}
