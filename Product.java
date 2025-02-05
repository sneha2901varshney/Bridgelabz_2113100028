
import java.util.* ;

public class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }


    public String toString() {
        return name + " ($" + price + ")";
    }

public static void main(String[] args)
 {
        Customer customer1 = new Customer(1, "Alia");
        Product product1 = new Product(101, "Laptop", 12000);
        Product product2 = new Product(102, "Mouse", 500);

        Order order1 = new Order(50, customer1);
        order1.addProduct(product1);
        order1.addProduct(product2);

        System.out.println(order1);
    }

}

class Customer {
    private int customerId;
    private String name;
    private List<Order> orders;

    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public String toString() {
        return "Customer: " + name + " (ID: " + customerId + ")";
    }
}

class Order {
    private int orderId;
    private Customer customer;
    private List<Product> products;
    private double totalPrice;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
        this.totalPrice = 0;
        customer.placeOrder(this);
    }

    public void addProduct(Product product) {
        products.add(product);
        totalPrice += product.price;
    }


    public String toString() {
        StringBuilder productList = new StringBuilder();
        for (Product product : products) {
            productList.append(product.toString()).append("\n");
        }
        return "Order ID: " + orderId + "\nCustomer: " + customer.name + "\nProducts:\n" + productList + "Total: $" + totalPrice;
    }
}



