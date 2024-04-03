package model;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="ThanhPho")
public class ThanhPho {

	@Id
	@Column(name = "maThanhPho")
	@GeneratedValue(generator = "sequence_thanhpho_id")  
	@GenericGenerator(name = "sequence_thanhpho_id", strategy = "helper.ThanhPhoGeneratorID")
	public String maThanhPho;
	
	@Column(name = "tenThanhPho")
	public String tenThanhPho;
	
	@OneToMany(mappedBy = "thanhPho")
	public List<RapPhim> rapPhims;

	public ThanhPho() {
		
	}

	public String getMaThanhPho() {
		return maThanhPho;
	}

	public void setMaThanhPho(String maThanhPho) {
		this.maThanhPho = maThanhPho;
	}

	public String getTenThanhPho() {
		return tenThanhPho;
	}

	public void setTenThanhPho(String tenThanhPho) {
		this.tenThanhPho = tenThanhPho;
	}

	public List<RapPhim> getRapPhims() {
		return rapPhims;
	}

	public void setRapPhims(List<RapPhim> rapPhims) {
		this.rapPhims = rapPhims;
	}
	
	
}
