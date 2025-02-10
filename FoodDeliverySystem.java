import java.util.*;
public class FoodDeliverySystem {
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();
        
        VegItem vegItem = new VegItem("Paneer Butter Masala", 250, 2);
        NonVegItem nonVegItem = new NonVegItem("Kofta", 300, 0);
        
        nonVegItem.applyDiscount(10); 
        
        order.add(vegItem);
        order.add(nonVegItem);
        
        for (FoodItem item : order) {
            item.getItemDetails();
            
            if (item instanceof Discountable) {
                System.out.println("Discount Applied: " + ((Discountable) item).getDiscountDetails());
            }
            System.out.println();
        }
    }
}

interface Discountable {
    void applyDiscount(double percentage);
    double getDiscountDetails();
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;
    
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String getItemName() {
        return itemName;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public abstract double calculateTotalPrice();
    
    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: " + calculateTotalPrice());
    }
}

class VegItem extends FoodItem {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    
    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private static final double ADDITIONAL_CHARGE = 20.0;
    private double discount = 0.0;
    
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    
    @Override
    public double calculateTotalPrice() {
        return (getPrice() + ADDITIONAL_CHARGE) * getQuantity() - discount;
    }
    
    @Override
    public void applyDiscount(double percentage) {
        discount = (getPrice() * getQuantity() + ADDITIONAL_CHARGE) * (percentage / 100);
    }
    
    @Override
    public double getDiscountDetails() {
        return discount;
    }
}


