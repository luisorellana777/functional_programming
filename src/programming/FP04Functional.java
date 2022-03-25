package programming;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FP04Functional {

    public static void main(String[] args) {

        final List<Integer> integers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        Predicate<Integer> evenPredicate = x -> x % 2 == 0;
        Predicate<Integer> oddPredicate = x -> x % 2 != 0;

        FP04Functional.process(integers, evenPredicate);
        FP04Functional.process(integers, oddPredicate);

        FP04Functional.processFunction(integers, x -> x * x);

        Supplier<Integer> supplier = () -> new Random().nextInt(1000);
        Optional.ofNullable(supplier.get()).ifPresent(System.out::println);

        Consumer<String> comsumer = System.out::println;

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        courses.stream()
                .map(String::toUpperCase)
                .forEach(FP04Functional::print);

        Supplier<String> supplier1 = String::new;
    }

    private static void print(String str) {
        System.out.println(str);
    }

    private static void process(List<Integer> integers, Predicate<Integer> predicate) {

        integers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }

    private static void processFunction(List<Integer> integers, Function<Integer, Integer> function) {

        final List<Integer> collect = integers.stream()
                .map(function)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
    }

}
