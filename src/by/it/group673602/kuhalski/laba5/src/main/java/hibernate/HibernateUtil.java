package by.it.group673602.kuhalski.laba5.src.main.java.hibernate;


public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration cfg = new Configuration().configure("META-INF/hibernate.cfg.xml");
            cfg.addAnnotatedClass(Person.class);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(cfg.getProperties());
            sessionFactory = cfg.buildSessionFactory(builder.build());
        }
        catch (Throwable ex){
            System.err.println("Initial SessionFactory creation failed" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

}
