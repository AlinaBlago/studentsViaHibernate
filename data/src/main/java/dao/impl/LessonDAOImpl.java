package dao.impl;

import dao.GenericDAO;
import entity.Lesson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class LessonDAOImpl implements GenericDAO {
    private final SessionFactory sessionFactory;

    public LessonDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Object lesson) {
        Session session = this.sessionFactory.openSession();
        session.save(lesson);
    }

    @Override
    public List<Lesson> findAll() {
        Session session = sessionFactory.openSession();
        return session.createQuery("from Lesson ").list();
    }

    @Override
    public Lesson findById(Integer id) {
        Session session = sessionFactory.openSession();
        return session.get(Lesson.class, id);
    }

    @Override
    public void deleteAll() {
        Session session = this.sessionFactory.openSession();
        List<Lesson> lessons = findAll();
        for (Lesson lesson : lessons) {
            session.delete(lesson);
        }
    }
}
