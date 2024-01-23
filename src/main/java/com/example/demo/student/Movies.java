package com.example.demo.student;

public abstract class Movies {
    protected String filmName;


    protected Movies(String filmTitle){
        this.filmName=  filmTitle;
    }


    public void changeFilm(String newFilm){
        this.filmName = newFilm;
    }

    public String showFilm(){
        return filmName;
    }

    public String toString(){
        return "Your film is -> "+filmName;
    }


}
