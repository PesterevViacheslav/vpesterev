package ru.job4j.jdbc.sqllite;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
/**
 * Class ParserXML - Разбор XML. Решение задач уровня Junior. Части 003. SQL, JDBC
 * 7.4.3. XML XSLT JDBC Оптимизация.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 24.08.2019
 * @version 1
 */
public class ParserXML {
    private final File file;
    /**
     * Method ParserXML. Конструктор.
     */
    public ParserXML(File file) {
        this.file = file;
    }
    /**
     * Method sumFields. Сумма элементов.
     * @return Сумма
     */
    public int sumFields() {
        int res = 0;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(this.file);
            NodeList nodeList = document.getElementsByTagName("entry");
            for (int x = 0, size = nodeList.getLength(); x < size; x++) {
                res += Integer.valueOf(nodeList.item(x).getAttributes().getNamedItem("field").getNodeValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new XmlException(e.getMessage());
        }
        return res;
    }
}
