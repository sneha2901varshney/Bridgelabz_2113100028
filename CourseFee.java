public class CourseFee {
    public static void main(String[] args) {
        double fee = 125000;
        double discountPercent = 10;
        double discount = (fee * discountPercent) / 100;
        double discountedFee = fee - discount;
        System.out.println("The discount amount is INR " + discount +
                           " and the final discounted fee is INR " + discountedFee);
    }
}

