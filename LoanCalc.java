public class LoanCalc {

    static double epsilon = 0.01; 
    static int iterationCounter;

    public static void main(String[] args) {
        double loan = Double.parseDouble(args[0]);
        double rate = Double.parseDouble(args[1]);
        int n = Integer.parseInt(args[2]);

        System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

        System.out.println("\nPeriodical payment, using brute force: " 
                + (int) bruteForceSolver(loan, rate, n, epsilon));
        System.out.println("number of iterations: " + iterationCounter);

        System.out.println("\nPeriodical payment, using bi-section search: " 
                + (int) bisectionSolver(loan, rate, n, epsilon));
        System.out.println("number of iterations: " + iterationCounter);
    }

    private static double endBalance(double loan, double rate, int n, double payment) {
        double balance = loan;
        for (int i = 0; i < n; i++) {
            balance += balance * (rate / 100);
            balance -= payment;
        }
        return balance;
    }

    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
        double payment = 0;
        iterationCounter = 0;

        while (Math.abs(endBalance(loan, rate, n, payment)) > epsilon) {
            payment += epsilon;
            iterationCounter++;
        }

        return payment;
    }

    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {
        double low = 0;
        double high = loan * (1 + rate / 100);
        double payment = 0;
        iterationCounter = 0;

        while (high - low > epsilon) {
            payment = (low + high) / 2;
            double balance = endBalance(loan, rate, n, payment);

            if (Math.abs(balance) < epsilon) {
                break;
            } else if (balance > 0) {
                low = payment;
            } else {
                high = payment;
            }

            iterationCounter++;
        }

        return payment;
    }
}
