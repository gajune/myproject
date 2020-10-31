package study.opencsv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City {
	
	@ManyToOne
	@JoinColumn(name="areacode", nullable=false, columnDefinition="int(2)")
	private Area areas;

	@Id
	@Column(name = "citycode",columnDefinition="int(7)")
	int citycode;
	@Column(name = "cityname",columnDefinition="char(10)")
	String cityname;
	public City() {
		// TODO Auto-generated constructor stub
	}
	public int getCitycode() {
		return citycode;
	}
	public void setCitycode(int citycode) {
		this.citycode = citycode;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	
	public Area getAreas() {
		return areas;
	}
	public void setAreas(Area areas) {
		this.areas = areas;
	}
	public City(Area num, int num2, String name) {
		// TODO Auto-generated constructor stub
		areas = num;
		citycode = num2;
		cityname = name;
		
	}
}
