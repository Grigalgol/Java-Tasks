package stepik.java_functional_programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

class AbsoluteNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String result = Arrays.stream(scanner.nextLine().split("\\s+")) // Stream<String>
                // add one or more map invocations here
                .map(n -> String.valueOf(Math.abs(Integer.parseInt(n))))
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }
}
