package core_technology2.chapter1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static core_technology2.chapter1.CountLongWords.filePath;

public class OptionalTest {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split("\\PL+"));
        Optional<String> optionalValue = wordList.stream()
                .filter(s -> s.contains("alfred"))
                .findFirst();
        System.out.println(optionalValue.orElse("No word") + " contains stream");

        Optional<Object> optionalString = Optional.empty();
        String result = (String) optionalString.orElse("N/A");
        System.out.println("result:" + result);
        result = (String) optionalString.orElseGet(() -> Locale.getDefault().getDisplayName());
        System.out.println("result:" + result);
        try {
            result = (String) optionalString.orElseThrow(IllegalStateException::new);
            System.out.println("result:" + result);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        System.out.println("=======================");
        optionalValue = wordList.stream()
                .filter(s -> s.contains("words"))
                .findFirst();
        optionalValue.ifPresent(s -> System.out.println(s + " contains words"));
        System.out.println("=======================");
        HashSet<String> results = new HashSet<>();
        optionalValue.ifPresent(results::add);

        Optional<Boolean> added = optionalValue.map(results::add);
        System.out.println(added);

        System.out.println(inverse(4.0).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(-1.0).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(0.0).flatMap(OptionalTest::squareRoot));

        Optional<Double> result2 = Optional.of(-4.0).flatMap(OptionalTest::inverse).flatMap(OptionalTest::squareRoot);
        System.out.println(result2);

    }

    public static Optional<Double> inverse(Double x) {
        return x == 0 ? Optional.empty() : Optional.of(1 / x);
    }

    public static Optional<Double> squareRoot(Double x) {
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }
}
