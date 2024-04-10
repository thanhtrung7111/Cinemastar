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
@Table(name="HoaDon")
public class HoaDon {
	@Id
	@Column(name = "maHD")
	@GenericGenerator(name = "sequence_hoadon_id",strategy = "helper.HoaDonGeneratorID")
	@GeneratedValue(generator = "sequence_hoadon_id")
	private String maHD;
	
	
	@Column(name = "tongTien")
	private Double tongTien;
	
	@Column(name="trangThai")
	private Boolean trangThai =false;
	
	@Column(name="code")
	private String code;
	
	@Column(name="ngayLapHD")
	@Temporal(TemporalType.DATE)
	private Date ngayLapHD;
	
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
	
	@OneToMany(mappedBy = "hoaDon")
	private List<Ve> ves;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getNgayLapHD() {
		return ngayLapHD;
	}

	public void setNgayLapHD(Date ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}

	public List<Ve> getVes() {
		return ves;
	}

	public void setVes(List<Ve> ves) {
		this.ves = ves;
	}

	
	
}
