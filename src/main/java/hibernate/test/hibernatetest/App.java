package hibernate.test.hibernatetest;

import java.util.Properties;

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
    	Properties prop = new Properties();
    	prop.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
    	prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernatetestDB");
    	prop.setProperty("hibernate.connection.username", "root");
    	prop.setProperty("hibernate.connection.password", "");
    	prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
    	prop.setProperty("hibernate.hbm2ddl.auto", "create");
    	
    	Configuration conf = new Configuration().addProperties(prop).addAnnotatedClass(UserTable.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(new UserTable());
        session.save(new UserTable());
        session.save(new UserTable());
        session.getTransaction().commit();
        session.close();
    }
}
