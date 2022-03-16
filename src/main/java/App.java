import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.models.User;

import peaksoft.utils.Util;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args )
    {
      Util.getSession();
//        User user = new User("Kanat",30);
//        create(user);
//        for (User user:getAllUsers()
//             ) {
//            System.out.println(user);
//        }

        System.out.println( getUserById(3));


    }

 public static int create(User user){

     Session session = Util.getSession().openSession();
     session.beginTransaction();
     session.save(user);
     session.getTransaction().commit();
     session.close();
     System.out.println("Successfully added: "+ user);
     return user.getId();
 }

 public static User getUserById(int id){

        Session session = Util.getSession().openSession();
        session.beginTransaction();
        User user = session.get(User.class,id);
        session.getTransaction().commit();
        session.close();
        return user;

 }
 public static List<User> getAllUsers(){
        Session session =  Util.getSession().openSession();
        session.beginTransaction();
         List<User> users = session.createQuery("FROM User ").getResultList();
         session.getTransaction().commit();
         session.close();
         return users;
 }

}
