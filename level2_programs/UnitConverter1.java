import java.util.* ;
public class UnitConverter1 {

    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }


    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }

    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }

    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
      System.out.print("Enter distance in km: ");
      double km = scanner.nextDouble();
       
       System.out.print("Enter distance in miles: ");
      double miles = scanner.nextDouble();


      
      System.out.print("Enter distance in meters: ");
      double meters = scanner.nextDouble();

     System.out.print("Enter distance in feet: ");
      double feet = scanner.nextDouble();

        System.out.println(km + " kilometers is " + convertKmToMiles(km) + " miles.");
        System.out.println(miles + " miles is " + convertMilesToKm(miles) + " kilometers.");
        System.out.println(meters + " meters is " + convertMetersToFeet(meters) + " feet.");
        System.out.println(feet + " feet is " + convertFeetToMeters(feet) + " meters.");
    }
}



