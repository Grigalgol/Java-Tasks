package stepik;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println(Stream.of("[a", "b", "c]").collect(Collectors.joining()));
        Stream.of(1,2,3).toList();
    }
}
