package model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "KhuyenMai")
public class KhuyenMai {

	@Id
	@GenericGenerator(name = "sequence_khuyenmai_id", strategy = "helper.KhuyenMaiGeneratorID")
	@GeneratedValue(generator = "sequence_khuyenmai_id")
	@Column(name = "maKhuyenMai")
	private String maKhuyenMai;

	@Column(name = "tenKhuyenMai")
	private String tenKhuyenMai;

	@Column(name = "phanTramGiam")
	private Integer phanTramGiam;

	@Column(name = "soTienGiamTrucTiep")
	private Double soTienGiamTrucTiep;

	@Temporal(TemporalType.DATE)
	@Column(name = "ngayApDung")
	private Date ngayApDung;

	@Temporal(TemporalType.DATE)
	@Column(name = "ngayKetThuc")
	private Date ngayKetThuc;

	@Column(name = "hinhAnh")
	private String hinhAnh;

	@OneToMany(mappedBy = "khuyenMai")
	private List<ApDungTaiKhoan> apDungTaiKhoans;

	@OneToMany(mappedBy = "khuyenMai")
	private List<ApDungKhuyenMai> apDungKhuyenMais;

	public KhuyenMai() {

	}

	public String getMaKhuyenMai() {
		return maKhuyenMai;
	}

	public void setMaKhuyenMai(String maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
	}

	public String getTenKhuyenMai() {
		return tenKhuyenMai;
	}

	public void setTenKhuyenMai(String tenKhuyenMai) {
		this.tenKhuyenMai = tenKhuyenMai;
	}

	public Integer getPhanTramGiam() {
		return phanTramGiam;
	}

	public void setPhanTramGiam(Integer phanTramGiam) {
		this.phanTramGiam = phanTramGiam;
	}

	public Double getSoTienGiamTrucTiep() {
		return soTienGiamTrucTiep;
	}

	public void setSoTienGiamTrucTiep(Double soTienGiamTrucTiep) {
		this.soTienGiamTrucTiep = soTienGiamTrucTiep;
	}

	public Date getNgayApDung() {
		return ngayApDung;
	}

	public void setNgayApDung(Date ngayApDung) {
		this.ngayApDung = ngayApDung;
	}

	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public List<ApDungTaiKhoan> getApDungTaiKhoans() {
		return apDungTaiKhoans;
	}

	public void setApDungTaiKhoans(List<ApDungTaiKhoan> apDungTaiKhoans) {
		this.apDungTaiKhoans = apDungTaiKhoans;
	}

	public List<ApDungKhuyenMai> getApDungKhuyenMais() {
		return apDungKhuyenMais;
	}

	public void setApDungKhuyenMais(List<ApDungKhuyenMai> apDungKhuyenMais) {
		this.apDungKhuyenMais = apDungKhuyenMais;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

}
