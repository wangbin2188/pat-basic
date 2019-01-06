package core_technology2.chapter1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import static core_technology2.chapter1.CountLongWords.filePath;
import static java.util.stream.Collectors.*;

public class ParallelStreams {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split("\\PL+"));

        int[] shortWords = new int[10];
        wordList.parallelStream().forEach(
                s->{
                    if (s.length() < 10) {
                        shortWords[s.length()]++;
                    }
                }
        );

        System.out.println(Arrays.toString(shortWords));

        Arrays.fill(shortWords, 0);

        wordList.parallelStream().forEach(
                s->{
                    if (s.length() < 10) {
                        shortWords[s.length()]++;
                    }
                }
        );

        System.out.println(Arrays.toString(shortWords));


        Map<Integer, Long> shortWordCounts = wordList.parallelStream()
                .filter(s -> s.length() < 10)
                .collect(groupingBy(String::length, counting()));

        System.out.println(shortWordCounts);

        ConcurrentMap<Integer, List<String>> result = wordList.parallelStream().collect(
                Collectors.groupingByConcurrent(String::length)
        );

        System.out.println(result.get(14));

        result = wordList.parallelStream().collect(
                Collectors.groupingByConcurrent(String::length)
        );
        System.out.println(result.get(14));

        ConcurrentMap<Integer, Long> wordCounts = wordList.parallelStream().collect(
                groupingByConcurrent(String::length, counting())
        );
        System.out.println(wordCounts);

    }
}
