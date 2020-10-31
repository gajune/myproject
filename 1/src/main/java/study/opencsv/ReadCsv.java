package study.opencsv;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.opencsv.CSVReader;

import study.opencsv.hibernate.HibernateAnnotationUtil;
import study.opencsv.model.DiseaseCode;

public class ReadCsv {
	CSVReader reader;

	public void readCsv(String url) {
		try {
			reader = new CSVReader(new InputStreamReader(new FileInputStream(url), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public HashMap<Integer, DiseaseCode> setDiseasecode() {
		ArrayList<String> list = new ArrayList<String>();
		HashMap<Integer, DiseaseCode> map3 = new HashMap<Integer, DiseaseCode>();
		list.add("감기");
		list.add("눈병");
		list.add("천식");
		list.add("피부병");
		Session session = null;
		SessionFactory sessionFactory = HibernateAnnotationUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		for (int i = 0; i < 4; i++) {
			DiseaseCode dis = new DiseaseCode();
			dis.setDiseasecode(i);
			dis.setDiseasename(list.get(i));
			map3.put(dis.getDiseasecode(), dis);
			session.save(dis);
		}
		session.getTransaction().commit();
		return map3;
	}
}
