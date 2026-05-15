package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection conn;

    public static Connection getConnection() {

        try {

            if (conn == null || conn.isClosed()) {

                String url = System.getenv("DB_URL");
                String user = System.getenv("DB_USER");
                String password = System.getenv("DB_PASSWORD");

                Class.forName("com.mysql.cj.jdbc.Driver");

                conn = DriverManager.getConnection(
                        url,
                        user,
                        password
                );

                System.out.println("Database Connected Successfully");
            }

        } catch (Exception e) {

            System.out.println("Database Connection Failed");
            e.printStackTrace();
        }

        return conn;
    }
}0