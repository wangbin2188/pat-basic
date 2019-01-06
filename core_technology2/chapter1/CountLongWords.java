package core_technology2.chapter1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CountLongWords {
    public static String filePath="/Users/gaochengcheng/Documents/java_project/core_technology/src/core_technology2/chapter1/CountLongWords.java";
    public static void main(String[] args) throws IOException {

        String contents = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("\\PL+"));
        long count=0;
        for (String word : words) {
            if (word.length() > 12) {
                count++;
            }
        }
        System.out.println(count);

        count=words.stream().filter(w->w.length()>12).count();
        System.out.println(count);

        count=words.parallelStream().filter(w->w.length()>12).count();
        System.out.println(count);
    }
}
