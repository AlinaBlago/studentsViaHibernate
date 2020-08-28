package dao.impl;

import dao.GenericDAO;
import entity.Course;
import entity.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

public class CourseDAOImpl implements GenericDAO {

    private final SessionFactory sessionFactory;

    public CourseDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void create(Object course) {
        Session session = this.sessionFactory.openSession();
        session.save(course);
    }

    @Override
    public List<Course> findAll() {
        Session session = sessionFactory.openSession();
        return session.createQuery("from Course ").list();
    }

    @Override
    public Object findById(Integer id) {
        Session session = sessionFactory.openSession();
        return session.get(Group.class, id);
    }

    @Override
    public void deleteAll() {
        Session session = this.sessionFactory.openSession();
        List<Course> courses = findAll();
        for (Course course : courses) {
            session.delete(course);
        }
    }
}
