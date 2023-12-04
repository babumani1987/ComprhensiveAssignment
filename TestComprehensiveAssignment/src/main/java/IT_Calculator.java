import java.util.Scanner;

public class IT_Calculator {

    // Variables
    private double taxableIncome;
    private double taxPaidPerYear;
    private double taxPayablePerMonth;

    // Tax rates
    private static final double TAX_RATE_0 = 0.0;
    private static final double TAX_RATE_10 = 0.1;
    private static final double TAX_RATE_20 = 0.2;
    private static final double TAX_RATE_30 = 0.3;

    // Constructor
    public IT_Calculator(double taxableIncome) {
        this.taxableIncome = taxableIncome;
        calculateTax();
    }

    // Method to calculate tax based on taxable income
    private void calculateTax() {
        if (taxableIncome <= 25000) {
            taxPaidPerYear = taxableIncome * TAX_RATE_0;
        } else if (taxableIncome <= 50000) {
            taxPaidPerYear = taxableIncome * TAX_RATE_10;
        } else if (taxableIncome <= 75000) {
            taxPaidPerYear = taxableIncome * TAX_RATE_20;
        } else {
            taxPaidPerYear = taxableIncome * TAX_RATE_30;
        }

        taxPayablePerMonth = taxPaidPerYear / 12;
    }

    // Method to get tax paid per year
    public double getTaxPaidPerYear() {
        return taxPaidPerYear;
    }

    // Method to get tax payable per month
    public double getTaxPayablePerMonth() {
        return taxPayablePerMonth;
    }

    public static void main(String[] args) {
        // Read taxable income using Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Taxable Income: ");
        double income = scanner.nextDouble();

        // Create IT_Calculator instance
        IT_Calculator calculator = new IT_Calculator(income);

        // Print results
        System.out.println("Tax Paid Per Year: $" + calculator.getTaxPaidPerYear());
        System.out.println("Tax Payable Per Month: $" + calculator.getTaxPayablePerMonth());
    }
}
