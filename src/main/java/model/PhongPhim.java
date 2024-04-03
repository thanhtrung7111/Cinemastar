package model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PhongPhim")
public class PhongPhim {
	
	@Id
	@Column(name = "maPhongPhim")
	private String maPhongPhim;
	
	@Column(name = "tenPhongPhim")
	private String tenPhongPhim;
	
	@Column(name = "trangThai")
	private Boolean trangThai;
	
	@Column(name = "soGhe")
	private Integer soGhe;
	
	@ManyToOne
	@JoinColumn(name = "maRapPhim")
	private RapPhim rapPhim;
	
	@OneToMany(mappedBy = "phongPhim")
	private List<SuatChieu> suatChieus;
	
	@OneToMany(mappedBy = "phongPhim")
	private List<Ghe> ghes;

	public PhongPhim() {
	
	}

	public String getMaPhongPhim() {
		return maPhongPhim;
	}

	public void setMaPhongPhim(String maPhongPhim) {
		this.maPhongPhim = maPhongPhim;
	}

	public String getTenPhongPhim() {
		return tenPhongPhim;
	}

	public void setTenPhongPhim(String tenPhongPhim) {
		this.tenPhongPhim = tenPhongPhim;
	}

	public Boolean getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Boolean trangThai) {
		this.trangThai = trangThai;
	}

	public Integer getSoGhe() {
		return soGhe;
	}

	public void setSoGhe(Integer soGhe) {
		this.soGhe = soGhe;
	}

	public RapPhim getRapPhim() {
		return rapPhim;
	}

	public void setRapPhim(RapPhim rapPhim) {
		this.rapPhim = rapPhim;
	}

	public List<SuatChieu> getSuatChieus() {
		return suatChieus;
	}

	public void setSuatChieus(List<SuatChieu> suatChieus) {
		this.suatChieus = suatChieus;
	}

	public List<Ghe> getGhes() {
		return ghes;
	}

	public void setGhes(List<Ghe> ghes) {
		this.ghes = ghes;
	}
	
	
}
