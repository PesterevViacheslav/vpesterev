package ru.job4j.jdbc;
import org.junit.Test;
import ru.job4j.jdbc.sqllite.ConvertXSLT;
import ru.job4j.jdbc.sqllite.ParserXML;
import ru.job4j.jdbc.sqllite.StoreSQL;
import ru.job4j.jdbc.sqllite.StoreXML;
import java.io.File;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
/**
 * Class TestSQLLite - Тест работы с БД. Решение задач уровня Junior. Части 003. SQL, JDBC
 * 7.4.3. XML XSLT JDBC Оптимизация.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 24.08.2019
 * @version 1
 */
public class TestSQLLite {
    /**
     * Method deleteFile. Удаление дерева каталогов с файлами.
     * @param root Корневой каталог
     */
    public static void deleteFile(File root) {
        if (root.isDirectory()) {
            for (File sub : root.listFiles()) {
                deleteFile(sub);
            }
        }
        root.delete();
    }
    /**
     * Тест работы с БД.
     */
    @Test
    public void testSqlLite() throws Exception {
        try (StoreSQL db = new StoreSQL()) {
            db.createNewDatabase();
            db.connect();
            db.generate(10);
            StoreXML storeXML = new StoreXML(new File(StoreXML.STORE_FILE_PATH));
            File file = new File(String.join("", StoreSQL.PATH, File.separator, "parserXML.xml"));
            storeXML.save(db.load());
            ConvertXSLT convertXSLT = new ConvertXSLT(file);
            String convertRes = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><entries><entry field=\"0\"/><entry field=\"1\"/><entry field=\"2\"/><entry field=\"3\"/><entry field=\"4\"/><entry field=\"5\"/><entry field=\"6\"/><entry field=\"7\"/><entry field=\"8\"/><entry field=\"9\"/></entries>";
            assertThat(convertXSLT.convert().toString(), is(convertRes));
            ParserXML parserXML = new ParserXML(file);
            assertThat(parserXML.sumFields(), is(45));
        }
        deleteFile(new File(StoreSQL.PATH));
    }
}