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
@Table(name="Phim")
public class Phim {

	@Id
	@Column(name = "maPhim")
	private String maPhim;
	
	@Column(name = "tenPhim")
	private String tenPhim;
	
	@Column(name = "thoiLuong")
	private String thoiLuong;
	
	@Column(name = "mota")
	private String moTa;
	
	@Column(name = "noiDung")
	private String noiDung;
	
	@Column(name = "namSanXuat")
	private Integer namSanXuat;
	
	@ManyToOne
	@JoinColumn(name = "maQuocGia")
	private QuocGia quocGia;
	
	@OneToMany(mappedBy = "phim")
	private List<SuatChieu> suatChieus;
	
	@OneToMany(mappedBy = "phim")
	private List<BinhLuan> binhLuans;
	
	@OneToMany(mappedBy = "phim")
	private List<HinhPhim> hinhPhims;

	public Phim() {
		
	}

	public String getMaPhim() {
		return maPhim;
	}

	public void setMaPhim(String maPhim) {
		this.maPhim = maPhim;
	}

	public String getTenPhim() {
		return tenPhim;
	}

	public void setTenPhim(String tenPhim) {
		this.tenPhim = tenPhim;
	}

	public String getThoiLuong() {
		return thoiLuong;
	}

	public void setThoiLuong(String thoiLuong) {
		this.thoiLuong = thoiLuong;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public Integer getNamSanXuat() {
		return namSanXuat;
	}

	public void setNamSanXuat(Integer namSanXuat) {
		this.namSanXuat = namSanXuat;
	}

	public QuocGia getQuocGia() {
		return quocGia;
	}

	public void setQuocGia(QuocGia quocGia) {
		this.quocGia = quocGia;
	}

	public List<SuatChieu> getSuatChieus() {
		return suatChieus;
	}

	public void setSuatChieus(List<SuatChieu> suatChieus) {
		this.suatChieus = suatChieus;
	}

	public List<BinhLuan> getBinhLuans() {
		return binhLuans;
	}

	public void setBinhLuans(List<BinhLuan> binhLuans) {
		this.binhLuans = binhLuans;
	}

	public List<HinhPhim> getHinhPhims() {
		return hinhPhims;
	}

	public void setHinhPhims(List<HinhPhim> hinhPhims) {
		this.hinhPhims = hinhPhims;
	}
	
	
}
