package model;

import java.util.Date;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "NhanVien")
public class NhanVien {
	@Id
	@Column(name = "maNhanVien")
	@GenericGenerator(name = "sequence_nhanvien_id",strategy = "helper.NhanVienGeneratorID")
	@GeneratedValue(generator = "sequence_nhanvien_id")
	private String maNhanVien;
	
	@Column(name="tenNhanVien")
	private String tenNhanVien;
	
	@Column(name = "email")
	private String email;
	
	@Column(name="soDienThoai")
	private String soDienThoai;
	
	@Column(name = "matKhau")
	private String matKhau;
	
	@Column(name = "ngaySinh")
	@Temporal(TemporalType.DATE)
	private Date ngaySinh;
	
	@ManyToOne
	@JoinColumn(name = "maLoaiNhanVien")
	private LoaiNhanVien loaiNhanVien;
	
	@OneToMany(mappedBy = "nhanVien")
	List<HoaDon> hoaDons;
	
	@ManyToOne
	@JoinColumn(name = "maRapPhim")
	RapPhim rapPhim;

	public NhanVien() {
		
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public LoaiNhanVien getLoaiNhanVien() {
		return loaiNhanVien;
	}

	public void setLoaiNhanVien(LoaiNhanVien loaiNhanVien) {
		this.loaiNhanVien = loaiNhanVien;
	}

	public List<HoaDon> getHoaDons() {
		return hoaDons;
	}

	public void setHoaDons(List<HoaDon> hoaDons) {
		this.hoaDons = hoaDons;
	}

	public RapPhim getRapPhim() {
		return rapPhim;
	}

	public void setRapPhim(RapPhim rapPhim) {
		this.rapPhim = rapPhim;
	}
	
	
}
