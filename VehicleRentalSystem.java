import java.util.*;

public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        
        Car car = new Car("C123", 50);
        Bike bike = new Bike("B456", 20);
        Truck truck = new Truck("T789", 100);
        
        vehicles.add(car);
        vehicles.add(bike);
        vehicles.add(truck);
        
        int rentalDays = 5;
        
        for (Vehicle vehicle : vehicles) {
            vehicle.displayDetails();
            double rentalCost = vehicle.calculateRentalCost(rentalDays);
            System.out.println("Rental Cost for " + rentalDays + " days: " + rentalCost);
            
            if (vehicle instanceof Insurable) {
                System.out.println(((Insurable) vehicle).getInsuranceDetails());
                System.out.println("Insurance Cost: " + ((Insurable) vehicle).calculateInsurance());
            }
            System.out.println();
        }
    }
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }
    
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    
    public String getType() {
        return type;
    }
    
    public double getRentalRate() {
        return rentalRate;
    }
    
    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }
    
    public abstract double calculateRentalCost(int days);
    
    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate: " + rentalRate);
    }
}

class Car extends Vehicle implements Insurable {
    public Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }
    
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
    
    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.05; // 5% of rental rate
    }
    
    @Override
    public String getInsuranceDetails() {
        return "Car Insurance: 5% of rental rate";
    }
}

class Bike extends Vehicle {
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }
    
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.9; 
    }
}

class Truck extends Vehicle implements Insurable {
    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }
    
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 1.2; 
    }
    
    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.1; 
    }
    
    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance: 10% of rental rate";
    }
}

