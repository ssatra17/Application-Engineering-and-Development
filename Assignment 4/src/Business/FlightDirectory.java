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
public class FlightDirectory {

    //private ArrayList<Flight> airlinedirectory;
    private ArrayList<Flight> FlightDir;
    
    //private ArrayList<Flight> flightdirectory;

   

    public ArrayList<Flight> getFlightDir() {
        return FlightDir;
    }

    public void setFlightDir(ArrayList<Flight> FlightDir) {
        this.FlightDir = FlightDir;
    }

    public FlightDirectory()
    {
       
        FlightDir = new ArrayList<Flight>();
        
    

   

    Flight flight1 = new Flight("Emirates","EM101", "Mumbai", "Boston", 50,50,50, 1000, "October 9, 2019","11:15am","October 10, 2019", "12:30pm");
    Flight flight2 = new Flight("Emirates","EM102", "Boston", "Mumbai", 50,50,50, 1000, "November 11, 2019","11:15am","November 12, 2019", "12:30pm");
    Flight flight3 = new Flight("Emirates","EM103", "Mumbai", "New York", 0,50,50, 1000, "December 14, 2019","11:15am","December 15, 2019", "12:30pm");
    Flight flight4 = new Flight("Emirates","EM104", "New York", "Mumbai", 50,0,50, 1000, "October 9, 2019","11:15am","October 9, 2019", "12:30pm");
    Flight flight5 = new Flight("Etihad","ET105", "Dubai", "Mumbai", 50,50,0, 1000, "January 9, 2019","11:15am","January 10, 2019", "12:30pm");
    Flight flight6 = new Flight("Etihad","ET106", "Dubai", "Delhi", 0,0,0, 1000, "March 11, 2019","11:15am","March 12, 2019", "12:30pm");
    Flight flight7 = new Flight("Etihad","ET107", "Mumbai", "Dubai", 50,50,50, 1000, "October 9, 2019","11:15am","October 9, 2019", "12:30pm");
    Flight flight8 = new Flight("Etihad","ET108", "Delhi", "Dubai", 50,50,50, 1000, "October 9, 2019","11:15am","October 9, 2019", "12:30pm");
    Flight flight9 = new Flight("Air India","AI109", "Mumbai", "Delhi", 50,50,50, 1000, "October 9, 2019","11:15am","October 9, 2019", "12:30pm");
    Flight flight10 = new Flight("Air India","AI110", "Delhi", "Mumbai", 50,50,50, 1000, "October 9, 2019","11:15am","October 9, 2019", "12:30pm");
    Flight flight11 = new Flight("Air India","AI111", "Mumbai", "Goa",  50,50,50, 1000, "October 9, 2019","11:15am","October 9, 2019", "12:30pm");
    Flight flight12 = new Flight("Air India","AI112", "Goa", "Mumbai",  50,50,50, 1000, "October 9, 2019","11:15am","October 9, 2019", "12:30pm");
    Flight flight13 = new Flight("GoAir","GA113", "Goa", "Mumbai", 50,50,50, 1000, "October 9, 2019","11:15am","October 9, 2019", "12:30pm");
    Flight flight14 = new Flight("GoAir","GA114", "Goa", "Mumbai", 50,50,50, 1000, "October 9, 2019","11:15am","October 9, 2019", "12:30pm");


    FlightDir.add(flight1);
    FlightDir.add(flight2);
    FlightDir.add(flight3);
    FlightDir.add(flight4);
    FlightDir.add(flight5);
    FlightDir.add(flight6);
    FlightDir.add(flight7);
    FlightDir.add(flight8);
    FlightDir.add(flight9);
    FlightDir.add(flight10);
    FlightDir.add(flight11);
    FlightDir.add(flight12);
    FlightDir.add(flight13);
    FlightDir.add(flight14);
  
 


    }

  

    public Flight addData()
    {   
       
        Flight air = new Flight();
        FlightDir.add(air);
        return air;
    
    }
    
    public void deleteFlight(Flight flight)
    {
        FlightDir.remove(flight);
    }
        
}
