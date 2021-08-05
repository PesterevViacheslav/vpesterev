package ru.job4j.hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Item;
import java.util.ArrayList;

public class TrackerHbm implements ITracker, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();
    /**
     * Method add. Добавление заявки.
     * @param item Заявка.
     * @return Заявка
     */
    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }
    /**
     * Method delete. Удаление заявки.
     * @param id ID заявки.
     * @return Признак удалена ли заявка
     */
    @Override
    public boolean delete(int id) {
        boolean res = false;
        Session session = sf.openSession();
        session.beginTransaction();
        Item item = session.get(Item.class, id);
        if (item != null) {
            session.delete(item);
            res = true;
        }
        session.getTransaction().commit();
        session.close();
        return res;
    }
    /**
     * Method replace. Замена заявки.
     * @param id ID заявки.
     * @param item Заявка.
     * @return Признак найдена ли заявка
     */
    @Override
    public boolean replace(int id, Item item) {
        boolean res = false;
        Session session = sf.openSession();
        session.beginTransaction();
        Item itm = findById(id);
        if (itm != null) {
            session.delete(itm);
            session.save(item);
            res = true;
        }
        session.getTransaction().commit();
        session.close();
        return res;
    }
    /**
     * Method findAll. Получение списка текущих заявок.
     * @return Заявки.
     */
    @Override
    public ArrayList<Item> findAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        ArrayList<Item> res = (ArrayList<Item>) session.createQuery("from ru.job4j.tracker.Item").list();
        session.getTransaction().commit();
        session.close();
        return res;
    }
    /**
     * Method findByName. Поиск заявки по NAME.
     * @param key ID заявки.
     * @return Заявка
     */
    @Override
    public ArrayList<Item> findByName(String key) {
        Session session = sf.openSession();
        session.beginTransaction();
        String hql = "from ru.job4j.tracker.Item where name like :paramName";
        Query query = session.createQuery(hql);
        query.setParameter("paramName", key);
        ArrayList<Item> res = (ArrayList<Item>) query.list();
        session.getTransaction().commit();
        session.close();
        return res;
    }
    /**
     * Method findById. Поиск заявки по ID.
     * @param id ID заявки.
     * @return Заявка
     */
    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item result = session.get(Item.class, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }
    /**
     * Method change. Изменение заявки.
     * @param id ID заявки.
     * @param item Заявка.
     * @return Признак найдена ли заявка
     */
    @Override
    public boolean change(int id, Item item) {
        boolean res = false;
        Session session = sf.openSession();
        session.beginTransaction();
        Item itm = findById(id);
        if (itm != null) {
            itm.setName(item.getName());
            itm.setDescription(item.getDescription());
            session.update(itm);
            res = true;
        }
        session.getTransaction().commit();
        session.close();
        return res;
    }
    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}