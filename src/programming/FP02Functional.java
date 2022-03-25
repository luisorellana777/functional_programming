package programming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class FP02Functional {

    public static void main(String[] args) {

        final List<Integer> integers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);


        int sum = addListFunctional(integers);
        System.out.println(sum);

        final int intValue = integers.stream().map(x -> x * x).reduce(0, getSquareAndSum()).intValue();
        System.out.println("sume y cuadrado: " + intValue);

        final Integer reduce = integers.stream().filter(x -> x % 2 == 0).map(x -> x * x).reduce(0, (x, y) -> x + y);
        System.out.println("Reduce de numeros pares y suma de cuadrados: " + reduce);

        integers.stream().distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        courses.stream().distinct().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);

        List<Integer> lessNumbers = Arrays.asList(1, 5, 6);
        final List<Integer> collect = lessNumbers.stream().map(x -> x * x).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    private static int addListFunctional(List<Integer> integers) {
        return integers.stream().reduce(0, (n1, n2) -> n1 + n2);
    }

    private static BinaryOperator<Integer> getSquareAndSum() {
        return (x, y) -> (x + y);
    }
}
