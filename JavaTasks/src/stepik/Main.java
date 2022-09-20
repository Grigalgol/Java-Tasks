package stepik;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println(Stream.of("[a", "b", "c]").collect(Collectors.joining()));
        Stream.of(1,2,3).toList();
    }
    public static LongStream createPrimesFilteringStream(long start, long end) {
        // write your code here
        return Stream.iterate(start, n -> n<end+1, n-> n+1).parallel().filter(NumberUtils::isPrime).mapToLong(n -> n);
    }

    static class NumberUtils {
        public static boolean isPrime(long n) {
            return n > 1 && LongStream
                    .rangeClosed(2, n - 1)
                    .noneMatch(divisor -> n % divisor == 0);
        }
    }
}
