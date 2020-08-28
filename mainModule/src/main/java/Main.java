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

            StudentDAOImpl lessonTest = new StudentDAOImpl(sessionFactory);
            lessonTest.nearStudentLessonById(2L);

//            TeacherDAOImpl teacherDAO = new TeacherDAOImpl(sessionFactory);
//            teacherDAO.moreTeacherSuccessfulGroupById(1L);

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

