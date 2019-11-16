/**
 * Package for calculate task.
 *
 * @author Karen Shakhnazaryan (shakasuone@gmail.com).
 * @version $Id$.
 * @since 0.1.
 */
package ru.job4j.calculator;

public class Calculator {
    /**
     *
     * @param first
     * @param second
     * the method will add two parameters.
     * and print the result to the console.
     */
    public static void add(double first, double second) {
        double result = first + second;
        System.out.println(first + " + " + second + " = " + result);
    }

    /**
     *
     * @param first
     * @param second
     * the method will divide the first into the second.
     * and print the result to the console.
     */
    public static void div(double first, double second) {
        double result = first / second;
        System.out.println(first + " / " + second + " = " + result);
    }

    /**
     *
     * @param first
     * @param second
     * the method will multiply the first by the second.
     * and print the result to the console.
     */
    public static void multiply(double first, double second) {
        double result = first * second;
        System.out.println(first + " * " + second + " = " + result);
    }
    /**
    *
    * @param first
    * @param second
    * the method will subtract the second from the first.
     * and print the result to the console.
     */
    public static void subtrack(double first, double second) {
        double result = first - second;
        System.out.println(first + " - " + second + " = " + result);
    }

    /**
     *
     * @param args - args
     * demonstrates the work of methods
     */
    public static void main(String[] args) {
        add(1, 1);
        div(4, 2);
        multiply(2, 1);
        subtrack(10, 5);
    }
}
