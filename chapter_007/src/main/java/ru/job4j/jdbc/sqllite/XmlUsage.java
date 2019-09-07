package ru.job4j.jdbc.sqllite;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * Class XmlUsage - Генерация XML. Решение задач уровня Junior. Части 003. SQL, JDBC
 * 7.4.3. XML XSLT JDBC Оптимизация.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 24.08.2019
 * @version 1
 */
public class XmlUsage {
    @XmlRootElement
    public static class Entries {
        private List<Field> values;
        /**
         * Method Entries. Конструктор.
         */
        public Entries() {
        }
        /**
         * Method Entries. Конструктор.
         */
        public Entries(List<Field> values) {
            this.values = values;
        }
        /**
         * Method getEntry. Получение значения Entry.
         * @return Значение.
         */
        public List<Field> getEntry() {
            return values;
        }
        /**
         * Method setEntry. Установка значения Entry.
         * @param values Значение.
         */
        public void setEntry(List<Field> values) {
            this.values = values;
        }
    }
    @XmlRootElement
    public static class Field {
        private int value;
        /**
         * Method Field. Конструктор.
         */
        public Field() {
        }
        /**
         * Method Field. Конструктор.
         */
        public Field(int value) {
            this.value = value;
        }
        /**
         * Method getField. Получение значения Field.
         * @return Значение.
         */
        public int getField() {
            return value;
        }
        /**
         * Method setField. Установка значения Field.
         * @param value Значение.
         */
        public void setField(int value) {
            this.value = value;
        }
    }
    /**
     * Method toXML. Преобразование коллекциив XML формат.
     * @param list Коллекция.
     * @return Выходной поток.
     */
    public ByteArrayOutputStream toXML(List<Map.Entry<Integer, String>> list) {
        ByteArrayOutputStream res = new ByteArrayOutputStream();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            List<Field> fields = new ArrayList<>();
            for (Map.Entry<Integer, String> field : list) {
                fields.add(new Field(field.getKey()));
            }
            Entries entries = new Entries(fields);
            jaxbMarshaller.marshal(entries, res);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new XmlException(e.getErrorCode());
        }
        return res;
    }
}