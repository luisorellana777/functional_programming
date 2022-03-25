package programming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FP05FunctionalReaderFile {

    public static void main(String[] args) throws IOException {

        Files.lines(Paths.get("file.txt")).forEach(System.out::println);

        System.out.println("------------");

        Files.list(Paths.get(".")).filter(Files::isDirectory).forEach(System.out::println);
    }

}
