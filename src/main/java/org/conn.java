//package org;
//import java.sql.SQLException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//public class conn {
//    public static Connection conn;
//    public static Statement statmt;
//    public static ResultSet resSet;
//    public static void Conn() throws ClassNotFoundException,SQLException{
//        Class.forName("org.postgresql.Driver");
//        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
//                "postgres",
//                "Nuk5092003nuk123?!");
//        System.out.println("База подключена!");
//    }
//    public static void CreateDB() throws SQLException{
//        statmt = conn.createStatement();
//        statmt.executeUpdate("""
//            CREATE TABLE IF NOT EXISTS users (
//                id SERIAL PRIMARY KEY,
//                name VARCHAR(100),
//                phone BIGINT
//            );
//        """);
//        System.out.println("Таблица создана и существует.");
//    }
//    public static void WriteDB() throws SQLException{
//        statmt.executeUpdate("INSERT INTO users (name, phone) VALUES ('Petya', 125453);");
//        statmt.executeUpdate("INSERT INTO users (name, phone) VALUES ('Vasya', 321789);");
//        statmt.executeUpdate("INSERT INTO users (name, phone) VALUES ('Masha', 456123);");
//        System.out.println("Данные добавлены.");
//    }
//    public static void ReadDB() throws SQLException{
//        resSet = statmt.executeQuery("SELECT * FROM users;");
//        while (resSet.next()){
//            int id = resSet.getInt("id");
//            String name = resSet.getString("name");
//            long phone = resSet.getLong("phone");
//
//            System.out.println("ID = " + id);
//            System.out.println("name = " + name);
//            System.out.println("phone = " + phone);
//            System.out.println();
//        }
//        System.out.println("Таблица users выведена.");
//    }
//    public static void CloseDB() throws SQLException {
//        conn.close();
//        statmt.close();
//        resSet.close();
//        System.out.println("Соединения закрыты.");
//    }
//
//}
