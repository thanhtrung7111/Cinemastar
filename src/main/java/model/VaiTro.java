package model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "VaiTro")
public class VaiTro {

	@Id
	@Column(name = "maVaiTro")
	private String maVaiTro;

	@Column(name = "tenVaiTro")
	private String tenVaiTro;

	@OneToMany(mappedBy = "vaiTro")
	List<DienVienDaoDien> dienVienDaoDiens;

	public VaiTro() {
		
	}

	public String getMaVaiTro() {
		return maVaiTro;
	}

	public void setMaVaiTro(String maVaiTro) {
		this.maVaiTro = maVaiTro;
	}

	public String getTenVaiTro() {
		return tenVaiTro;
	}

	public void setTenVaiTro(String tenVaiTro) {
		this.tenVaiTro = tenVaiTro;
	}

	public List<DienVienDaoDien> getDienVienDaoDiens() {
		return dienVienDaoDiens;
	}

	public void setDienVienDaoDiens(List<DienVienDaoDien> dienVienDaoDiens) {
		this.dienVienDaoDiens = dienVienDaoDiens;
	}

	
}
