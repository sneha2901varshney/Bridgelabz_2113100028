import java.util.* ;
public class SumofNaturalNumbers
{
    public static int Sum(int number)
    {
        int sum=0;
        for(int i=0; i <= number ; i++)
        {
            sum += i;
        }
        return sum;
    }

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int number = sc.nextInt();
        
        int result= Sum(number);
        System.out.println("Sum of first " + number + " natural numbers: " + Sum(number));

        sc.close();
    }
}