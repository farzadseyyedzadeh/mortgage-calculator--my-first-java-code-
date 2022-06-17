import java.util.Scanner;
import java.text.NumberFormat;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Principal
        System.out.print("Principal:");
        int principal = scanner.nextInt();
        // Interest rate
        System.out.print("Annual Interest(percent): ");
        double annualInterest = scanner.nextDouble();
        double monthlyInterest = annualInterest / 12 / 100;
        // Period
        System.out.print("Period (Years): ");
        int years = scanner.nextInt();
        int numberOfPayments = years * 12;

        scanner.close();
        // Calculate the monthly payment
        double mathPower = Math.pow(1 + monthlyInterest, numberOfPayments);
        double monthlyPayment = principal * (monthlyInterest * mathPower / (mathPower - 1));

        String monthlyPaymentFormatted = NumberFormat.getCurrencyInstance().format(monthlyPayment);
        // Print the result(monthlyPaymentFormatted)
        System.out.print(monthlyPaymentFormatted);
    }
}
