package ru.job4j.profession;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class ProfessionTest Автотесты для задач Части 002. ООП урок 2.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 18.04.2018
 * @version 1
 */
public class ProfessionTest {
    /**
     * Тест методов суперкласса и подклассов.
     */
    @Test
    public void checkGettersSuperClassAndChildClasses() {
        Profession profession = new Profession("Профессия", "Тест");
        assertThat("Профессия", is(profession.getName()));
        assertThat("Тест", is(profession.getProfession()));
        Doctor doctor = new Doctor("Иванов");
        assertThat("Иванов", is(doctor.getName()));
        assertThat("Доктор", is(doctor.getProfession()));
        Engineer engineer = new Engineer("Петров");
        assertThat("Петров", is(engineer.getName()));
        assertThat("Инженер", is(engineer.getProfession()));
        Teacher teacher = new Teacher("Сидоров");
        assertThat("Сидоров", is(teacher.getName()));
        assertThat("Учитель", is(teacher.getProfession()));
    }
    /**
     * Тест методов вспомогательных классов.
     */
    @Test
    public void checkGettersAuxiliaryClasses() {
        assertThat("Пациент", is(new Patient("Пациент").getName()));
        assertThat("Студент", is(new Student("Студент").getName()));
        assertThat("Дом", is(new Building("Дом").getKind()));
    }
}
