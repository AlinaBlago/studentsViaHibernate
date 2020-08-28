import dao.GenericDAO;
import dao.impl.GroupDAOImpl;
import dao.impl.LessonDAOImpl;
import dao.impl.StudentDAOImpl;
import dao.impl.TeacherDAOImpl;
import entity.Group;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure();
        try (SessionFactory sessionFactory = cfg.buildSessionFactory();
        ) {
          //  GenericDAO group = new GroupDAOImpl(sessionFactory);
          //  group.create(new Group("HTML1"));

//            StudentDAOImpl lessonTest = new StudentDAOImpl(sessionFactory);
//            lessonTest.nearStudentLessonById(2L);

            TeacherDAOImpl teacherDAO = new TeacherDAOImpl(sessionFactory);
            teacherDAO.moreTeacherSuccessfulGroupById(1L);


//            Group group = new Group();
//            group.setValue("Number 3333");

//            Course course = new Course();
//            course.setValue("Java123");
//
//
//            //CourseDAO courseDAO = new CourseDAOImpl(sessionFactory);
//            //List<Course> courses = courseDAO.findAll();
//
//
//            //GroupDAO groupDAO = new GroupDAOImpl(sessionFactory);
//            //List<Group> groups = groupDAO.findAll();
//
//
//            Factory.getInstance().getStudentDAO().addStudent(group);
//            Factory.getInstance().getStudentDAO().addStudent(course);
//            Student student1 = new Student("Alina", "Bl", group, course);
//            Factory.getInstance().getStudentDAO().addStudent(student1);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}






//                session.getTransaction().commit();
//            } catch (Exception e) {
//                session.getTransaction().rollback();
//            }

//            ent.persist(student);
//            ent.getTransaction().commit();
//        } catch (Exception e) {
//            ent.getTransaction().rollback();
//        }
//    }

