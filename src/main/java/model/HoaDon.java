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
@Table(name="HoaDon")
public class HoaDon {
	@Id
	@Column(name = "maHD")
	private String maHD;
	
	
	@Column(name = "tongTien")
	private Double tongTien;
	
	@Column(name="trangThai")
	private Boolean trangThai;
	
	@Column(name="code")
	private String code;
	
	@ManyToOne
	@JoinColumn(name = "maNhanVien")
	private NhanVien nhanVien;
	
	@ManyToOne
	@JoinColumn(name = "maTaiKhoan")
	private TaiKhoan taiKhoan;
	
	@OneToMany(mappedBy = "hoaDon")
	private List<ApDungKhuyenMai> apDungKhuyenMais;
	
	@OneToMany(mappedBy = "hoaDon")
	private List<ChiTietCombo> chiTietCombos;

	public HoaDon() {
		
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public Double getTongTien() {
		return tongTien;
	}

	public void setTongTien(Double tongTien) {
		this.tongTien = tongTien;
	}

	public Boolean getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Boolean trangThai) {
		this.trangThai = trangThai;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public List<ApDungKhuyenMai> getApDungKhuyenMais() {
		return apDungKhuyenMais;
	}

	public void setApDungKhuyenMais(List<ApDungKhuyenMai> apDungKhuyenMais) {
		this.apDungKhuyenMais = apDungKhuyenMais;
	}

	public List<ChiTietCombo> getChiTietCombos() {
		return chiTietCombos;
	}

	public void setChiTietCombos(List<ChiTietCombo> chiTietCombos) {
		this.chiTietCombos = chiTietCombos;
	}
	
	
}
