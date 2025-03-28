package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(25) NOT NULL, " +
                    "lastname VARCHAR(50) NOT NULL, " +
                    "age INT(3) NOT NULL)").executeUpdate();
        } catch (HibernateException e) {
            throw new RuntimeException("Ошибка при создании таблицы", e);
        }
    }

    @Override
    public void dropUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS users").executeUpdate();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new RuntimeException("Ошибка при удалении таблицы", e);
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction tx = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(new User(name, lastName, age));
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                try {
                    tx.rollback();
                } catch (TransactionException ex) {
                    throw new RuntimeException("Ошибка при попытке откатить добавление пользователя", e);
                }
            }
            throw new HibernateException("Ошибка при попытке добавить пользователя" + e);
        }
    }

    @Override
    public void removeUserById(long id) {
        Transaction tx = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.createQuery("delete User where id=:id").setParameter("id", id).executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                try {
                    tx.rollback();
                } catch (TransactionException ex) {
                    throw new RuntimeException("Ошибка при попытке откатить удаление пользователя", e);
                }
            }
            throw new HibernateException("Ошибка при попытке удалить пользователя" + e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            List<User> users = session.createQuery("from User").getResultList();
            for (User user : users) {
                System.out.println(user);
            }
            return users;
        } catch (HibernateException e) {
            throw new HibernateException("Ошибка при попытке получить пользователей из таблицы" + e);
        }
    }

    @Override
    public void cleanUsersTable() {
        Transaction tx = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.createSQLQuery("DELETE FROM users").executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                try {
                    tx.rollback();
                } catch (TransactionException e1) {
                    throw new RuntimeException("Ошибка при попытке откатить очистку таблицы пользователей", e);
                }
            }
            throw new RuntimeException("Ошибка при попытке очистить таблицу пользователей", e);
        }
    }
}
