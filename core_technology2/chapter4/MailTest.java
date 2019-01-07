package core_technology2.chapter4;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

/**
 * Created by wangbin10 on 2019/1/7.
 */
public class MailTest {
    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("mail", "mail.properties"))) {
            props.load(in);
        }
        List<String> lines = Files.readAllLines(Paths.get(args[0]), StandardCharsets.UTF_8);
        String from = lines.get(0);
        String to = lines.get(1);
        String subject = lines.get(2);
        StringBuilder builder = new StringBuilder();
        for (int i = 3; i < lines.size(); i++) {
            builder.append(lines.get(i));
            builder.append("\n");
        }

        Console console = System.console();
        String password = new String(console.readPassword("password:"));

    }
}
