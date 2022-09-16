package stepik.java_functional_programming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class HealthChecker {

    public static boolean checkPulseMeasurements(List<Integer> pulseMeasurements) {
        return pulseMeasurements.stream().allMatch(n -> n>=90 && n<=150);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> measurements = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println(checkPulseMeasurements(measurements));
    }
}
