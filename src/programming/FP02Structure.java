package programming;

import java.util.List;

public class FP02Structure {

    public static void main(String[] args) {

        final List<Integer> integers = List.of(12, 913, 4, 6, 2, 4, 7, 8, 9, 7, 15);

        //printAllNumbersInlistStructure(integers);
        printEvenNumbersInlistStructure(integers);

        int sum = addListStructured(integers);
        System.out.println(sum);
    }

    private static int addListStructured(List<Integer> integers) {
        int sum = 0;
        for (int number : integers) {
            sum += number;
        }
        return sum;
    }

    private static void printAllNumbersInlistStructure(List<Integer> integers) {

        for (int i : integers) {
            System.out.println(i);
        }
    }

    private static void printEvenNumbersInlistStructure(List<Integer> integers) {

        for (int i : integers) {
            if (i % 2 == 0)
                System.out.println(i);
        }
    }
}
