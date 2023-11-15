/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.javapoi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Young
 */
public class JavaPOI {

    public static void main(String[] args) {
        String location = "";
        String type = "";
        String name = "";
        String comment = "";
        
        Places poi = new Places("Points of Interest");
        
        poi.addPOI(new POI ("Cuckoo", "Pub", "Stub"));
        poi.addPOI(new POI ("Hollywood Bowl", "Entertainment", "Southampton"));
        poi.addPOI(new POI ("Pure Gym", "Fitness", "Fareham"));
        poi.addPOI(new POI ("Solent University", "Education", "Southampton"));
        poi.addPOI(new POI ("Wickham Golf Club", "Entertainment", "Wickham"));
                
        Scanner option = new Scanner(System.in);
        Scanner nextoption = new Scanner(System.in);
        Scanner commentoption = new Scanner(System.in);
        
        
        int menuloop = 1;
        while(menuloop == 1){
            System.out.println("\n-----------------------------------------------\n");
            System.out.println("Please select one of the following options");
            System.out.println("\n-----------------------------------------------\n");
            System.out.println("1. Search by location");
            System.out.println("2. Search by type");
            System.out.println("3. Like a POI");
            System.out.println("4. Add a comment given on specific POI");
            System.out.println("5. Modify a comment given on specific POI");
            System.out.println("6. View previous comments on a specific POI");
            System.out.println("7. Exit");
            System.out.println("Option: ");
        
        int userinput = option.nextInt();
        if(userinput == 1){
            System.out.println("Location:");
            location = nextoption.nextLine();
            ArrayList<POI> locationresult = poi.SearchByLocation(location);
            System.out.println(locationresult);
            }
        else if(userinput == 2){
            System.out.println("Type:");
            type = nextoption.nextLine();
            ArrayList<POI> typeresult = poi.SearchByType(type);
            System.out.println(typeresult);    
        }
        else if(userinput == 3){
            
            ArrayList<POI> listofpoi = poi.displayPOI();
            for(POI currentPOI : listofpoi){
                System.out.println(currentPOI);
            }
            System.out.println("Please choose a POI by name from above you want to like:");
            name = nextoption.nextLine();
            poi.likePOI(name);
            
            System.out.println("Here is an updated list of POI's with the like");
            ArrayList<POI> updatedlist = poi.displayPOI();
            for(POI currentPOI : updatedlist){
                System.out.println(currentPOI);
            }
        }
        else if(userinput == 4){
            ArrayList<POI> listofpoi = poi.displayPOI();
            for(POI currentPOI : listofpoi){
                System.out.println(currentPOI);
            }
            System.out.println("Please choose a POI by name from above you would like to add a comment to:");
            name = nextoption.nextLine();
            System.out.println("Comments for '"+name+"':");
            comment = nextoption.nextLine();
            poi.addComment(name, comment);
        }
        else if(userinput == 5){
            ArrayList<POI> listofpoi = poi.displayPOI();
            for(POI currentPOI : listofpoi){
                System.out.println(currentPOI);
            }
            System.out.println("Please choose a POI by name from above you want to like to comment on:");
            name = nextoption.nextLine();
            
            
            ArrayList comments = poi.getCommentByName(name);
            if(comments.isEmpty()){    
            System.out.println("No comments avaliable for this POI");
            }
            else
            {
            System.out.println("POI Comments for '" + name +"':" + comments);
            
            
            System.out.println("Enter the position of the comment you would like to modify");
            
            int optionIndex = commentoption.nextInt();
            optionIndex = optionIndex -= 1;
          
            System.out.println("New comment:");
            comment = nextoption.nextLine();
            
            poi.replaceComment(name, optionIndex, comment);
            
            System.out.println("Comment has been changed, here is a list of new comments!");
            
            ArrayList updatedcomments = poi.getCommentByName(name);
            if(updatedcomments.isEmpty()){    
            System.out.println("No comments avaliable for this POI");
            }
            else
            {
            System.out.println("POI Comments:" + updatedcomments);
            }
            }
        }
        
        else if (userinput == 6){
            ArrayList<POI> listofpoi = poi.displayPOI();
            for(POI currentPOI : listofpoi){
                System.out.println(currentPOI);
            }
            System.out.println("Please enter the POI you would like to see previous comments for:");
            name = nextoption.nextLine();
            ArrayList comments = poi.getCommentByName(name);
            if(comments.isEmpty()){    
            System.out.println("No comments avaliable for this POI");
            }
            else
            {
            System.out.println("POI Comments for '" + name +"':" + comments);
            }
        }
        else if(userinput == 7){
            menuloop = 0;
        }
        else{
            System.out.println("\nInvalid option, please enter correctly");
        }
        
       }
    }
        
}
