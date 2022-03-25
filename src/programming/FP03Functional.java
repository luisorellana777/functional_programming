package programming;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FP03Functional {

    public static void main(String[] args) {

        final List<Integer> integers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        Function<Integer, Integer> squeareFunction = x -> x * x;
        Function<Integer, Integer> squeareFunctionImpl = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * integer;
            }
        };

        final List<Integer> collect = integers.stream().map(squeareFunction).collect(Collectors.toList());
        collect.forEach(System.out::println);

        final List<Integer> collectImpl = integers.stream().map(squeareFunctionImpl).collect(Collectors.toList());
        collectImpl.forEach(System.out::println);
    }

}
