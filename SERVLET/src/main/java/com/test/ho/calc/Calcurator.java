package com.test.ho.calc;

public class Calcurator {

	private static Calcurator calc;

	private Calcurator() {
	}

	static public Calcurator getInstance() {
		if (calc == null) {
			calc = new Calcurator();
		}
		return calc;
	}

	public String add(String numOne, String numTwo) {

		double sum = 0;

		double numone = Double.parseDouble(numOne);
		double numtwo = Double.parseDouble(numTwo);

		sum = numone + numtwo;

		System.out.println("+ : " + sum);

		return formatResult(sum);
	}

	public String minus(String numOne, String numTwo) {
		double sum = 0;

		double numone = Double.parseDouble(numOne);
		double numtwo = Double.parseDouble(numTwo);

		sum = numone - numtwo;

		System.out.println("- : " + sum);

		return formatResult(sum);
	}

	public String multiply(String numOne, String numTwo) {
		double sum = 0;

		double numone = Double.parseDouble(numOne);
		double numtwo = Double.parseDouble(numTwo);

		sum = numone * numtwo;

		System.out.println("* : " + sum);

		return formatResult(sum);
	}

	public String divide(String numOne, String numTwo) {
		double sum = 0;

		double numone = Double.parseDouble(numOne);
		double numtwo = Double.parseDouble(numTwo);
		sum = numone / numtwo;

		System.out.println("/ : " + sum);

		return formatResult(sum);
	}

	public String remain(String numOne, String numTwo) {
		double sum = 0;

		double numone = Double.parseDouble(numOne);
		double numtwo = Double.parseDouble(numTwo);

		sum = numone % numtwo;

		System.out.println("% : " + sum);

		return formatResult(sum);
	}

	private String formatResult(double result) {
		if (result % 1 == 0) {
			return String.format("%.0f", result);
		} else {
			return String.valueOf(result);
		}
	}

}
