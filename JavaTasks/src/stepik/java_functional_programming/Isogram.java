package stepik.java_functional_programming;

import java.util.Scanner;

class Isogram {

    public static boolean isIsogram(String word) {
        return (word.chars().distinct().count() == word.length());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();

        System.out.println(isIsogram(word));
    }
}