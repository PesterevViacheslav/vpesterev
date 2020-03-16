package ru.job4j;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import ru.job4j.report.*;
import java.util.Calendar;
/**
 * Class ReportEngineTest - Автотест Отчеты. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 16.03.2020
 * @version 1
 */
public class ReportEngineTest {
    /**
     * Тест отчета - формат по умолчанию.
     */
    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";");
        assertThat(engine.generate(em -> true, new ReportDepartment("user")), is(expect.toString()));
    }
    /**
     * Тест отчета - формат для программистов.
     */
    @Test
    public void whenProgrammerGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("<html><body>")
                .append("Name; Hired; Fired; Salary")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append("<br></body></html>");
        assertThat(engine.generate(em -> true, new Programmer("user")), is(expect.toString()));
    }
    /**
     * Тест отчета - формат для HR.
     */
    @Test
    public void whenHRGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        Employer worker2 = new Employer("Ivan2", now, now, 10);
        store.add(worker2);
        Employer worker3 = new Employer("Ivan3", now, now, 500);
        store.add(worker3);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary")
                .append(worker3.getName()).append(";")
                .append(worker3.getSalary()).append(";")
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";")
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";");

        assertThat(engine.generate(em -> true, new HR("user")), is(expect.toString()));
    }
    /**
     * Тест отчета - формат для бухгалтерии.
     */
    @Test
    public void whenAccountantGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(String.format("%.2f", worker.getSalary())).append(";");
        assertThat(engine.generate(em -> true, new Accountant("user")), is(expect.toString()));
    }
}