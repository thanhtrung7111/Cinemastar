package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ApDungTaiKhoan")
public class ApDungTaiKhoan {
	@Column(name = "trangThaiApDung")
	private Boolean trangThaiApDung;
	
	@ManyToOne
	@JoinColumn(name = "maKhuyenMai")
	@Id
	private KhuyenMai khuyenMai;
	
	
	@ManyToOne
	@JoinColumn(name = "maLoaiTaiKhoan")
	@Id
	private LoaiTaiKhoan loaiTaiKhoan;


	
	public ApDungTaiKhoan() {
		
	}


	public Boolean getTrangThaiApDung() {
		return trangThaiApDung;
	}


	public void setTrangThaiApDung(Boolean trangThaiApDung) {
		this.trangThaiApDung = trangThaiApDung;
	}


	public KhuyenMai getKhuyenMai() {
		return khuyenMai;
	}


	public void setKhuyenMai(KhuyenMai khuyenMai) {
		this.khuyenMai = khuyenMai;
	}


	public LoaiTaiKhoan getLoaiTaiKhoan() {
		return loaiTaiKhoan;
	}


	public void setLoaiTaiKhoan(LoaiTaiKhoan loaiTaiKhoan) {
		this.loaiTaiKhoan = loaiTaiKhoan;
	}
	
}
