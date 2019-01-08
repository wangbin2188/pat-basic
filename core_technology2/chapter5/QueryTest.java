package core_technology2.chapter5;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static core_technology2.chapter5.TestDB.getConnection;

/**
 * Created by wangbin10 on 2019/1/8.
 */
public class QueryTest {
    public static final String ALL_QUERY = "";
    public static final String AUTHOR_PUBLISHER_QUERY = "";
    public static final String AUTHOR_QUERY = "";
    public static final String PUBLISHER_QUERY = "";
    public static final String PRICE_UPDATE = "";
    private static Scanner in;
    private static Connection conn;
    private static ArrayList<String> authors = new ArrayList<>();
    private static ArrayList<String> publishers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try  {
            conn = getConnection();
            in = new Scanner(System.in);
            authors.add("Any");
            publishers.add("Any");
            Statement stat = conn.createStatement();
            String query = "select name from authors";
            ResultSet resultSet = stat.executeQuery(query);
            while (resultSet.next()) {
                authors.add(resultSet.getString(1));
            }

            query = "select name from publishers";
            resultSet = stat.executeQuery(query);
            while (resultSet.next()) {
                publishers.add(resultSet.getString(1));
            }

            boolean done=false;
            while (!done) {
                System.out.println("Q)uery C)hange price E)xit:");
                String input=in.nextLine().toUpperCase();
                if (input.equals("Q")) {
                    executeQuery();
                } else if (input.equals("C")) {
                    changePrices();
                }else {
                    done=true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void executeQuery() throws SQLException {
        String author = select("Authors:", authors);
        String publisher = select("Publisher:", publishers);
        PreparedStatement stat;
        if (!author.equals("Any") && !publisher.equals("Any")) {
            stat = conn.prepareStatement(AUTHOR_PUBLISHER_QUERY);
            stat.setString(1, author);
            stat.setString(2, publisher);
        } else if (!author.equals("Any") && publisher.equals("Any")) {
            stat = conn.prepareStatement(AUTHOR_QUERY);
            stat.setString(1,author);
        }else if (author.equals("Any") && !publisher.equals("Any")) {
            stat = conn.prepareStatement(PUBLISHER_QUERY);
            stat.setString(1,publisher);
        }else{
            stat = conn.prepareStatement(ALL_QUERY);
        }

        ResultSet resultSet = stat.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1)+","+resultSet.getString(2));
        }
    }

    private static void changePrices() throws SQLException {
        String publisher=select("Publisher:",  publishers.subList(1,publishers.size()));
        System.out.println("change price by :");
        double priceChange=in.nextDouble();
        PreparedStatement stat = conn.prepareStatement(PRICE_UPDATE);
        stat.setDouble(1, priceChange);
        stat.setString(2,publisher);
        int r = stat.executeUpdate();
        System.out.println(r+" publishers price update");
    }

    private static String select(String label, List<String> options) {
        while (true) {
            System.out.println(label);
            for (int i = 0; i < options.size(); i++) {
                System.out.printf("%d,%s",i+1,options.get(i));
            }
            int i = in.nextInt();
            if (i > 0 && i < options.size()) {
                return options.get(i-1);
            }
        }
    }
}
