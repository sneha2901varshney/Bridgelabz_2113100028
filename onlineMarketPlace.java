package AssignmentGeneric;
import java.util.*;

enum BookCategory { FICTION, NON_FICTION, SCIENCE, HISTORY }
enum ClothingCategory { MEN, WOMEN, KIDS }
enum GadgetCategory { MOBILE, LAPTOP, ACCESSORY }


abstract class Product<T> {
    protected String name;
    protected double price;
    protected T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public T getCategory() { return category; }

    public void applyDiscount(double percentage) {
        if (percentage > 0 && percentage <= 100) {
            this.price -= this.price * (percentage / 100);
        }
    }

    @Override
    public String toString() {
        return name + " (Category: " + category + ", Price: " + price + ")";
    }
}

class Book extends Product<BookCategory> {
    public Book(String name, double price, BookCategory category) {
        super(name, price, category);
    }
}

class Clothing extends Product<ClothingCategory> {
    public Clothing(String name, double price, ClothingCategory category) {
        super(name, price, category);
    }
}

class Gadget extends Product<GadgetCategory> {
    public Gadget(String name, double price, GadgetCategory category) {
        super(name, price, category);
    }
}

class ProductCatalog {
    private List<Product<?>> products = new ArrayList<>();

    public void addProduct(Product<?> product) {
        products.add(product);
    }

    public void showCatalog() {
        for (Product<?> product : products) {
            System.out.println(product);
        }
    }
}

public class onlineMarketPlace {
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();

        Book book1 = new Book("The Alchemist", 15.99, BookCategory.FICTION);
        Clothing clothing1 = new Clothing("T-Shirt", 9.99, ClothingCategory.MEN);
        Gadget gadget1 = new Gadget("Smartphone", 699.99, GadgetCategory.MOBILE);

        catalog.addProduct(book1);
        catalog.addProduct(clothing1);
        catalog.addProduct(gadget1);

        System.out.println("Before discount:");
        catalog.showCatalog();

        // Applying discount
        book1.applyDiscount(10);
        clothing1.applyDiscount(20);
        gadget1.applyDiscount(5);

        System.out.println("\nAfter discount:");
        catalog.showCatalog();
    }
}
