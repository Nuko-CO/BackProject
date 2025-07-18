package org;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    public static void delete_type(int id) throws SQLException {
        statement = conn.createStatement();
        statement.executeUpdate("DELETE FROM types WHERE id = " + id);
        System.out.println("Удалено: id = " + id);
    }

    // Обновление записи по id
    public static void update_type(int id, String new_type) throws SQLException {
        String sql = "UPDATE types SET type = ? WHERE id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, new_type);
        preparedStatement.setInt(2, id);

        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Обновлено: id = " + id + " на тип = " + new_type);
        } else {
            System.out.println("❗ Запись с id = " + id + " не найдена.");
        }

        preparedStatement.close();
    }
    public static void get_type(int id) throws SQLException{
        set = statement.executeQuery("SELECT * FROM types WHERE id = " + id);
        while (set.next()){
            id = set.getInt("id");
            String type = set.getString("type");
            System.out.println("id = " + id + ", type = " + type);
        }
        System.out.println("все четко работает");
    }
    public static void get_type_where(String where) throws SQLException{
        set = statement.executeQuery("SELECT * FROM types WHERE " + where);
        while (set.next()){
            int id = set.getInt("id");
            String type = set.getString("type");
            System.out.println("id = " + id + ", type = " + type);
        }
        System.out.println("Пошел наху все работает");
    }
    public static void get_all_types() throws SQLException{
        set = statement.executeQuery("SELECT * FROM types");
        while (set.next()){
            int id = set.getInt("id");
            String type = set.getString("type");
            System.out.println("id = " + id + ", type = " + type);
        }
    }
    public static void createCatsTableIfNotExists() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS cats (" +
                "id SERIAL PRIMARY KEY, " +
                "name VARCHAR(100) NOT NULL, " +
                "type_id INTEGER REFERENCES types(id), " +
                "age INTEGER, " +
                "weight DOUBLE PRECISION" +
                ")";
        statement = conn.createStatement();
        statement.executeUpdate(sql);
        System.out.println("Таблица cats создана (или уже существовала).");
    }
    public static void alterCatsTable() throws SQLException {
        statement = conn.createStatement();
        try {
            statement.executeUpdate("ALTER TABLE cats ADD COLUMN age INTEGER");
            System.out.println("Колонка 'age' добавлена.");
        } catch (SQLException e) {
            if (e.getMessage().contains("column \"age\" of relation \"cats\" already exists")) {
                System.out.println("Колонка 'age' уже существует.");
            } else {
                throw e;
            }
        }

        try {
            statement.executeUpdate("ALTER TABLE cats ADD COLUMN weight DOUBLE PRECISION");
            System.out.println("Колонка 'weight' добавлена.");
        } catch (SQLException e) {
            if (e.getMessage().contains("column \"weight\" of relation \"cats\" already exists")) {
                System.out.println("Колонка 'weight' уже существует.");
            } else {
                throw e;
            }
        }
    }
   
//    public static Integer getTypeId(String type) throws SQLException{
//        String sql = "SELECT id FROM types WHERE type = ?";
//        PreparedStatement ps = conn.prepareStatement(sql);
//        ps.setString(1, type);
//        ResultSet rs = ps.executeQuery();
//        if (rs.next()) {
//            return rs.getInt("id");
//        }
//        return null; // Типа нет
//    }
//    public static int insertTypeAndGetId(String type) throws SQLException {
//        String insertSql = "INSERT INTO types (type) VALUES (?) RETURNING id";
//        PreparedStatement ps = conn.prepareStatement(insertSql);
//        ps.setString(1, type);
//        ResultSet rs = ps.executeQuery();
//        if (rs.next()) {
//            return rs.getInt("id");
//        } else {
//            throw new SQLException("Не удалось добавить тип");
//        }
//    }
//    public static void insert_cat(String name, String type, int age, Double weight) throws SQLException {
//        Integer typeId = getTypeId(type);
//
//        if (typeId == null) {
//            System.out.println("Тип " + type + " не найден. Добавляю...");
//            typeId = insertTypeAndGetId(type);
//        }
//
//        String sql = "INSERT INTO cats (name, type_id, age, weight) VALUES (?, ?, ?, ?)";
//        PreparedStatement ps = conn.prepareStatement(sql);
//        ps.setString(1, name);
//        ps.setInt(2, typeId);
//        ps.setInt(3, age);
//        ps.setDouble(4, weight);
//        ps.executeUpdate();
//
//        System.out.println("Кот добавлен: " + name + ", тип: " + type + ", возраст: " + age + ", вес: " + weight);
//    }
    public static void insert_cat(String name, String type, int age, Double weight) throws SQLException{
        ResultSet rs = statement.executeQuery("SELECT id FROM types WHERE type = '" + type + "'");
        Integer typeId = null;
        if (rs.next()) {
            typeId = rs.getInt("id");
        }
        if(typeId == null){
            statement.executeUpdate("INSERT INTO types (type) VALUES ('" + type + "')");
            ResultSet rs2 = statement.executeQuery("SELECT id FROM types WHERE type = '" + type + "'");
            if (rs2.next()) {
                typeId = rs2.getInt("id");
            }
        }
        String sql = "INSERT INTO cats (name, type_id, age, weight) VALUES ('" + name + "', " + typeId + ", " + age + ", " + weight + ")";
        statement.executeUpdate(sql);
        System.out.println("Кот " + name + " добавлен.");
    }
    public static void add_more_cats(int n) throws SQLException {
        // 1. Получаем все доступные type_id
        List<Integer> typeIds = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT id FROM types");
        while (rs.next()) {
            typeIds.add(rs.getInt("id"));
        }

        if (typeIds.isEmpty()) {
            System.out.println("❗ Нет доступных типов кошек в таблице types.");
            return;
        }

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            String name = names[random.nextInt(names.length)];
            int type_id = typeIds.get(random.nextInt(typeIds.size()));
            int age = random.nextInt(20) + 1; // возраст 1–20
            double weight = Math.round((2 + random.nextDouble() * 6) * 10.0) / 10.0; // вес 2–8 кг, округленный

            String sql = "INSERT INTO cats (name, type_id, age, weight) VALUES ('" +
                    name + "', " + type_id + ", " + age + ", " + weight + ")";
            statement.executeUpdate(sql);
        }

        System.out.println("✅ Добавлено " + n + " случайных котиков.");
    }
    static String[] names = {"Гарфилд",

            "Том",

            "Гудвин",

            "Рокки",

            "Ленивец",

            "Пушок",

            "Спорти",

            "Бегемот",

            "Пират",

            "Гудини",

            "Зорро",

            "Саймон",

            "Альбус",

            "Базилио",

            "Леопольд",

            "Нарцисс",

            "Атос",

            "Каспер",

            "Валлито",

            "Оксфорд",

            "Бисквит",

            "Соня",

            "Клеопатра",

            "Цунами",

            "Забияка",

            "Матильда",

            "Кнопка",

            "Масяня",

            "Царапка",

            "Серсея",

            "Ворсинка",

            "Амели",

            "Наоми",

            "Маркиза",

            "Изольда",

            "Вальс",

            "Несквик",

            "Златан",

            "Баскет",

            "Изюм",

            "Цукат",

            "Мокко",

            "Месси",

            "Кокос",

            "Адидас",

            "Бейлиз",

            "Тайгер",

            "Зефир",

            "Мохи",

            "Валенсия",

            "Баунти",

            "Свити",

            "Текила",

            "Ириска",

            "Карамель",

            "Виски",

            "Кукуруза",

            "Гренка",

            "Фасолька",

            "Льдинка",

            "Китана",

            "Офелия",

            "Дайкири",

            "Брусника",

            "Аватар",

            "Космос",

            "Призрак",

            "Изумруд",

            "Плинтус",

            "Яндекс",

            "Крисмас",

            "Метеор",

            "Оптимус",

            "Смайлик",

            "Цельсий",

            "Краска",

            "Дейзи",

            "Пенка",

            "Веста",

            "Астра",

            "Эйприл",

            "Среда",

            "Бусинка",

            "Гайка",

            "Елка",

            "Золушка",

            "Мята",

            "Радость",

            "Сиам",

            "Оскар",

            "Феликс",

            "Гарри",

            "Байрон",

            "Чарли",

            "Симба",

            "Тао",

            "Абу",

            "Ватсон",

            "Енисей",

            "Измир",

            "Кайзер",

            "Васаби",

            "Байкал",

            "Багира",

            "Айрис",

            "Диана",

            "Мими",

            "Сакура",

            "Индия",

            "Тиффани",

            "Скарлетт",

            "Пикси",

            "Лиззи",

            "Алиса",

            "Лило",

            "Ямайка",

            "Пэрис",

            "Мальта",

            "Аляска"

    };
    public static void delete_cat(int id) throws SQLException {
        statement = conn.createStatement();
        statement.executeUpdate("DELETE FROM cats WHERE id = " + id);
        System.out.println("Удалено: id = " + id);
    }
    public static void delete_cat(String where) throws SQLException{
        statement = conn.createStatement();
        statement.executeUpdate("DELETE FROM cats WHERE " + where);
        System.out.println("FUCK you");
    }
    public static void update_cat(int id, String set, String where) throws SQLException {
        statement = conn.createStatement();
        String sql = "UPDATE cats SET " + set + " WHERE id = " + id + " AND " + where;
        int rowsAffected = statement.executeUpdate(sql);

        if (rowsAffected > 0) {
            System.out.println("✅ Обновлён кот с id = " + id + " по условию: " + where);
        } else {
            System.out.println("⚠️ Не найден кот с id = " + id + " по условию: " + where + " — ничего не обновлено.");
        }
    }
    public static void get_cat(int id) throws SQLException{
        set = statement.executeQuery("SELECT * FROM cats WHERE id = " + id);
        boolean found = false;
        while (set.next()){
            found =true;
            String name = set.getString("name");
            int age = set.getInt("age");
            double weight = set.getDouble("weight");
            int typeid = set.getInt("type_id");
            System.out.println("name - " + name + " age - " + age + " weigth - " + weight + " typeid - " + typeid);
        }
        if(!found){
            System.out.println("Котик не найден.");
        }
    }
    public static void get_cat_where (String where) throws  SQLException{
        set = statement.executeQuery("SELECT * FROM cats WHERE " + where);
        boolean found = false;
        while (set.next()){
            found = true;
            String name = set.getString("name");
            int age = set.getInt("age");
            double weight = set.getDouble("weight");
            int typeid = set.getInt("type_id");
            System.out.println("name - " + name + " age - " + age + " weigth - " + weight + " typeid - " + typeid);
        }
        if(!found){
            System.out.println("Котик не найден.");
        }
    }
    public static void get_all_cats() throws SQLException{
        set = statement.executeQuery("SELECT * FROM cats");
        boolean found = false;
        while (set.next()){
            found = true;
            String name = set.getString("name");
            int age = set.getInt("age");
            double weight = set.getDouble("weight");
            int typeid = set.getInt("type_id");
            System.out.println("name - " + name + " age - " + age + " weigth - " + weight + " typeid - " + typeid);
        }
        if(!found){
            System.out.println("Котик не найден.");
        }
    }

}
