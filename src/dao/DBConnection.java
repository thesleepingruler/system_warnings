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

                // FORCE MYSQL DRIVER LOAD
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

                conn = DriverManager.getConnection(
                        url,
                        user,
                        password
                );

                System.out.println("DATABASE CONNECTED SUCCESSFULLY");
            }

        } catch (Exception e) {

            System.out.println("DATABASE CONNECTION FAILED");
            e.printStackTrace();
        }

        return conn;
    }
}0