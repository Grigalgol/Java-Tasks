package stepik.java_functional_programming;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

class SumOfNumbers {

    public static long sum(long[] numbers) {
       return LongStream.of(numbers).sum();

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToLong(Long::parseLong)
                .toArray();

        System.out.println(sum(numbers));
    }
}