/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javapoi;

import java.util.ArrayList;

/**
 *
 * @author Young
 */
public class Places {
    
    private ArrayList<POI> poi = new ArrayList<POI>();
    private String name;
    
    
    
    public Places(String nameIn){
        name = nameIn;
    }
    
    public void addPOI(POI p){
        poi.add(p);
    }
    
    public ArrayList<POI> SearchByLocation(String location){
        String searchinglocation = location.toLowerCase();
        ArrayList<POI> result = new ArrayList<>();
        for(int count = 0; count < poi.size(); count++){
            POI currentPOI = poi.get(count);
            String currentlocation = currentPOI.getLocation().toLowerCase();
            if(currentlocation.equals(searchinglocation)){
                result.add(currentPOI);
            }
        }
        return result;
    }
    
    public ArrayList<POI> SearchByType(String type){
        String searchingtype = type.toLowerCase();
        ArrayList<POI> result = new ArrayList<>();
        for(int count = 0; count < poi.size(); count++){
            POI currentPOI = poi.get(count);
            String currenttype = currentPOI.getType().toLowerCase();
            if(currenttype.equals(searchingtype)){
                result.add(currentPOI);
            }
        }
        return result;
        
    }
    public POI SearchByName(String name){
        String searchingname = name.toLowerCase();
        for(int count = 0; count < poi.size(); count++){
            POI currentPOI = poi.get(count);
            String currentname = currentPOI.getName().toLowerCase();
            if(currentname.equals(searchingname)){
                return currentPOI;
            }
        }
        return null;
    }
    
    public ArrayList<POI> displayPOI(){
        ArrayList<POI> display = new ArrayList<>();
        for(int count =  0; count<poi.size(); count++){
            POI currentPOI = poi.get(count);
            System.out.println(currentPOI);
            }
        return display;
    }
    
    public void likePOI(String name){
        POI searchedPOI = SearchByName(name);
        searchedPOI.addLikes();
    }
    
    public void addComment(String name, String Comment){
        POI searchedPOI = SearchByName(name);
        if(searchedPOI != null){
            searchedPOI.addComment(Comment);
        }
    }
    
    public ArrayList listofComments(){
        ArrayList comments  = new ArrayList();
        for(int count = 0; count< poi.size(); count++){
            POI currentPOI = poi.get(count);
            ArrayList<String> commentlist = currentPOI.getComments();
            comments.add(commentlist);
        }
        return comments;
    }
    
    public ArrayList<String> getCommentByName(String name){
        POI searchedPOI = SearchByName(name);
        if(searchedPOI != null){
            ArrayList comments = searchedPOI.getComments();
            return comments;
        }
        else{
            return new ArrayList<>();
        }
    }
    
    public void replaceComment(String name, int optionIndex, String newcomment){
        POI searchedPOI = SearchByName(name);
        searchedPOI.newComment(optionIndex, newcomment);
    }
    
   }

