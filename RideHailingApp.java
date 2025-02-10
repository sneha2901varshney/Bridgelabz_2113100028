import java.util.*;
public class RideHailingApp {
    public static void main(String[] args) {
        List<Vehicle> rides = new ArrayList<>();
        
        Car car = new Car("V001", "ABC", 15, "PQR");
        Bike bike = new Bike("V002", "STU", 10);
        Auto auto = new Auto("V003", "DEF", 12);
        
        rides.add(car);
        rides.add(bike);
        rides.add(auto);
        
        double distance = 10; 
        
        for (Vehicle ride : rides) {
            ride.getVehicleDetails();
            System.out.println("Fare for " + distance + " km: " + ride.calculateFare(distance));
            
            if (ride instanceof GPS) {
                ((GPS) ride).getCurrentLocation();
            }
            System.out.println();
        }
    }
}

interface GPS {
    void getCurrentLocation();
    void updateLocation(String newLocation);
}

abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    
    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }
    
    public String getVehicleId() {
        return vehicleId;
    }
    
    public String getDriverName() {
        return driverName;
    }
    
    public double getRatePerKm() {
        return ratePerKm;
    }
    
    public abstract double calculateFare(double distance);
    
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: " + ratePerKm);
    }
}

class Car extends Vehicle implements GPS {
    private String currentLocation;
    
    public Car(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = currentLocation;
    }
    
    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
    
    @Override
    public void getCurrentLocation() {
        System.out.println("Car Current Location: " + currentLocation);
    }
    
    @Override
    public void updateLocation(String newLocation) {
        currentLocation = newLocation;
    }
}

class Bike extends Vehicle {
    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    
    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 0.9; // Discounted fare for bike rides
    }
}

class Auto extends Vehicle {
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    
    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 1.1;
    }
}



