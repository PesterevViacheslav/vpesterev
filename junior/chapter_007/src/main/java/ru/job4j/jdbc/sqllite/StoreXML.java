package ru.job4j.jdbc.sqllite;
import java.io.*;
import java.util.List;
import java.util.Map;
/**
 * Class StoreSQL - Работа с XML. Решение задач уровня Junior. Части 003. SQL, JDBC
 * 7.4.3. XML XSLT JDBC Оптимизация.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 24.08.2019
 * @version 1
 */
public class StoreXML {
    private File target;
    /**
     * Method StoreXML. Конструктор.
     * @param target Файл для вывода.
     */
    public StoreXML(File target) {
        this.target = target;
    }
    /**
     * Method save. Метод сохранения в файл.
     * @param list Данные из БД.
     */
    public ByteArrayOutputStream save(List<Map.Entry<Integer, String>> list) throws IOException {
        ByteArrayOutputStream res;
        XmlUsage xmlUsage = new XmlUsage();
        try (FileOutputStream outputStream = new FileOutputStream(this.target)) {
            res = xmlUsage.toXML(list);
            res.writeTo(outputStream);
        }
        return res;
    }
}