package dao.impl;

import dao.GenericDAO;
import entity.Theme;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ThemeDAOImpl implements GenericDAO {

    private final SessionFactory sessionFactory;

    public ThemeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Object theme) {
        Session session = this.sessionFactory.openSession();
        session.save(theme);
    }

    @Override
    public List<Theme> findAll() {
        Session session = sessionFactory.openSession();
        return session.createQuery("from Theme ").list();
    }

    @Override
    public Theme findById(Integer id) {
        Session session = sessionFactory.openSession();
        return session.get(Theme.class, id);
    }

    @Override
    public void deleteAll() {
        Session session = this.sessionFactory.openSession();
        List<Theme> themes = findAll();
        for (Theme theme : themes) {
            session.delete(theme);
        }
    }
}
