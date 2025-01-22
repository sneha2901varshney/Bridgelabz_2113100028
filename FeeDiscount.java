import java.util.Scanner;

public class FeeDiscount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Student Fee (INR): ");
        double fee = input.nextDouble();
        System.out.print("Enter the Discount Percentage: ");
        double discountPercent = input.nextDouble();

        double discount = (fee * discountPercent) / 100;
        double discountedFee = fee - discount;
        System.out.println("The discount amount is INR " + discount +
                           " and final discounted fee is INR " + discountedFee);
        input.close();
    }
}

