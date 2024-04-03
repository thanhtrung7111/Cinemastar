package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ApDungKhuyenMai")
public class ApDungKhuyenMai {
	@Column(name="trangThaiApdung")
	private Boolean trangThaiApdung;
	
	@ManyToOne
	@JoinColumn(name = "maKhuyenMai")
	@Id
	private KhuyenMai khuyenMai;
	
	
	@ManyToOne
	@JoinColumn(name = "maHD")
	@Id
	private HoaDon hoaDon;

	

	public ApDungKhuyenMai() {
		
	}


	public Boolean getTrangThaiApdung() {
		return trangThaiApdung;
	}


	public void setTrangThaiApdung(Boolean trangThaiApdung) {
		this.trangThaiApdung = trangThaiApdung;
	}


	public KhuyenMai getKhuyenMai() {
		return khuyenMai;
	}


	public void setKhuyenMai(KhuyenMai khuyenMai) {
		this.khuyenMai = khuyenMai;
	}


	public HoaDon getHoaDon() {
		return hoaDon;
	}


	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	
	
}
