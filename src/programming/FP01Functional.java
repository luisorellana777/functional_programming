package programming;

import java.util.List;

public class FP01Functional {


    public static void main(String[] args) {
        final List<Integer> integers = List.of(12, 9, 13, 4, 6, 2, 4, 7, 8, 9, 7, 15);
        //printAllNumbersInlistFunctional(integers);
        //printEvenNumbersInlistFunctional(integers);
        printOddNumbersInlistFunctional(integers);

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        printStringValuesInlistFunctional(courses, "", 4);

        printSquareNumbersInlistFunctional(integers);

        printCubeNumbersInlistFunctional(integers);

        printLenghtInlistFunctional(courses);
    }

    private static void printAllNumbersInlistFunctional(List<Integer> integers) {

        integers.forEach(System.out::println);
    }

    private static void printEvenNumbersInlistFunctional(List<Integer> integers) {

        integers.stream().filter(number -> number % 2 == 0).forEach(System.out::println);
    }

    private static void printOddNumbersInlistFunctional(List<Integer> integers) {

        integers.stream().filter(number -> number % 2 != 0).forEach(System.out::println);
    }

    private static void printStringValuesInlistFunctional(List<String> integers, String searchWord, int lenghtNumber) {

        integers.stream().filter(word -> {
            if (searchWord.isEmpty() && lenghtNumber == 0) return true;
            if (lenghtNumber == 0) return word.contains(searchWord);
            if (searchWord.isEmpty()) return word.length() >= lenghtNumber;
            return word.contains(searchWord) && word.length() == lenghtNumber;
        }).forEach(System.out::println);
    }

    private static void printSquareNumbersInlistFunctional(List<Integer> integers) {

        integers.stream().map(number -> String.valueOf(number * number)).forEach(System.out::println);
    }

    private static void printCubeNumbersInlistFunctional(List<Integer> integers) {

        integers.stream().filter(number -> number % 2 != 0).map(number -> number * number * number).forEach(System.out::println);
    }

    private static void printLenghtInlistFunctional(List<String> courseNames) {

        courseNames.stream().map(name -> name.concat(" " + name.length())).forEach(System.out::println);
    }

}
