package model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Table(name = "TaiKhoan")
@Entity
public class TaiKhoan {
	@Id
	@Column(name = "maTaiKhoan")
	private String maTaiKhoan;
	
	@Column(name = "tenTaiKhoan")
	private String tenTaiKhoan;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "gioiTinh")
	private Boolean gioiTinh;
	
	@Column(name = "soDienThoai")
	private String soDienThoai;
	
	@Column(name = "matKhau")
	private String matKhau;
	
	@Column(name = "ngaySinh")
	@Temporal(TemporalType.DATE)
	private String ngaySinh;
	
	@Column(name = "hinhAnh")
	private byte[] hinhAnh;
	
	@ManyToOne
	@JoinColumn(name = "maLoaiTaiKhoan")
	private LoaiTaiKhoan loaiTaiKhoan;
	
	@OneToMany(mappedBy = "taiKhoan")
	private List<HoaDon> hoaDons;
	
	@OneToMany(mappedBy = "taiKhoan")
	private List<BinhLuan> binhLuans;

	public TaiKhoan() {
		
	}

	public String getMaTaiKhoan() {
		return maTaiKhoan;
	}

	public void setMaTaiKhoan(String maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}

	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(Boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}


	public byte[] getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(byte[] hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public LoaiTaiKhoan getLoaiTaiKhoan() {
		return loaiTaiKhoan;
	}

	public void setLoaiTaiKhoan(LoaiTaiKhoan loaiTaiKhoan) {
		this.loaiTaiKhoan = loaiTaiKhoan;
	}

	public List<HoaDon> getHoaDons() {
		return hoaDons;
	}

	public void setHoaDons(List<HoaDon> hoaDons) {
		this.hoaDons = hoaDons;
	}

	public List<BinhLuan> getBinhLuans() {
		return binhLuans;
	}

	public void setBinhLuans(List<BinhLuan> binhLuans) {
		this.binhLuans = binhLuans;
	}
	
	
}
