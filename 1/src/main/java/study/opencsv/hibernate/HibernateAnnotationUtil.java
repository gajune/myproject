package study.opencsv.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import study.opencsv.model.Area;
import study.opencsv.model.City;
import study.opencsv.model.Disease;
import study.opencsv.model.DiseaseCode;

public class HibernateAnnotationUtil {
	static SessionFactory sessionFactory;
	static ServiceRegistry serviceRegistry;
	
	static{
		try{
			Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
			
			configuration.addAnnotatedClass(Area.class);
			configuration.addAnnotatedClass(City.class);
			configuration.addAnnotatedClass(Disease.class);
			configuration.addAnnotatedClass(DiseaseCode.class);

			
			
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}catch(HibernateException e){
			e.printStackTrace();
		}
	}
	
	public static SessionFactory getSessionFactory(){ 
		return sessionFactory;
	}
}
