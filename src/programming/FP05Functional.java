package programming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FP05Functional {

    public static void main(String[] args) {

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        System.out.println(courses.stream().collect(Collectors.joining(",")));

        System.out.println("------------");
        System.out.println(courses.stream().map(course -> course.split("")).flatMap(Arrays::stream).collect(Collectors.toList()));


        System.out.println("------------");
        courses.stream().flatMap(course -> Stream.of(course.concat("||"))).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("------------");
        List<String> courses2 = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        courses.stream().flatMap(course -> courses2.stream().map(course2 -> List.of(course, courses2))).collect(Collectors.toList()).forEach(System.out::println);

    }

}
