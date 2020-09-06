package dao.impl;

import dao.GenericDAO;
import entity.Teacher;
import javassist.compiler.ast.Pair;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.Tuple;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Stream;

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

    public void getTopGroupOfTeacherId(Long id) throws Exception {
        if(id < 1) throw new Exception("Id cannont be smaller than 1");

        Session session = sessionFactory.openSession();

        Query queryLessonInfo = session.createSQLQuery("select id from lessons " +
                "where id_theme = (select id from themes where value = 'Exam') and " +
                "      id_teacher =:teacherID");
        queryLessonInfo.setParameter("teacherID" , id);
        List lessons = queryLessonInfo.getResultList();

        List<Integer> lessonsIDs = new ArrayList<>();

        for(Object item : lessons){
            lessonsIDs.add((Integer)item);
        }


        Map<Integer , BigDecimal> lessonsAndMedians = new HashMap<>();

        for(Integer lessonId : lessonsIDs){

            Query queryMedian = session.createSQLQuery("SELECT median(mark.value ) AS median_value " +
                    "FROM (select * from marks where id_lesson = :lessonId ORDER BY value ) as mark");
            queryMedian.setParameter("lessonId" , lessonId);

            List median = queryMedian.getResultList();


            if(median.get(0) != null) {
                BigDecimal bgMedian = (BigDecimal)median.get(0);
                lessonsAndMedians.put(lessonId, bgMedian);
            }




        }

        Optional<Map.Entry<Integer, BigDecimal>> maxEntry = lessonsAndMedians.entrySet()
                .stream()
                .max((Map.Entry<Integer, BigDecimal> e1, Map.Entry<Integer, BigDecimal> e2) -> e1.getValue()
                        .compareTo(e2.getValue())
                );

        if(maxEntry != null){
            Integer maxLessonId = maxEntry.get().getKey();

            Query queryIdGroup = session.createSQLQuery("select  id_group from lessons  where lessons.id = :lessonID");
            queryIdGroup.setParameter("lessonID", maxLessonId);
            List idGroupResultList = queryIdGroup.getResultList();
            int idGroup = (int) idGroupResultList.get(0);

            Query queryValueGroup = session.createSQLQuery("select value from groups where id = :groupID");
            queryValueGroup.setParameter("groupID", idGroup);
            List idValueResultList = queryValueGroup.getResultList();
            idValueResultList.stream().forEach(System.out::println);


            Query gueryIdCourse = session.createSQLQuery("select id_course from students where id_group = :groupID");
            gueryIdCourse.setParameter("groupID", idGroup);
            List idCourseResultList = gueryIdCourse.getResultList();
            Integer idCourse = (Integer) idCourseResultList.get(0);

            Query queryValueCourse = session.createSQLQuery("select value from courses where id = :courseID");
            queryValueCourse.setParameter("courseID", idCourse);
            List valueCourseResultList = queryValueCourse.getResultList();
            valueCourseResultList.stream().forEach(System.out::println);

        }

    }
}
