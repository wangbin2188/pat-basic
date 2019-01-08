package core_technology2.chapter5;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Scanner;

import static core_technology2.chapter5.TestDB.getConnection;

/**
 * Created by wangbin10 on 2019/1/8.
 */
public class ExecuteSQL {
    public static void main(String[] args) throws IOException {
        try {
            Scanner in = (args.length == 0 ? new Scanner(System.in) : new Scanner(Paths.get(args[0])));
            try (Connection conn = getConnection()) {
                Statement stat = conn.createStatement();
                while (true) {
                    if (args.length == 0) {
                        System.out.println("enter command or EXIT to exit:");
                    }
                    if (!in.hasNext() || in.nextLine().trim().equalsIgnoreCase("EXIT")) {
                        return;
                    }

                    String line = in.nextLine();
                    if (line.trim().endsWith(";")) {
                        line = line.trim();
                        line = line.substring(0, line.length() - 1);
                    }
                    try {
                        boolean result = stat.execute(line);
                        if (result) {
                            ResultSet rs = stat.getResultSet();
                            showResultSet(rs);
                        } else {
                            int count = stat.getUpdateCount();
                            System.out.println(count + "lines updated");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void showResultSet(ResultSet result) throws SQLException {
        ResultSetMetaData metaData = result.getMetaData();
        /**
         * 输出表头
         */
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            if (i > 1) {
                System.out.print(",");
            }
            System.out.print(metaData.getColumnLabel(i));
        }
        System.out.println();
        /**
         * 输出数据
         */
        for (int i = 1; i <= columnCount; i++) {
            if (i > 1) {
                System.out.print(",");
            }
            System.out.print(result.getString(i));
        }
        System.out.println();

    }


}
