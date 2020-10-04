package hu.tutorial;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {

    public static final int BOUND = 100;
    public static final int SIZE = 100;

    private static List<Integer> numbers;

    public static void main(String[] args) {
        numbers = init();
        print();
        System.out.println("1. Sorozatszámatás: A számok összege: " + summation());
        int divisor = 2;
        boolean hasItem = decision(divisor);
        System.out.println("2. Eldöntés: " + (hasItem ? "Van " : "Nincs ") + "a tömbben " + divisor + "-al osztható szám!");
        if (hasItem) {
            System.out.println("3. Kiválasztás: A sorozat " + (selection(divisor) + 1) + ". eleme osztható " + divisor + "-al");
        }
        divisor = 3;
        int item = search(divisor);
        String searchResult = item > -1
                ? "A sorozat " + (item + 1) + ". eleme osztható " + divisor + "-al."
                : "A sorozatban nem található " + divisor + "-al osztható elem.";
        System.out.println("4. Keresés: " + searchResult);
        System.out.println("5. Megszámolás: A sorozatban " + count(divisor) + " darab " + divisor + "-al osztható elem található.");
        int max = maxSelection();
        System.out.println("6. Maximum kiválasztás: A sorozat legnagyobb értékeű eleme " +max);
    }

    private static List<Integer> init() {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            numbers.add(random.nextInt(BOUND - 1) + 1);
        }
        return numbers;
    }

    private static void print() {
        for (var number : numbers) {
            System.out.printf("%4d", number);
        }
        System.out.println();
    }

    private static int summation() {
        int sum = 0;
        for (var number : numbers) {
            sum = sum + number;
        }
        return sum;
    }

    private static boolean decision(int divisor) {
        int i = 0;
        while (i < numbers.size() && !(numbers.get(i) % divisor == 0)) {
            i++;
        }
        return i < numbers.size();
    }

    private static int selection(int divisor) {
        int i = 0;
        while (!(numbers.get(i) % divisor == 0)) {
            i++;
        }
        return i;
    }

    private static int search(int divisor) {
        int i = 0;
        while (i < numbers.size() && !(numbers.get(i) % divisor == 0)) {
            i++;
        }
        return i < numbers.size() ? i : -1;
    }

    private static int count(int divisor) {
        int count = 0;
        for (var number : numbers) {
            if (number % divisor == 0) {
                count++;
            }
        }
        return count;
    }

    private static int maxSelection() {
        int max = 0;
        for (var number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }
}
