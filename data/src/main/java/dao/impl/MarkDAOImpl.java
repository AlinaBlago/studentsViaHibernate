package dao.impl;

import dao.GenericDAO;
import entity.Mark;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class MarkDAOImpl implements GenericDAO {

    private final SessionFactory sessionFactory;

    public MarkDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Object mark) {
        Session session = this.sessionFactory.openSession();
        session.save(mark);
    }

    @Override
    public List<Mark> findAll() {
        Session session = sessionFactory.openSession();
        return session.createQuery("from Mark ").list();
    }

    @Override
    public Mark findById(Integer id) {
        Session session = sessionFactory.openSession();
        return session.get(Mark.class, id);
    }

    @Override
    public void deleteAll() {
        Session session = this.sessionFactory.openSession();
        List<Mark> marks = findAll();
        for (Mark mark : marks) {
            session.delete(mark);
        }
    }
}
