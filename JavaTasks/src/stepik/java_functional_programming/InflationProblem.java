package stepik.java_functional_programming;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class InflationProblem {

    public static long calculateTotalPriceInFuture(int numberOfYears, List<Grocery> groceries) {
        double vegetables = 0;
        double fruits = 0;
        double dairyGroceries = 0;
        if (numberOfYears == 0) {
            return groceries.stream().map(Grocery::getCost).reduce(Long::sum).orElse(0L);
        }
        fruits = groceries
                .stream()
                .filter(n -> n.getCategory().equals(Category.FRUITS))
                .map(Grocery::getCost)
                .map(n -> n * Math.pow(4, numberOfYears))
                .reduce(fruits, Double::sum);
        vegetables = groceries
                .stream()
                .filter(n -> n.getCategory().equals(Category.VEGETABLES))
                .map(Grocery::getCost)
                .map(n -> n * Math.pow(3, numberOfYears))
                .reduce(vegetables, Double::sum);
        dairyGroceries = groceries
                .stream()
                .filter(n -> n.getCategory().equals(Category.DAIRY))
                .map(Grocery::getCost)
                .map(n -> n * Math.pow(2, numberOfYears))
                .reduce(dairyGroceries, Double::sum);

        return (long) (vegetables + dairyGroceries + fruits);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfYears = Integer.parseInt(scanner.nextLine());

        List<Grocery> groceries = Stream.iterate(1, i -> scanner.hasNextLine(), i -> i + 1)
                .map(i -> scanner.nextLine())
                .map(inputLine -> {
                    String[] parts = inputLine.split("\\s+");
                    return new Grocery(Long.parseLong(parts[0]), Category.valueOf(parts[1]));
                })
                .collect(Collectors.toList());

        long totalPriceInFuture = calculateTotalPriceInFuture(numberOfYears, groceries);

        System.out.println(totalPriceInFuture);
    }
}

enum Category {
    VEGETABLES,
    FRUITS,
    DAIRY
}

class Grocery {
    private final long cost;
    private final Category category;

    // Imagine that this class has some other fields but they are skipped for simplicity

    public Grocery(long cost, Category category) {
        this.cost = cost;
        this.category = category;
    }

    public long getCost() {
        return cost;
    }

    public Category getCategory() {
        return category;
    }
}
