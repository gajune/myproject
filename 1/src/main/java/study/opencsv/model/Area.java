package study.opencsv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "area")
public class Area {

	@Id
	@Column(name = "areacode", columnDefinition = "int(2)")
	int areacode;
	@Column(name = "areaname", columnDefinition = "char(2)")
	String area;

	public int getAreacode() {
		return areacode;
	}

	public void setAreacode(int areacode) {
		this.areacode = areacode;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Area(int num, String name) {
		// TODO Auto-generated constructor stub
		areacode = num;
		area = name;
	}
	public Area() {
		// TODO Auto-generated constructor stub
	}

}
