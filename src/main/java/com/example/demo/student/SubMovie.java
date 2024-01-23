package com.example.demo.student;

public class SubMovie extends Movies{

    protected String description;
    public SubMovie(String filmTitle,String theDescription){
        super(filmTitle);
        this.description = theDescription;
    }

    public void changeDescription(String newDescription){
        this.description=  newDescription;
    }

    public String changeDescription(){
        return description;
    }


    public String toString(){
        return super.toString()+"\nDescription -> "+description;
    }

}
