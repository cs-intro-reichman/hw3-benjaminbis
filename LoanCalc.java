public class LoanCalc {

	static double epsilon = 0.001;  
	static int iterationCounter;    

	public static void main(String[] args) {		
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);

		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	private static double endBalance(double loan, double rate, int n, double payment) {
		double balance = loan;
		rate /= 100;
		for (int i = 0; i < n; i++) {
			balance = (balance - payment) * (1 + rate);
		}
		return balance;
	}

	public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		iterationCounter = 0;
		double payment = loan / n;
		double increment = epsilon;

		while (true) {
			double balance = endBalance(loan, rate, n, payment);

			if (balance <= 0) break;
			payment += increment;
			iterationCounter++;
		}

		return payment;
	}

	public static double bisectionSolver(double loan, double rate, int n, double epsilon) {
		iterationCounter = 0;
		double lo = loan / n;
		double hi = loan;
		double mid;

		while (hi - lo > epsilon) {
			mid = (lo + hi) / 2;
			double balance = endBalance(loan, rate, n, mid);

			if (balance > epsilon) lo = mid;
			else if (balance < -epsilon) hi = mid;
			else return mid;

			iterationCounter++;
		}

		return (lo + hi) / 2;
	}
}
