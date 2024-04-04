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
@Table(name = "ComboDoAn")
public class ComboDoAn {
	
	@Id
	@Column(name = "maCombo")
	@GenericGenerator(name = "sequence_combo_id",strategy = "helper.ComboDoAnGeneratorID")
	@GeneratedValue(generator = "sequence_combo_id")
	private String maCombo;
	
	@Column(name = "tenCombo")
	private String tenCombo;
	
	@Column(name = "mota")
	private String moTa;
	
	@Column(name = "giaCombo")
	private Double giaCombo;
	
	@OneToMany(mappedBy = "comboDoAn")
	private List<ChiTietCombo> chiTietCombos;

	public ComboDoAn() {
		
	}

	public String getMaCombo() {
		return maCombo;
	}

	public void setMaCombo(String maCombo) {
		this.maCombo = maCombo;
	}

	public String getTenCombo() {
		return tenCombo;
	}

	public void setTenCombo(String tenCombo) {
		this.tenCombo = tenCombo;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Double getGiaCombo() {
		return giaCombo;
	}

	public void setGiaCombo(Double giaCombo) {
		this.giaCombo = giaCombo;
	}

	public List<ChiTietCombo> getChiTietCombos() {
		return chiTietCombos;
	}

	public void setChiTietCombos(List<ChiTietCombo> chiTietCombos) {
		this.chiTietCombos = chiTietCombos;
	}

	
	
}

