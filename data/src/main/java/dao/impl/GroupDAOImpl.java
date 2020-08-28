package dao.impl;

import dao.GenericDAO;
import entity.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class GroupDAOImpl implements GenericDAO {

    private final SessionFactory sessionFactory;

    public GroupDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Object group) {
        Session session = this.sessionFactory.openSession();
        session.save(group);
    }

    @Override
    public List<Group> findAll() {
        Session session = sessionFactory.openSession();
        return session.createQuery("from Group ").list();
    }

    @Override
    public Group findById(Integer id) {
        Session session = sessionFactory.openSession();
        return session.get(Group.class, id);
    }

    @Override
    public void deleteAll() {
        Session session = this.sessionFactory.openSession();
        List<Group> groups = findAll();
        for (Group group : groups) {
            session.delete(group);
        }
    }
}
