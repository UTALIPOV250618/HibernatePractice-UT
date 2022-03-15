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
        User user = new User("Ulukmyrza",30);
        create(user);

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

}
