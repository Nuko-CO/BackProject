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
    public static void CreateDB() throws SQLException {
        statement = conn.createStatement();
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS types (" +
                "id SERIAL PRIMARY KEY, " +
                "type VARCHAR(100) NOT NULL)");
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
    public static void  insert_type(String type) throws SQLException{
        statement = conn.createStatement();
        statement.executeUpdate("INSERT INTO types (type) VALUES ('" + type + "')");
        System.out.println("Добавлено: " + type);
    }
    public static void InsertTypeToDatabase() throws SQLException{
        String[] types = new String[]{"Абиссинская кошка",
                "Австралийский мист",
                "Американская жесткошерстная",
                "Американская короткошерстная",
                "Американский бобтейл",
                "Американский кёрл",
                "Балинезийская кошка",
                "Бенгальская кошка",
                "Бирманская кошка",
                "Бомбейская кошка",
                "Бразильская короткошёрстная",
                "Британская длинношерстная",
                "Британская короткошерстная",
                "Бурманская кошка",
                "Бурмилла кошка",
                "Гавана",
                "Гималайская кошка",
                "Девон-рекс",
                "Донской сфинкс",
                "Европейская короткошерстная",
                "Египетская мау",
                "Канадский сфинкс",
                "Кимрик",
                "Корат",
                "Корниш-рекс",
                "Курильский бобтейл",
                "Лаперм",
                "Манчкин",
                "Мейн-ку́н",
                "Меконгский бобтейл",
                "Мэнкс кошка",
                "Наполеон",
                "Немецкий рекс",
                "Нибелунг",
                "Норвежская лесная кошка",
                "Ориентальная кошка",
                "Оцикет",
                "Персидская кошка",
                "Петерболд",
                "Пиксибоб",
                "Рагамаффин",
                "Русская голубая кошка",
                "Рэгдолл",
                "Саванна",
                "Селкирк-рекс",
                "Сиамская кошка",
                "Сибирская кошка",
                "Сингапурская кошка",
                "Скоттиш-фолд",
                "Сноу-шу",
                "Сомалийская кошка",
                "Тайская кошка",
                "Тойгер",
                "Тонкинская кошка",
                "Турецкая ангорская кошка",
                "Турецкий ван",
                "Украинский левкой",
                "Чаузи",
                "Шартрез",
                "Экзотическая короткошерстная",
                "Японский бобтейл"

        };
        for(String type: types){
            insert_type(type);
        }
    }



}
