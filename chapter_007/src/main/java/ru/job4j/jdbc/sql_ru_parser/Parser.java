package ru.job4j.jdbc.sql_ru_parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Class Parser - Разбор страницы сайта. Решение задач уровня Junior. Части 003. SQL, JDBC
 * 7.5.2. Парсер вакансий на sql.ru.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 16.09.2019
 * @version 1
 */
public class Parser {
    private static final Logger LOG = LogManager.getLogger(Parser.class.getName());
    /**
     * Method getVacancyFromSite. Получение текущих вакансий с сайта.
     * @return Коллеция вакансий
     */
    public ArrayList<Vacancy> getVacancyFromSite() {
        ArrayList<Vacancy> res = new ArrayList<>();
        try {
            Document document = Jsoup.connect("http://www.sql.ru/forum/job-offers").get();
            Elements elements = document.select("td.postslisttopic:contains(java)");
            for (Element element : elements) {
                String name = element.select("a:contains(java)").text();
                if (!name.replaceAll(" ", "").toUpperCase().contains("JAVASCRIPT")) {
                    String url = element.select("a").attr("href");
                    LOG.debug("name={}", name);
                    LOG.debug("url={}", url);
                    Document href = Jsoup.connect(url).get();
                    Elements hrefElements = href.select("td.msgBody");
                    LOG.debug("text={}", hrefElements.text());
                    res.add(new Vacancy(name, hrefElements.text(), url));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOG.debug("getVacancyFromSite res size={}", res.size());
        return res;
    }
    /**
     * Method saveToDB. Сохранение в БД.
     * @param storeDB БД.
     */
    public void saveToDB(StoreDB storeDB) {
        for(Vacancy v : getVacancyFromSite()) {
            storeDB.add(v);
        }
    }
}