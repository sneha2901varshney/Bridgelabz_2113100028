import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Month:");
        int m = sc.nextInt();
        System.out.println("Enter Day:");
        int d = sc.nextInt();
        System.out.println("Enter Year:");
        int y = sc.nextInt();

        int yo = y - (14 - m) / 12;
        int x = yo + yo / 4 - yo / 100 + yo / 400;
        int mo = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + 31 * mo / 12) % 7;

        switch (d0) {
            case 0:
                System.out.println("Sunday");
                break;
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;

        }


    }
}

