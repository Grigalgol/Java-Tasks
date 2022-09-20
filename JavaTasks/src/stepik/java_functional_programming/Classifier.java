package stepik.java_functional_programming;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Classifier {

    public static Map<Integer, List<String>> group(List<String> words) {
        // write your code here
        return words.stream().collect(Collectors.groupingBy(String::length));
    }
}
