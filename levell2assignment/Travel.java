import java.util.Scanner;

public class Travel {
    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.print("Enter your starting city: ");
        String fromCity = input.nextLine();

        System.out.print("Enter the city you will pass via: ");
        String viaCity = input.nextLine();
        System.out.print("Enter your destination city: ");
        String toCity = input.nextLine();

        System.out.print("Enter the distance from " + fromCity + " to " + viaCity + " (in miles): ");
        double fromToVia = input.nextDouble();

        System.out.print("Enter the distance from " + viaCity + " to " + toCity + " (in miles): ");
        double viaToFinalCity = input.nextDouble();

        System.out.print("Enter the total time taken for the journey (in hours): ");
        double timeTaken = input.nextDouble();


        double totalDistance = fromToVia + viaToFinalCity;
        double averageSpeed = totalDistance / timeTaken;

        System.out.println("\nTravel Details:");
        System.out.println("Name: " + name);
        System.out.println("Starting City: " + fromCity);
        System.out.println("City Passed via: " + viaCity);
        System.out.println("Destination City: " + toCity);
        System.out.println("Total Distance (in miles): " + totalDistance);
        System.out.println("Total Time Taken (in hours): " + timeTaken);
        System.out.println("Average Speed (in miles per hour): " + averageSpeed);

       
        input.close();
    }
}
