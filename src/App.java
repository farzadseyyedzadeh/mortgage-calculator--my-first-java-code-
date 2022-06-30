import java.text.NumberFormat;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        double principle = readInput("Principle", 1_000, 1_000_000);
        float annualInterestRate = (float) readInput("Annual Interest Rate", 1, 30);
        byte years = (byte) readInput("Period (Years)", 1, 30);
        double mortgage = calculateMortgage(principle, annualInterestRate, years);
        System.out.println(NumberFormat.getCurrencyInstance().format(mortgage));
    }

    public static double readInput(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt + ": ");
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println(prompt + " must be between " + min + " and " + max);
        }
        return value;
    }

    public static double calculateMortgage(double principle, float annualInterestRate, byte years) {
        final byte NUMBER_OF_MONTH = 12;
        final byte PERCENT = 100;
        double monthlyInterestRate = annualInterestRate / NUMBER_OF_MONTH / PERCENT;
        int numberOfPayments = years * NUMBER_OF_MONTH;
        double mortgage = principle *
                (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)) /
                (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
        return mortgage;
    }
}
