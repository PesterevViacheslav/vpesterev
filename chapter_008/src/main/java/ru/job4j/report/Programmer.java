package ru.job4j.report;
import java.util.function.Predicate;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import static com.google.common.base.Strings.isNullOrEmpty;
/**
 * Class Programmer - Подразделение - программисты. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 16.03.2020
 * @version 1
 */
public class Programmer implements Print {
    /**
     * Method print. Формирование строки для печати
     * @param store Хранилище
     * @param filter Фильтр
     * @return Строка для печати
     */
    @Override
    public String print(Store store, Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary");
        for (Employer employer : store.findBy(filter)) {
            text.append(employer.getName()).append(";")
                    .append(employer.getHired()).append(";")
                    .append(employer.getFired()).append(";")
                    .append(employer.getSalary()).append(";");
        }
        return Utils.toHtml(text.toString());
    }
    /**
     * Утилиты для HTML
     */
    private static class Utils {
        public static String toHtml(String string) {
            if (isNullOrEmpty(string)) {
                return "<html><body></body></html>";
            }
            BufferedReader st = new BufferedReader(new StringReader(string));
            StringBuffer buf = new StringBuffer("<html><body>");
            try {
                String str = st.readLine();
                while (str != null) {
                    if (str.equalsIgnoreCase("<br/>")) {
                        str = "<br>";
                    }
                    buf.append(str);
                    if (!str.equalsIgnoreCase("<br>")) {
                        buf.append("<br>");
                    }
                    str = st.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            buf.append("</body></html>");
            string = buf.toString();
            return string;
        }
    }
}