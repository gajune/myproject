package study.opencsv;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import study.opencsv.hibernate.HibernateAnnotationUtil;
import study.opencsv.model.City;
import study.opencsv.model.Disease;
import study.opencsv.model.DiseaseCode;
import study.opencsv.model.Output;

public class Select {
	ArrayList<Output> print = new ArrayList<Output>();
	String query;
	public Select(String name, String date, String disease) {
		// TODO Auto-generated constructor stub
		query = "select d from City a, DiseaseCode b, Area c, Disease d where d.discd = b.diseasecode and d.city = a.citycode and a.areas = c.areacode and c.area = '"+name+"'" + "and b.diseasename = '"+disease+"'"+ "and d.date = '"+date+"'";
	}
	public List<Output> output() {
		Session session = null;
		SessionFactory sessionFactory = HibernateAnnotationUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		List<Disease> list = session.createQuery(query, Disease.class).getResultList();
		Iterator<Disease> iterator = list.iterator();
		while(iterator.hasNext()){
			Output output = new Output();
			Disease d = iterator.next();
			output.setCity(d.getCity().getCityname());
			output.setComfirmed(d.getComfirmd());
			output.setDate(d.getDate());
			print.add(output);
	}
		return print;
	}}
