package stepik.java_functional_programming;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;

class AbsoluteSum {

    public static long sumOfAbsoluteNumbers(Collection<Long> numbers) {
        if(numbers.size() == 1) return Math.abs(numbers.stream().toList().get(0));
        return numbers.stream().reduce((x, y) -> Math.abs(x) + Math.abs(y)).orElse(0L);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Collection<Long> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Long::parseLong)
                .collect(Collectors.toList());

        System.out.println(sumOfAbsoluteNumbers(numbers));
    }
}
