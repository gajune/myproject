package study.opencsv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "diseasecode")
public class DiseaseCode {
	public DiseaseCode() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "diseasecode", columnDefinition = "int(7)")
	int diseasecode;

	@Column(name = "diseasename", columnDefinition = "char(5)")
	String diseasename;

	public int getDiseasecode() {
		return diseasecode;
	}

	public void setDiseasecode(int diseasecode) {
		this.diseasecode = diseasecode;
	}

	public String getDiseasename() {
		return diseasename;
	}

	public void setDiseasename(String diseasename) {
		this.diseasename = diseasename;
	}

}
