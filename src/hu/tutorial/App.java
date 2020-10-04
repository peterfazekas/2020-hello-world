package hu.tutorial;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {

    private static List<Integer> numbers;

    public static void main(String[] args) {
        System.out.print("Hány elemű legyen a lista: ");
        int size = read();
        System.out.print("Adja meg a generált számok felső határát: ");
        int bound = read();
        numbers = init(bound, size);
        print(numbers);
        System.out.println("1. Sorozatszámatás: A számok összege: " + summation());
        int divisor = 2;
        boolean hasItem = decision(divisor);
        System.out.println("2. Eldöntés: " + (hasItem ? "Van " : "Nincs ") + "a tömbben " + divisor + "-al osztható szám!");
        if (hasItem) {
            System.out.println("3. Kiválasztás: A sorozat " + selection(divisor) + " értékű osztható " + divisor + "-al");
        }
        int anotherDivisor = 3;
        var search = search(anotherDivisor);
        String searchResult = search.map(i -> "A sorozat " + i + " értékű osztható " + anotherDivisor + "-al")
                .orElse("A sorozatban nem található " + anotherDivisor + "-al osztható elem.");
        System.out.println("4. Keresés: " + searchResult);
        System.out.println("5. Megszámolás: A sorozatban " + count(anotherDivisor) + " darab " + anotherDivisor + "-al osztható elem található.");
        int max = maxSelection();
        System.out.println("6. Maximum kiválasztás: A sorozat legnagyobb értékeű eleme " + max);
        System.out.println("A rendezetlen tömb elemei:");
        print(numbers);
        System.out.println("Rendzeve Stream-API-val:");
        print(sort());
    }

    private static int read() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static List<Integer> init(int bound, int size) {
        Random random = new Random();
        return IntStream.range(0, size)
                .mapToObj(i -> random.nextInt(bound - 1) + 1)
                .collect(Collectors.toList());
    }

    private static void print(List<Integer> list) {
        list.forEach(i -> System.out.printf("%4d", i));
        System.out.println();
    }

    private static int summation() {
        return numbers.stream()
                .mapToInt(i -> i)
                .sum();
    }

    private static boolean decision(int divisor) {
        return numbers.stream()
                .anyMatch(i -> i % divisor == 0);
    }

    private static int selection(int divisor) {
        return numbers.stream()
                .filter(i -> i % divisor == 0)
                .findFirst()
                .get();
    }

    private static Optional<Integer> search(int divisor) {
        return numbers.stream()
                .filter(i -> i % divisor == 0)
                .findFirst();
    }

    private static long count(int divisor) {
        return numbers.stream()
                .filter(i -> i % divisor == 0)
                .count();
    }

    private static int maxSelection() {
        return numbers.stream()
                .mapToInt(i -> i)
                .max()
                .getAsInt();
    }

    private static List<Integer> sort() {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
