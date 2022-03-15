import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.models.User;
import peaksoft.utils.HibernateSessionFactoryUtil;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args )
    {
//        HibernateSessionFactoryUtil.getSessionFactory();
//        User user = new User("Nurlan",30);
//        create(user);
        System.out.println(getUserById(3));


    }

 public static int create(User user){

     Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
     session.beginTransaction();
     session.save(user);
     session.getTransaction().commit();
     session.close();
     System.out.println("Successfully added: "+ user);
     return user.getId();
 }

 public static User getUserById(int id){

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User user = session.get(User.class,id);
        session.getTransaction().commit();
        session.close();
        return user;

 }

}
