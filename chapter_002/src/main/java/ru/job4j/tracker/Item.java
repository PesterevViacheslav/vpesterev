package ru.job4j.tracker;
import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Objects;

@Entity
@Table(name = "item")
/**
 * Class Item - Заявка. Решение задачи Части 002. ООП. Общая задача на второй модуль.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 25.04.2018
 * @version 1
 */
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "item_name")
    private String name;
    @Column(name = "item_description")
    private String description;
    private Timestamp created;
    //private long changed;
    /**
     * Method Item. Конструктор по умолчанию.
     */
    public Item() {
    }
    /**
     * Method Item. Конструктор.
     * @param name Названия заявки.
     * @param description Описание заявки.
     */
    public Item(String name, String description, Timestamp created) {
        this.id = generateId();
        this.name = name;
        this.description = description;
        this.created = created;
        //this.created = System.currentTimeMillis();
    }
    /**
     * Method Item. Конструктор.
     * @param id ID заявки.
     * @param name Названия заявки.
     * @param description Описание заявки.
     */
    public Item(int id, String name, String description, Timestamp created) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created = created;
        //this.changed = changed;
    }
    private int generateId() {
        return (int) Math.round(Math.random() * 1000); //SimpleDateFormat("ddMMyyyyHHmmss").format(System.currentTimeMillis()) + "_" + Math.round(Math.random() * 1000);
    }
    /**
     * Method getId. Получить значение ID заявки.
     */
    public int getId() {
        return this.id;
    }
    /**
     * Method getId. Получить значение ID заявки.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Method getName. Получить значение Названия заявки.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Method setName. Установить значение Названия заявки.
     * @param name Названия заявки.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Method getDescription. Получить значение Описания заявки.
     */
    public String getDescription() {
        return this.description;
    }
    /**
     * Method setDescription. Установить значение Описания заявки.
     * @param description Названия заявки.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Method getCreated. Получить значение Даты создания заявки.
     */
    public Timestamp getCreated() {
        return this.created;
    }
    public void setCreated(Timestamp created) {
        this.created = created;
    }
    /**
     * Method getChanged. Получить значение Даты изменения заявки.
     */
/*
    public long getChanged() {
        return this.changed;
    }
*/
    /**
     * Method setChanged. Установить значение Даты изменения заявки.
     * @param changed Названия заявки.
     */
/*
    public void setChanged(long changed) {
        this.changed = changed;
    }
*/
    /**
     * Method equals. Переопределенный.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(name, item.name) && Objects.equals(description, item.description) && Objects.equals(id, item.id);
    }
    /**
     * Method hashCode. Переопределенный.
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    /**
     * Method toString. Переопределенный.
     */
    @Override
    public String toString() {
        return "Item{"
                + "id='" + id + '\''
                + ", name='" + name + '\''
                + ", description='" + description + '\''
                + ", created=" + created + '\''
                //+ ", changed=" + changed
                + '}';
    }
}