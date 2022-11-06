package cloudxweb;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ClientApp {

	public static void main(String[] args) {
	SessionFactory sf=null;
	Session session=null;
	try
	{
		Configuration cfg=new Configuration();
		cfg.configure("cloudxweb/hibernate.cfg.xml");
		
		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
		builder=builder.applySettings(cfg.getProperties());
		
		StandardServiceRegistry reg=builder.build();
		sf=cfg.buildSessionFactory(reg);
		session=sf.openSession();
		Transaction tx=session.beginTransaction();
		
		Course c1=new Course();
		c1.setCid("C-111");
		c1.setCname("java");
		c1.setCcost("12000");
		
		Course c2=new Course();
		c2.setCid("C-112");
		c2.setCname("java Framework");
		c2.setCcost("14000");
		
		Course c3=new Course();
		c3.setCid("C-113");
		c3.setCname("Hibernate");
		c3.setCcost("15000");
		
		Set<Course> cs=new HashSet<Course>();
		cs.add(c1);
		cs.add(c2);
		cs.add(c3);
		
		Student s1=new Student();
		s1.setSid("S-222");
		s1.setSname("rana");
		s1.setSaddr("delhi");
		s1.setCourses(cs);
		
		Student s2=new Student();
		s2.setSid("S-223");
		s2.setSname("Usman");
		s2.setSaddr("delhi");
		s2.setCourses(cs);
		
		Student s3=new Student();
		s3.setSid("S-224");
		s3.setSname("aish");
		s3.setSaddr("noida");
		s3.setCourses(cs);
		
		session.save(s1);
		session.save(s2);
		session.save(s3);
		
		tx.commit();
		
		System.out.println("Student record Inserted");
		
		
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

	}

}
