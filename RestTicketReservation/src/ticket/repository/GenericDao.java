package ticket.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class GenericDao<T, PK extends Serializable> {
    private SessionFactory sessionFactory;
    private Class<T> entityType;
    private String entityName;

    public GenericDao() {
        sessionFactory = DBConnection.getSessionFactory();
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        this.entityType = (Class) pt.getActualTypeArguments()[0];

        String name = entityType.getName();
        this.entityName = name.substring(name.lastIndexOf('.') + 1);
    }

    public void create(T t) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(t);

        session.getTransaction().commit();
        session.close();
    }

    public T read(PK id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        T t = session.get(entityType, id);

        session.getTransaction().commit();
        session.close();

        return t;
    }

    public void update(T t) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.saveOrUpdate(t);

        session.getTransaction().commit();
        session.close();
    }

    public void delete(T t) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(t);

        session.getTransaction().commit();
        session.close();
    }

    public List<T> selectAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String queryString = "from " + entityName;
        Query query = session.createQuery(queryString);
        List list = query.list();

        session.getTransaction().commit();
        session.close();

        return list;
    }

}
