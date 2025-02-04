public class Product 
{
    private static int discount= 25 ;
   static private final String productI="23";
    private String productName ;
    private int price ;
    private int quantity ;
    private static int updateDiscount ;

 static int updateDiscount()
    {
        return updateDiscount ;
    }

    Product(String productName , int price , int quantity)
    {
        this.productName = productName ;
        this.price = price ;
        this.quantity = quantity;

    }

    public void displayProductDetails()
    {
        if( this instanceof Product)
        {
            System.out.println("Discount: "+discount);
            System.out.println("Product Name : " + productName );
            System.out.println("Price : " + price);
            System.out.println("Quantity: " + quantity);
        }
    }

    public static void main(String [] args )
    {
        Product pr1 = new Product("HairOil" , 250 , 1);
        Product pr2 = new Product ("Hand Towel" , 50 , 1);

        pr1.displayProductDetails();
        pr2.displayProductDetails();
    }
}