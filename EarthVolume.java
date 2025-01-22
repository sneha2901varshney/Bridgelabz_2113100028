import java.util.* ;
public class EarthVolume {
    public static void main(String[] args) {
        double radiusKm = 6378.0;
        double kmToMiles = 0.621371;
        double volumeKm3 = (4.0 / 3.0) * Math.PI * Math.pow(radiusKm, 3);
        double radiusMiles = radiusKm * kmToMiles;
        double volumeMiles3 = (4.0 / 3.0) * Math.PI * Math.pow(radiusMiles, 3);
        System.out.println("The volume of Earth in cubic kilometers is " + volumeKm3 +
                           " and in cubic miles is " + volumeMiles3);
    }
}
