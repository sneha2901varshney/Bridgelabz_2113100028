import java.util.*;

public class ECommercePlatform {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        
        Electronics laptop = new Electronics(900, "Laptop", 10000);
        Clothing dress = new Clothing(901, "A-Line dress", 5000);
        Groceries fruit = new Groceries(902, "Pineapple", 50);
        
        products.add(laptop);
        products.add(dress);
        products.add(fruit);
        
        for (Product product : products) {
            product.displayDetails();
            double tax = (product instanceof Taxable) ? ((Taxable) product).calculateTax() : 0;
            double finalPrice = product.getPrice() + tax - product.calculateDiscount();
            System.out.println("Final Price: " + finalPrice);
            if (product instanceof Taxable) {
                System.out.println(((Taxable) product).getTaxDetails());
            }
            System.out.println();
        }
    }
}


interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

abstract class Product {
    private int productId;
    private String name;
    private double price;
    
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    
    public int getProductId() {
        return productId;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public abstract double calculateDiscount();
    
    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Discount: " + calculateDiscount());
    }
}

class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }
    
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; 
    }
    
    @Override
    public double calculateTax() {
        return getPrice() * 0.18; 
    }
    
    @Override
    public String getTaxDetails() {
        return "Tax Rate: 18%";
    }
}

// Clothing class
class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }
    
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15; 
    }
    
    @Override
    public double calculateTax() {
        return getPrice() * 0.05; 
    }
    
    @Override
    public String getTaxDetails() {
        return "Tax Rate: 5%";
    }
}

class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }
    
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
}


