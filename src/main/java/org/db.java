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

        conn1.get_type(4);
        conn1.get_type_where("type LIKE '%а%'");
        conn1.get_all_types();
        conn1.CloseDB();

    }
}
