package hu.tutorial;

import java.util.Random;

public class App {

    private static int[] numbers;

    public static void main(String[] args) {
        numbers = init(100, 100);
        print();
    }

    private static int[] init(int bound, int size) {
        Random random = new Random();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(bound - 1) + 1;
        }
        return numbers;
    }

    private static void print() {
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%4d", numbers[i]);
        }
    }
}
