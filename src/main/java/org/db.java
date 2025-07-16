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
        conn1.update_cat(7, "age = 5, weight = 4.2", "type_id = 45");;



        conn1.CloseDB();

    }
}
