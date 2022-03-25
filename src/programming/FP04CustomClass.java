package programming;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        super();
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public String toString() {
        return name + ":" + noOfStudents + ":" + reviewScore;
    }

}

public class FP04CustomClass {

    public static void main(String[] args) {
        List<Course> courses = List.of(new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000), new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000), new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000), new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000));


        final Predicate<Course> reviewScoreGratherThan95 = course -> course.getReviewScore() > 95;
        final Predicate<Course> reviewScoreGratherThan90 = course -> course.getReviewScore() > 90;

        System.out.println(courses.stream()
                .allMatch(reviewScoreGratherThan95));

        Comparator<Course> comparatorByNonOfStudents = Comparator.comparingInt(Course::getNoOfStudents).thenComparingInt(Course::getReviewScore).reversed();
        courses.stream().sorted(comparatorByNonOfStudents).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("------------");
        courses.stream().skip(2).limit(4).forEach(System.out::println);

        System.out.println("------------");
        courses.stream().takeWhile(x -> x.getName().contains("Spring")).forEach(System.out::println);

        System.out.println("------------");
        courses.stream().dropWhile(x -> x.getName().contains("Spring")).forEach(System.out::println);

        System.out.println("------------");
        courses.stream().max(Comparator.comparingInt(Course::getReviewScore)).ifPresent(System.out::println);

        System.out.println("------------");
        courses.stream().min(Comparator.comparingInt(Course::getNoOfStudents)).ifPresent(System.out::println);

        System.out.println("------------");
        courses.stream().findFirst().ifPresent(System.out::println);

        System.out.println("------------");
        courses.stream().findAny().ifPresent(System.out::println);

        System.out.println("------------");
        System.out.println(courses.stream().mapToInt(Course::getNoOfStudents).sum());

        System.out.println("------------");
        courses.stream().collect(Collectors.groupingBy(Course::getCategory)).forEach((k, v) -> {
            System.out.print(k.concat(" | "));
            System.out.println(v);
        });

        System.out.println("------------");
        courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())).forEach((k, v) -> {
            System.out.print(k.concat(" | "));
            System.out.println(v);
        });

        System.out.println("------------");
        courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))).forEach((k, v) -> {
            System.out.print(k.concat(" | "));
            System.out.println(v);
        });

        final int[] ints = {1, 2};
        Arrays.stream(ints).sum();

        System.out.println("------------");
        ArrayList<Integer> integers = new ArrayList<>();
        IntStream.iterate(0, i -> i + 1).limit(10).forEach(integers::add);
        integers.forEach(System.out::println);

        System.out.println("------------");
        System.out.println(LongStream.rangeClosed(1, 50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply));
    }
}
