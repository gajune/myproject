package study.opencsv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "disease")
public class Disease {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;

	@ManyToOne
	@JoinColumn(name = "citycode", nullable = false, columnDefinition = "int(10)")
	City city;
	@Column(name = "date", columnDefinition = "char(8)")
	String date;
	@Column(name = "comfirmd", columnDefinition = "int(10)")
	int comfirmd;
	@ManyToOne
	@JoinColumn(name = "diseasecode", nullable = false, columnDefinition = "int(2)")
	DiseaseCode discd;

	public Disease() {
		// TODO Auto-generated constructor stub
	}

	public Disease(String num1, City num2, int num3, DiseaseCode num4) {
		// TODO Auto-generated constructor stub
		date = num1;
		city = num2;
		comfirmd = num3;
		discd = num4;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getComfirmd() {
		return comfirmd;
	}

	public void setComfirmd(int comfirmd) {
		this.comfirmd = comfirmd;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public DiseaseCode getDiscd() {
		return discd;
	}

	public void setDiscd(DiseaseCode discd) {
		this.discd = discd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Disease [id=" + id + ", city=" + city + ", date=" + date + ", comfirmd=" + comfirmd + ", discd=" + discd
				+ "]";
	}

}
