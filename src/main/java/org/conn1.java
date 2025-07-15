package org;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class conn1 {
    public static Connection conn;
    public static Statement statement;
    public static ResultSet set;
    public static void Conn() throws SQLException,ClassNotFoundException{
    Class.forName("org.postgresql.Driver");
    conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_cats",
            "postgres","Nuk5092003nuk123?!");
    System.out.println("База подключена!");

    }
    public static void CreateDB() throws SQLException{
        statement =conn.createStatement();
        statement.executeUpdate("DROP TABLE IF EXISTS types;");
        statement.executeUpdate("CREATE TABLE types (" +
                "id INT PRIMARY KEY, type VARCHAR(100) NOT NULL);");
        System.out.println("Таблица создана!");
    }
    public static void SetTable() throws SQLException{
        System.out.println("NAhui");
    }
    public static void CloseDB() throws SQLException{
        statement.close();
        conn.close();
        System.out.println("ЗАкрылась дб");
    }
}
