package study.opencsv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.opencsv.exceptions.CsvValidationException;

import study.opencsv.hibernate.HibernateAnnotationUtil;
import study.opencsv.model.Area;
import study.opencsv.model.City;
import study.opencsv.model.Disease;
import study.opencsv.model.DiseaseCode;

public class Csvmain {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("C:\\Users\\Home\\Desktop\\data\\실제진료정보_감기_시군구.csv");
		list.add("C:\\Users\\Home\\Desktop\\data\\실제진료정보_눈병_시군구.csv");
		list.add("C:\\Users\\Home\\Desktop\\data\\실제진료정보_천식_시군구.csv");
		list.add("C:\\Users\\Home\\Desktop\\data\\실제진료정보_피부염_시군구.csv");
		HashMap<Integer, Area> map = new HashMap<Integer, Area>();
		HashMap<Integer, City> map2 = new HashMap<Integer, City>();
		HashMap<Integer, DiseaseCode> map3 = new HashMap<Integer, DiseaseCode>();
		ReadCsv csv = new ReadCsv();
		int check = 0;
		Session session = null;
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateAnnotationUtil.getSessionFactory();
		String[] s = null;
		csv.readCsv("C:\\Users\\Home\\Desktop\\data\\시도 지역코드.csv");
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			while ((s = csv.reader.readNext()) != null) {
				if (check == 0) {
					check++;
					continue;
				}
				int num = Integer.valueOf(s[0]);
				Area area = new Area(num, s[1]);
				map.put(num, area);
				session.save(area);
			}
			session.getTransaction().commit();
			csv.readCsv("C:\\Users\\Home\\Desktop\\data\\시군구 지역코드.csv");
			check = 0;
			session.beginTransaction();
			while ((s = csv.reader.readNext()) != null) {
				if (check == 0) {
					check++;
					continue;
				}
				int num = Integer.valueOf(s[0]);
				int num2 = Integer.valueOf(s[1]);
				Area a = map.get(num);
				City city = new City(a, num2, s[2]);
				map2.put(num2, city);
				session.save(city);
			}
			session.getTransaction().commit();
			map3 = csv.setDiseasecode();
			for (int i = 0; i < 4; i++) {
				csv.readCsv(list.get(i));
				check = 0;
				while ((s = csv.reader.readNext()) != null) {
					if (check == 0) {
						check++;
						continue;
					}
					String num = s[0];
					int num2 = Integer.valueOf(s[1]);
					int num3 = Integer.valueOf(s[2]);
					City c = map2.get(num2);
					DiseaseCode discd = map3.get(i);
					Disease dis = new Disease(num, c, num3, discd);
					if (dis.getCity() == null) {
						continue;
					}
					session.beginTransaction();
					session.save(dis);
					session.getTransaction().commit();
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

	}
}
