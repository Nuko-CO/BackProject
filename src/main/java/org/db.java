package org;//package org;
//
//import java.sql.SQLException;
//
//public class db {
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        conn.Conn();
//        conn.CreateDB();
//        conn.WriteDB();
//        conn.ReadDB();
//        conn.CloseDB();
//    }
//}
import java.sql.SQLException;
public class db {
    public static void main(String[] args)throws ClassNotFoundException,SQLException  {
        conn1.Conn();
        conn1.CreateDB();
        conn1.createCatsTableIfNotExists();
        conn1.get_cat(3); // Получить кота по id
        conn1.get_cat_where("name LIKE '%а'"); // Коты, в имени которых есть 'а'
        conn1.get_all_cats(); // Все котики



        conn1.CloseDB();

    }
}
