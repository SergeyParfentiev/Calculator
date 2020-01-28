package engine;

import operator.Addition;
import operator.Operator;
import operator.Subtraction;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Engine {

    private Map<String, Operator> operators = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    private double firstNumber;
    private double secondNumber;
    private Operator operator;
    private boolean isDecimalCalculation;

    public Engine() {
        fillOperations();
    }

    public void start() {
        System.out.println("Good day. The calculator has the following operations: ");
        System.out.println("------------------------------------------");
        for (Operator operator : operators.values()) {
            System.out.println(operator.getCharacterOperation() + " - " + operator.getDescription());
        }
        System.out.println("------------------------------------------");

        getFirstNumber();
    }

    private void getFirstNumber() {
        System.out.println("Enter the first number");

        if (scanner.hasNextInt()) {
            firstNumber = scanner.nextInt();

            getOperator();
        } else if (scanner.hasNextDouble()) {
            firstNumber = scanner.nextDouble();
            isDecimalCalculation = true;

            getOperator();
        } else {
            System.out.println("There is not a number. Try again.");
            scanner.next();

            getFirstNumber();
        }
    }

    private void getOperator() {
        System.out.println("Enter the operator");

        String enteredCharacterOperator = scanner.next();
        operator = operators.get(enteredCharacterOperator);

        if (operator != null) {
            getSecondNumber();
        } else {
            System.out.println("There is no such operation. Try again.");
            scanner.next();

            getOperator();
        }
    }

    private void getSecondNumber() {
        System.out.println("Enter the second number");

        if (scanner.hasNextInt()) {
            secondNumber = scanner.nextInt();

            calculate();
        } else if (scanner.hasNextDouble()) {
            secondNumber = scanner.nextDouble();
            isDecimalCalculation = true;

            calculate();
        } else {
            System.out.println("There is not a number. Try again.");
            scanner.next();

            getSecondNumber();
        }
    }

    private void calculate() {
        System.out.print("Result of calculation equals: ");
        if (isDecimalCalculation) {
            operator.calculateDouble(firstNumber, secondNumber);
        } else {
            operator.calculateInt((int) firstNumber, (int) secondNumber);
        }
    }

    private void fillOperations() {
        Operator operator = new Addition();
        operators.put(operator.getCharacterOperation(), operator);

        operator = new Subtraction();
        operators.put(operator.getCharacterOperation(), operator);
    }
}
