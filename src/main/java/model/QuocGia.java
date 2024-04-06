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
@Table(name = "QuocGia")
public class QuocGia {

	@Column(name = "maquocgia")
	@Id
	@GenericGenerator(name = "sequence_quocgia_id", strategy = "helper.QuocGiaGeneratorID")
	@GeneratedValue(generator = "sequence_quocgia_id")
	private String maQuocGia;

	@Column(name = "tenquocgia")
	private String tenQuocGia;
	@OneToMany(mappedBy = "quocGia")
	private List<DienVienDaoDien> dienVienDaoDiens;

	@OneToMany(mappedBy = "quocGia")
	private List<Phim> phims;

	public QuocGia() {

	}

	public String getMaQuocGia() {
		return maQuocGia;
	}

	public void setMaQuocGia(String maQuocGia) {
		this.maQuocGia = maQuocGia;
	}

	public String getTenQuocGia() {
		return tenQuocGia;
	}

	public void setTenQuocGia(String tenQuocGia) {
		this.tenQuocGia = tenQuocGia;
	}

	public List<DienVienDaoDien> getDienVienDaoDiens() {
		return dienVienDaoDiens;
	}

	public void setDienVienDaoDiens(List<DienVienDaoDien> dienVienDaoDiens) {
		this.dienVienDaoDiens = dienVienDaoDiens;
	}

	public List<Phim> getPhims() {
		return phims;
	}

	public void setPhims(List<Phim> phims) {
		this.phims = phims;
	}

}
