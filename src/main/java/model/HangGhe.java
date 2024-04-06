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
@Table(name="HangGhe")
public class HangGhe {
	
	@Id
	@Column(name = "maHangGhe")
	@GenericGenerator(name = "sequence_hangghe_id",strategy = "helper.HangGheGeneratorID")
	@GeneratedValue(generator = "sequence_hangghe_id")
	private String maHangGhe;
	
	@Column(name="tenHangGhe")
	private String tenHangGhe;
	
	@OneToMany(mappedBy = "hangGhe")
	private List<Ghe> ghes;

	public HangGhe() {
		
	}

	public String getMaHangGhe() {
		return maHangGhe;
	}

	public void setMaHangGhe(String maHangGhe) {
		this.maHangGhe = maHangGhe;
	}

	public String getTenHangGhe() {
		return tenHangGhe;
	}

	public void setTenHangGhe(String tenHangGhe) {
		this.tenHangGhe = tenHangGhe;
	}

	public List<Ghe> getGhes() {
		return ghes;
	}

	public void setGhes(List<Ghe> ghes) {
		this.ghes = ghes;
	}
	
	
}
