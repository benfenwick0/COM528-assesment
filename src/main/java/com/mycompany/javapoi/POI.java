package com.mycompany.javapoi;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Young
 */
public class POI {
    private String name, type, location;
    private ArrayList<String> comments;
    private int likes;
    
    public POI(String nameIn, String typeIn, String locationIn)
    {
        this.name = nameIn;
        this.type = typeIn;
        this.location = locationIn;
        this.comments = new ArrayList<>();
        this.likes = 0;
        
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getType(){
        return this.type;
    }
        
    public String getLocation(){
        return this.location;
    }
    
    public int getLikes(){
        return this.likes;
    }
    
    public void addLikes(){
        this.likes +=1;
    }
    
    public void addComment(String comment){
        comments.add(comment);
    }
           
    public ArrayList<String> getComments(){
        return comments;
    }
    public String toString(){
        return " || Name: " + this.name + " | Type: " + this.type + " | Location: " + this.location + " | Comments: " + this.comments + " | Likes: " + this.likes + "|| ";
    }

    public void newComment(int optionIndex, String newcomment){
        if(optionIndex >=0 && optionIndex < comments.size()){
            comments.set(optionIndex, newcomment);
        }
    }        
    
}
