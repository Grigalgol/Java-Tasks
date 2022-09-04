package stepik.java_functional_programming.task3;

public class Main {
    public static final TernaryIntPredicate allValuesAreDifferentPredicate = (a, b, c) -> {return a!= b && b != c && a != c;};
}
