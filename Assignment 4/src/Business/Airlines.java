/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author parth
 */
public class Airlines {
    private String airplaneName;

       
     private String Origin;
     private FlightDirectory flightDirectory;
     private Flight flight;

    
    public Airlines(String airplaneName, String Origin){
        this.airplaneName = airplaneName;
        this.Origin=Origin;
        flightDirectory = new FlightDirectory();  
      flight = new Flight();
           
}

    
    
    public Airlines() {
      flightDirectory = new FlightDirectory();  
      flight = new Flight();
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    
    public String getAirplaneName() {
        return airplaneName;
    }

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
    }


    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String Origin) {
        this.Origin = Origin;
    }

    public FlightDirectory getFlightDirectory() {
        return flightDirectory;
    }

    public void setFlightDirectory(FlightDirectory flightDirectory) {
        this.flightDirectory = flightDirectory;
    }
   
  
   

   /* public FlightDirectory getFlight() {
        return flight;
    }

    public void setFlight(FlightDirectory flight) {
        this.flight = flight;
    }*/

     public String toString()
    {
        return this.airplaneName;
    }
}
