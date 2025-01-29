import java.time.LocalDate;

public class DateArithmetic {
    public static void main(String[] args) {
        LocalDate inputDate = LocalDate.of(2025, 1, 29); 

        LocalDate resultDate = inputDate
                .plusDays(7)
                .plusMonths(1)
                .plusYears(2)
                .minusWeeks(3);

        System.out.println("Input Date: " + inputDate);
        System.out.println("Result Date after adding 7 days, 1 month, 2 years, and subtracting 3 weeks: " + resultDate);
    }
}

