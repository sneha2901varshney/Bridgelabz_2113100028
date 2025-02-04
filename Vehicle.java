public class Vehicle
{
   private static int registrationFee = 500 ;
   private String ownerName ;
   private String vehicleType ;
   private final String registrationNumber ;
   private static int updateRegistrationFee ;

   static int updateRegistrationFee()
   {
    return updateRegistrationFee;
   }

Vehicle(String ownerName , String vehicleType , String registrationNumber)
{
    this.ownerName = ownerName ;
    this.vehicleType = vehicleType ;
    this.registrationNumber = registrationNumber ;
    updateRegistrationFee++ ;
}
 
 public void displayVehicleDetails()
 {
    if (this instanceof Vehicle)
    {
    System.out.println("Registration Fee: " +registrationFee );
    System.out.println("Owner Name: " +ownerName);
    System.out.println("Vehicle Type: " +vehicleType) ;
    System.out.println("Registration Number: " +registrationNumber );
    }
 }

 public static void main(String [] args)
 {
    Vehicle v1 = new Vehicle ("raj" , "car" , "67jj87" );
    Vehicle v2 = new Vehicle("anjanii" , "scooty" , "6767fdfs");

    v1.displayVehicleDetails();
    v2.displayVehicleDetails();

    System.out.println("Update Registration Fee: " + Vehicle.updateRegistrationFee());


 }

}