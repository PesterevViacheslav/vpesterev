package ru.job4j.inout;
import java.io.File;
import java.util.ArrayList;
<<<<<<< HEAD
<<<<<<< HEAD
import java.util.Arrays;

=======
>>>>>>> 7f1c972... Junior. Части 002. Ввод-Вывод. 6.1.4. Архивировать проект.  [#861]
=======
import java.util.Arrays;

>>>>>>> 02a8c5c... Junior. Части 002. Ввод-Вывод. 6.1.4. Архивировать проект.  [#861] (Доработка)
/**
 * Class Args - Аргументы для метода архивации. Решение задач уровня Junior. Части 002. Ввод-Вывод.
 * 6.1.4. Архивировать проект.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 22.03.2019
 * @version 1
 */
public class Args {
    private String directory;
    private ArrayList<String> exclude;
    private String output;

    /**
     * Method Args. Конструктор.
     *
     * @param directory Директория которую нужно архивировать.
     * @param exclude   Исклчаемые расширения.
     * @param output    Директория размещения архива.
     */
    public Args(String directory, ArrayList<String> exclude, String output) {
        this.directory = directory;
        this.exclude = exclude;
        this.output = output;
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> 7f1c972... Junior. Части 002. Ввод-Вывод. 6.1.4. Архивировать проект.  [#861]
=======
>>>>>>> 02a8c5c... Junior. Части 002. Ввод-Вывод. 6.1.4. Архивировать проект.  [#861] (Доработка)
    /**
     * Method directory. Получение директории которую нужно архивировать.
     *
     * @return Файл.
     */
    public File directory() {
<<<<<<< HEAD
<<<<<<< HEAD
        return new File(this.directory);
    }
=======
        File file = new File(this.directory);
        return file;
    }

>>>>>>> 7f1c972... Junior. Части 002. Ввод-Вывод. 6.1.4. Архивировать проект.  [#861]
=======
        return new File(this.directory);
    }
>>>>>>> 02a8c5c... Junior. Части 002. Ввод-Вывод. 6.1.4. Архивировать проект.  [#861] (Доработка)
    /**
     * Method exclude. Получение коллекции исключаемых расширений.
     *
     * @return Список.
     */
    public ArrayList<String> exclude() {
        return this.exclude;
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> 7f1c972... Junior. Части 002. Ввод-Вывод. 6.1.4. Архивировать проект.  [#861]
=======
>>>>>>> 02a8c5c... Junior. Части 002. Ввод-Вывод. 6.1.4. Архивировать проект.  [#861] (Доработка)
    /**
     * Method output. Получение директории для размещения архива.
     *
     * @return Файл.
     */
    public File output() {
<<<<<<< HEAD
<<<<<<< HEAD
        return new File(this.output);
    }
    @Override
    public String toString() {
        return String.join("", "Args{", "directory=", directory, ", exclude=", exclude.toString(), ", output=", output, "}");
=======
        File file = new File(this.output);
        return file;
=======
        return new File(this.output);
>>>>>>> 02a8c5c... Junior. Части 002. Ввод-Вывод. 6.1.4. Архивировать проект.  [#861] (Доработка)
    }
    @Override
    public String toString() {
<<<<<<< HEAD
        return "Args{" + "directory='" + directory + '\'' + ", exclude=" + exclude + ", output='" + output + '\'' + '}';
>>>>>>> 7f1c972... Junior. Части 002. Ввод-Вывод. 6.1.4. Архивировать проект.  [#861]
=======
        return String.join("","Args{", "directory=", directory, ", exclude=", exclude.toString(), ", output=", output, "}");
>>>>>>> 02a8c5c... Junior. Части 002. Ввод-Вывод. 6.1.4. Архивировать проект.  [#861] (Доработка)
    }
}