package dao.impl;

import dao.GenericDAO;
import entity.Lesson;
import entity.Student;
import entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

public class StudentDAOImpl implements GenericDAO {

    private final SessionFactory sessionFactory;

    public StudentDAOImpl(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Object student) {
        Session session = this.sessionFactory.openSession();
        session.save(student);
    }

    @Override
    @Transactional
    public List<Student> findAll() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Student ").list();
    }

    @Override
    public Object findById(Integer id) {
        Session session = sessionFactory.openSession();
        return session.get(Student.class, id);
    }

    @Override
    public void deleteAll() {
        Session session = this.sessionFactory.openSession();
        List<Student> students = findAll();
        for (Student student : students) {
            session.delete(student);
        }
    }

    public void nearStudentLessonById(Long id ) throws Exception {
        if(id < 1) throw new Exception("Id cannont be smaller than 1");

        Session session = sessionFactory.openSession();

        Query queryStudentInfo = session.createSQLQuery("Select * from students where id = :studentID");
        queryStudentInfo.setParameter("studentID" , id);
        List students = queryStudentInfo.list();

        Object[] studentProps = ((Object[])students.get(0));

        int idGroup = (int) studentProps[4];
        Arrays.stream(studentProps).forEach(System.out::println);

        Query query = session.createSQLQuery("select * from lessons where id_group = :idParam and date >= CURRENT_DATE order by date , \"startTime\" asc  LIMIT 1");
        query.setParameter("idParam" , idGroup);

        List lessons = query.list();

        Object[] props = ((Object[]) lessons.get(0));

        java.sql.Time time = (java.sql.Time) props[2];
        java.sql.Date date = (java.sql.Date) props[5];

        int theme_id = (int) props[4];
        int teacherId = (int)props[6];

        Query queryTeacherInfp = session.createSQLQuery("select * from teachers where id = :teacherID");
        queryTeacherInfp.setParameter("teacherID" , teacherId);
        List teachers = queryTeacherInfp.list();

        Object[] teacherProps = ((Object[]) teachers.get(0));
        String teacherName = (String) teacherProps[1];
        String teacherSurname = (String) teacherProps[2];

        Query queryThemeInfo = session.createSQLQuery("select * from themes where id = :themeId");
        queryThemeInfo.setParameter("themeId" , theme_id);
        List themes = queryThemeInfo.list();

        Object[] themeProps = ((Object[]) themes.get(0));
        String themeName = (String)themeProps[1];

        System.out.println("Time : " + time.toString());
        System.out.println("Date : " + date.toString());
        System.out.println("Teacher : " + teacherName + " " + teacherSurname);
        System.out.println("Theme : " + themeName);
    }

}

