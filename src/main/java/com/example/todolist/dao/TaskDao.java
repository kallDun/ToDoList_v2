package com.example.todolist;

import com.example.todolist.models.Task;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class TaskDao {

    public Task findById(int id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Task.class, id);
    }

    public void save(Task task) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(task);
        tx1.commit();
        session.close();
    }

    public void update(Task task) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(task);
        tx1.commit();
        session.close();
    }

    public void delete(Task task) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(task);
        tx1.commit();
        session.close();
    }

    public List<Task> findAll() {
        List<Task> users = (List<Task>) HibernateSessionFactory.getSessionFactory().openSession().createQuery("From Task").list();
        return users;
    }
}