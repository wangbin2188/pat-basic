package core_technology2.chapter5;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

/**
 * Created by wangbin10 on 2019/1/8.
 */
public class TestDB {
    public static void main(String[] args)  {
        try {
            runTest();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void runTest() throws SQLException,IOException {
        try (Connection connection = getConnection()) {
            Statement stat= connection.createStatement();
            stat.executeUpdate("");

            try (ResultSet resultSet = stat.executeQuery("")) {
                if (resultSet.next()) {
                    System.out.println(resultSet.getString(1));
                }
            }
        }
    }

    public static Connection getConnection() throws IOException, SQLException {
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("database.properties"))) {
            props.load(in);
        }
        String drivers = props.getProperty("jdbc.drivers");
        if (drivers != null) {
            System.setProperty("jdbc.drivers", drivers);
        }
        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");
        return DriverManager.getConnection(url, username, password);

    }
}
