package ru.job4j.jdbc.sqllite;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
/**
 * Class ConvertXSLT - Конвертация с помощью XSLT. Решение задач уровня Junior. Части 003. SQL, JDBC
 * 7.4.3. XML XSLT JDBC Оптимизация.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 24.08.2019
 * @version 1
 */
public class ConvertXSLT {
    private ByteArrayOutputStream baos;
    private File file;

    /**
     * Method ConvertXSLT. Конструктор.
     */
    public ConvertXSLT(ByteArrayOutputStream baos, File file) {
        this.baos = baos;
        this.file = file;
    }
    /**
     * Method convert. Конвертация XML.
     * @return Сконвертированный XML
     */
    public ByteArrayOutputStream convert() throws TransformerException, IOException {
        ByteArrayOutputStream res = new ByteArrayOutputStream();
        String xsl = "<?xml version=\"1.0\"?>\n"
                + "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">\n"
                + "<xsl:template match=\"/\">\n"
                + "<entries>"
                + "   <xsl:for-each select=\"entries/entry\">\n"
                + "       <entry>"
                + "           <xsl:attribute name=\"field\">"
                + "               <xsl:value-of select=\"field\"/>"
                + "           </xsl:attribute>"
                + "       </entry>\n"
                + "   </xsl:for-each>\n"
                + " </entries>\n"
                + "</xsl:template>\n"
                + "</xsl:stylesheet>\n";
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(new StreamSource(new ByteArrayInputStream(xsl.getBytes())));
        transformer.transform(new StreamSource(new ByteArrayInputStream(this.baos.toByteArray())), new StreamResult(/*System.out*/res));
        try (FileOutputStream outputStream = new FileOutputStream(this.file)) {
            res.writeTo(outputStream);
        }
        return res;
    }
}
