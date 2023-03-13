package org.example.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class CalculatorTest {
    @InjectMocks
    private Calculator calculator;

    @Test
    public void addNumber_shouldReturnCorrectSum_withPositiveNumbers() {
        final int expected = 10;
        final int actual = calculator.addNumbers(5, 5);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void addNumber_shouldReturnCorrectSum_withNegativeNumbers() {
        final int expected = -10;
        final int actual = calculator.addNumbers(-5, -5);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void addNumber_shouldReturnCorrectSum_withZeroAndNegativeNumbers() {
        final int expected = -5;
        final int actual = calculator.addNumbers(-5, 0);
        assertThat(actual).isEqualTo(expected);
    }

    //subtractNumbers
    @Test
    public void subtractNumbers_shouldReturnCorrectValue_withPositiveNumbers() {
        final int expected = 0;
        final int actual = calculator.subtractNumbers(5, 5);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void subtractNumbers_shouldReturnCorrectValue_withNegativeNumbers() {
        final int expected = 0;
        final int actual = calculator.subtractNumbers(-5, -5);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void subtractNumbers_shouldReturnCorrectValue_withZeroAndNegativeNumbers() {
        final int expected = -5;
        final int actual = calculator.subtractNumbers(-5, 0);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void multiplyNumbers_shouldReturnCorrectValue_withZeroAndNegativeNumbers() {
        final int expected = 0;
        final int actual = calculator.multiplyNumbers(-5, 0);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void multiplyNumbers_shouldReturnCorrectNumber_withPositiveNumbers() {
        final int expected = 30;
        final int actual = calculator.multiplyNumbers(5, 6);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void multiplyNumbers_shouldReturnCorrectValue_withNegativeNumbers() {
        final int expected = 25;
        final int actual = calculator.multiplyNumbers(-5, -5);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void divideNumbers_shouldReturnCorrectNumber_withPositiveNumbers() {
        final double expected = 2.5;
        final double actual;
        actual = calculator.divideNumbers(15, 6);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void divideNumbers_shouldReturnCorrectValue_withNegativeNumbers() {
        final double expected = 1;
        final double actual;
        actual = calculator.divideNumbers(-5, -5);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void divideNumbers_shouldReturnCorrectValue_withZeroNumber() {
        final double expected = 0;
        final double actual;
        actual = calculator.divideNumbers(0, 1);
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void divideNumbers_shouldReturnException_whenDividingByZero() {
        int numberOne = 10;
        int numberTwo = 0;
        Exception exception = assertThrows(
                Exception.class,
                () -> calculator.divideNumbers(numberOne, numberTwo));
        String expectedMessage = "You cannot divide by zero!";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void findRemainder_shouldReturnCorrectNumber_withPositiveNumbers() {
        final int expected = 5;
        final int actual = calculator.findRemainder(5, 6);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void findRemainder_shouldReturnCorrectValue_withNegativeNumbers() {
        final int expected = -1;
        final int actual = calculator.findRemainder(-5, -4);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void findRemainder_shouldReturnCorrectValue_withZeroNumber() {
        final int expected = 0;
        final int actual;
        actual = calculator.findRemainder(0, 1);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void findRemainder_shouldReturnException_whenDividingByZero(){
        int numberOne = 10;
        int numberTwo = 0;
        Exception exception = assertThrows(
                Exception.class,
                () -> calculator.findRemainder(numberOne, numberTwo));
        String expectedMessage = "You cannot divide by zero!";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
