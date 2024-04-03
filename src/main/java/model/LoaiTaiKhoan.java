package model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="LoaiTaiKhoan")
public class LoaiTaiKhoan {

	@Id
	@Column(name="maLoaiTaiKhoan")
	private String maLoaiTaiKhoan;
	
	@Column(name = "tenLoaiTaiKhoan")
	private String tenLoaiTaiKhoan;
	
	@Column(name="chiTieuToiThieu")
	private Double chiTieuToiThieu;
	
	@Column(name = "mota")
	private String mota;
	
	@OneToMany(mappedBy = "loaiTaiKhoan")
	private List<TaiKhoan> taiKhoans;
	
	@OneToMany(mappedBy = "loaiTaiKhoan")
	private List<ApDungTaiKhoan> apDungTaiKhoans;

	public LoaiTaiKhoan() {
		
	}

	public String getMaLoaiTaiKhoan() {
		return maLoaiTaiKhoan;
	}

	public void setMaLoaiTaiKhoan(String maLoaiTaiKhoan) {
		this.maLoaiTaiKhoan = maLoaiTaiKhoan;
	}

	public String getTenLoaiTaiKhoan() {
		return tenLoaiTaiKhoan;
	}

	public void setTenLoaiTaiKhoan(String tenLoaiTaiKhoan) {
		this.tenLoaiTaiKhoan = tenLoaiTaiKhoan;
	}

	public Double getChiTieuToiThieu() {
		return chiTieuToiThieu;
	}

	public void setChiTieuToiThieu(Double chiTieuToiThieu) {
		this.chiTieuToiThieu = chiTieuToiThieu;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public List<TaiKhoan> getTaiKhoans() {
		return taiKhoans;
	}

	public void setTaiKhoans(List<TaiKhoan> taiKhoans) {
		this.taiKhoans = taiKhoans;
	}

	public List<ApDungTaiKhoan> getApDungTaiKhoans() {
		return apDungTaiKhoans;
	}

	public void setApDungTaiKhoans(List<ApDungTaiKhoan> apDungTaiKhoans) {
		this.apDungTaiKhoans = apDungTaiKhoans;
	}
	
}
