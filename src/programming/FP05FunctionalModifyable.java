package programming;

import java.util.ArrayList;
import java.util.List;

public class FP05FunctionalModifyable {

    public static void main(String[] args) {

        List<String> courses = new ArrayList<>(List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes"));

        courses.replaceAll(String::toUpperCase);
        courses.forEach(System.out::println);

        System.out.println("------------");

        courses.removeIf(course->course.length()>5);
        courses.forEach(System.out::println);
    }

}
