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
        conn1.CloseDB();

    }
}
