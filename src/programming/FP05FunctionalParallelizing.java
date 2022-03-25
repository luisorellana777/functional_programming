package programming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class FP05FunctionalParallelizing {

    public static void main(String[] args) {

        long time = System.currentTimeMillis();
        System.out.println(LongStream.range(0, 1000000000).parallel().sum());

        System.out.println(System.currentTimeMillis() - time);
    }

}
