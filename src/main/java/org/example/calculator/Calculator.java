package org.example.calculator;

public class Calculator {

    public int addNumbers(int numberOne, int numberTwo) {
        return numberOne + numberTwo;
    }

    public int subtractNumbers(int originalNumber, int numberToSubtract) {
        return originalNumber - numberToSubtract;
    }

    public int multiplyNumbers(int numberOne, int numberTwo) {
        return numberOne * numberTwo;
    }

    public double divideNumbers(int numberOne, int numberTwo) {
        double result = 0;
        if (numberTwo == 0) {
            throw new IllegalArgumentException("You cannot divide by zero!");
        } else {
            result = (double) numberOne / numberTwo;
        }
        return result;
    }

    public int findRemainder(int numberOne, int numberTwo) {
        if (numberTwo == 0) {
            throw new IllegalArgumentException("You cannot divide by zero!");
        }
        return numberOne % numberTwo;
    }
}
