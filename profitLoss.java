public class profitLoss {
    public static void main(String[] args) {
     
        double costPrice = 129.0;
        double sellingPrice = 191.0;
        double profit = sellingPrice - costPrice;
        double profitPercentage = (profit / costPrice) * 100;
        System.out.println("The Cost Price is INR " + costPrice + 
                           " and Selling Price is INR " + sellingPrice + 
                           ", The Profit is INR " + profit + 
                           " and the Profit Percentage is " + profitPercentage + " %");
    }
}

