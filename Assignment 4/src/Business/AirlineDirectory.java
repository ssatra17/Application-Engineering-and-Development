/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author parth
 */
public class AirlineDirectory {
    
    private ArrayList<Airlines> airlinedirectory;
    
    public AirlineDirectory(){

        airlinedirectory= new ArrayList<Airlines>();

      Airlines Airline1 = new Airlines("Emirates", "Dubai");
        airlinedirectory.add(Airline1);
        Airlines Airline2 = new Airlines("Etihad", "Abu Dhabi");
        airlinedirectory.add(Airline2);
        Airlines Airline3 = new Airlines("Air India", "India");
        airlinedirectory.add(Airline3);
        Airlines Airline4 = new Airlines("GoAir", "India");
        airlinedirectory.add(Airline4);
        
       

       


    }

    public ArrayList<Airlines> getAirlinedirectory() {
        return airlinedirectory;
    }

    public void setAirlinedirectory(ArrayList<Airlines> airlinedirectory) {
        this.airlinedirectory = airlinedirectory;
    }

    public Airlines addAirlines(){

        Airlines add= new Airlines();
        airlinedirectory.add(add);
        return add;
    }

   
    public void removeAirlines(Airlines airlines) {
        airlinedirectory.remove(airlines);
    }

    

    
    
}
