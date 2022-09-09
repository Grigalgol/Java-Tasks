package stepik.java_functional_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class CombiningPredicates {

    /**
     * The method represents the conjunction operator for a list of predicates.
     * For an empty list it returns the always true predicate.
     */
    public static IntPredicate conjunctAll(List<IntPredicate> predicates) {
        IntPredicate intPredicate = n -> true;
        for(IntPredicate predicate : predicates) {
            intPredicate = intPredicate.and(predicate);
        // write your code here
        }
        return intPredicate;
    }

    public static <T> Predicate<T> xor(Predicate<T> predicate1, Predicate<T> predicate2) {
        return t -> predicate1.test(t) ^ predicate2.test(t); // write your code here
    }

    // Don't change the code below
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split("\\s+");

        List<Boolean> values;
        if (strings[0].trim().length() == 0) {
            values = List.of();
        } else {
            values = Arrays.stream(strings)
                    .map(Boolean::parseBoolean)
                    .collect(Collectors.toList());
        }

        List<IntPredicate> predicates = new ArrayList<>();
        values.forEach(v -> predicates.add(x -> v));

        System.out.println(conjunctAll(predicates).test(0));
    }
}
