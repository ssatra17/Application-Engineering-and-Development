/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author saura
 */
public class CarInformation {
    private ArrayList<Car> carDirectory;
    
    public CarInformation()
    {
        carDirectory = new ArrayList<>();
    
    
    
    //private CarInformation(){
        
       // carDirectory = new ArrayList<>();
        
        Car car1 = new Car(false, "Mercedez", 2019, 1, 2, 1,"Red One", "Boston", true, "Daimler");
        Car car2 = new Car(true, "Lexus", 2019, 1, 4, 2, "X1", "New York", true, "Toyota");
        Car car3 = new Car(true, "Cadillac", 2018, 1, 4, 3, "T1", "Boston", true, "GM");
        Car car4 = new Car(true, "Jaguar", 2018, 1, 4, 4, "G1", "New York", true, "Tata");
        Car car5 = new Car(true, "Cadillac", 2017, 1, 4, 5, "T2", "Chicago", true, "GM");
        Car car6 = new Car(true, "Jaguar", 2017, 1, 4, 6, "G2", "Chicago", true, "Tata");
        Car car7 = new Car(true, "Mercedez", 2016, 1, 4, 7, "", "Seattle", true, "Daimler");
        Car car8 = new Car(true, "Lexus", 2016, 1, 4, 8, "X2", "Seattle", true, "Toyota");
        Car car9 = new Car(true, "Cadillac", 2019, 1, 4, 9, "T3", "Austin", true, "GM");
        Car car10 = new Car(true, "Jaguar", 2019, 1, 4, 10, "G3", "Austin", true, "Tata");
        
        carDirectory.add(car1);
        carDirectory.add(car2);
        carDirectory.add(car3);
        carDirectory.add(car4);
        carDirectory.add(car5);
        carDirectory.add(car6);
        carDirectory.add(car7);
        carDirectory.add(car8);
        carDirectory.add(car9);
        carDirectory.add(car10);
        
    }

    public ArrayList<Car> getCarDirectory() {
        return carDirectory;
    }

    public void setCarDirectory(ArrayList<Car> carDirectory) {
        this.carDirectory = carDirectory;
    }
    
    public Car addCar(){
        Car newCar = new Car();
        carDirectory.add(newCar);
        return newCar;
    }
    
    public void deleteCar(Car car){
        carDirectory.remove(car);
    }

}
