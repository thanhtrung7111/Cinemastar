package model;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Phim")
public class Phim {

	@Id
	@Column(name = "maPhim")
	@GenericGenerator(name = "sequence_phim_id", strategy = "helper.PhimGeneratorID")
	@GeneratedValue(generator = "sequence_phim_id")
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

	@Column(name = "hinhAnh")
	private String hinhAnh;

	@Transient
	private String image;

	@Column(name = "trailer")
	private String trailer;

	@ManyToOne
	@JoinColumn(name = "maQuocGia")
	private QuocGia quocGia;

	@OneToMany(mappedBy = "phim")
	private List<SuatChieu> suatChieus;

	@OneToMany(mappedBy = "phim")
	private List<BinhLuan> binhLuans;

	@OneToMany(mappedBy = "phim")
	private List<HinhPhim> hinhPhims;

	@OneToMany(mappedBy = "phim")
	private List<ThamGia> thamGias;

	public List<ThamGia> getThamGias() {
		return thamGias;
	}

	public void setThamGias(List<ThamGia> thamGias) {
		this.thamGias = thamGias;
	}

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

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

}
