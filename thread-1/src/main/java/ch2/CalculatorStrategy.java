package ch2;

@FunctionalInterface
public interface CalculatorStrategy {

    double calculate(double salary, double bonus);
}
