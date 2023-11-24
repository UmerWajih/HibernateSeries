package hibernate.test.hibernatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration conf = new Configuration().configure().addAnnotatedClass(UserTable.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(new UserTable());
        session.getTransaction().commit();
        session.close();
    }
}
