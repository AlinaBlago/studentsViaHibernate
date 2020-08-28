package dao.impl;

import dao.GenericDAO;
import entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class TeacherDAOImpl implements GenericDAO {

    private final SessionFactory sessionFactory;

    public TeacherDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Object teacher) {
        Session session = this.sessionFactory.openSession();
        session.save(teacher);
    }

    @Override
    public List<Teacher> findAll() {
        Session session = sessionFactory.openSession();
        return session.createQuery("from Teacher ").list();
    }

    @Override
    public Teacher findById(Integer id) {
        Session session = sessionFactory.openSession();
        return session.get(Teacher.class, id);
    }

    @Override
    public void deleteAll() {
        Session session = this.sessionFactory.openSession();
        List<Teacher> teachers = findAll();
        for (Teacher teacher : teachers) {
            session.delete(teacher);
        }
    }

    public void moreTeacherSuccessfulGroupById(Long id) throws Exception {
        if(id < 1) throw new Exception("Id cannont be smaller than 1");

        Session session = sessionFactory.openSession();

        Query queryTeacherInfo = session.createSQLQuery("Select * from teachers where id = :teacherID");
        queryTeacherInfo.setParameter("teacherID" , id);
//        List teachers = queryTeacherInfo.list();
//
//        Object[] teacherProps = ((Object[])teachers.get(0));

        Query queryLessonInfo = session.createSQLQuery("SELECT * from lessons where id_teacher =: teacherID ");
       List lessons = queryLessonInfo.list();

        Object[] lessonProps = ((Object[])lessons.get(0));

    }
}
