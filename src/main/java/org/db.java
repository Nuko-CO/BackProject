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
        conn1.alterCatsTable();
        conn1.insert_cat("Барсик", "Абиссинская кошка", 3, 4.2);
        conn1.insert_cat("Мурка", "Сибирская", 2, 3.8); // Новый тип
        conn1.insert_cat("Том", "Абиссинская кошка", 5, 5.1);



        conn1.CloseDB();

    }
}
