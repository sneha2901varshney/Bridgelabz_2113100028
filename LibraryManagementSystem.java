import java.util.*;
public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        
        Book book = new Book("B001", "ABC", "PQR");
        Magazine magazine = new Magazine("M001", "Time Magazine", "Various");
        DVD dvd = new DVD("D001", "RST", "UVW");
        
        items.add(book);
        items.add(magazine);
        items.add(dvd);
        
        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            
            if (item instanceof Reservable) {
                ((Reservable) item).reserveItem();
                System.out.println("Available: " + ((Reservable) item).checkAvailability());
            }
            System.out.println();
        }
    }
}

interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    
    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }
    
    public String getItemId() {
        return itemId;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public abstract int getLoanDuration();
    
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }
    
    @Override
    public int getLoanDuration() {
        return 14; // 14 days loan duration
    }
    
    @Override
    public void reserveItem() {
        System.out.println("Book reserved: " + getTitle());
    }
    
    @Override
    public boolean checkAvailability() {
        return true; 
    }
}

// Magazine class
class Magazine extends LibraryItem {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }
    
    @Override
    public int getLoanDuration() {
        return 7; 
    }
}

// DVD class
class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }
    
    @Override
    public int getLoanDuration() {
        return 3; 
    }
    
    @Override
    public void reserveItem() {
        System.out.println("DVD reserved: " + getTitle());
    }
    
    @Override
    public boolean checkAvailability() {
        return false; 
    }
}

