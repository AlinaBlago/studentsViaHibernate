import dao.impl.StudentDAOImpl;
import dao.impl.TeacherDAOImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure();
        try (SessionFactory sessionFactory = cfg.buildSessionFactory();
        ) {


            StudentDAOImpl lessonTest = new StudentDAOImpl(sessionFactory);
            lessonTest.nearStudentLessonById(1L);

            TeacherDAOImpl teacherDAO = new TeacherDAOImpl(sessionFactory);
            teacherDAO.getTopGroupOfTeacherId(1L);

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

