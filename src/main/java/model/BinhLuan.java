package model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BinhLuan")
public class BinhLuan {
	@Column(name = "thoiGianBinhLuan")
	@Id
	private Date thoiGianBinhLuan;
	
	@Column(name="noiDung")
	@Id
	private String noiDung;
	
	@ManyToOne
	@JoinColumn(name = "maTaiKhoan")
	private TaiKhoan taiKhoan;
	
	@ManyToOne
	@JoinColumn(name="maPhim")
	private Phim phim;

	
	public BinhLuan() {
		
	}

	public Date getThoiGianBinhLuan() {
		return thoiGianBinhLuan;
	}

	public void setThoiGianBinhLuan(Date thoiGianBinhLuan) {
		this.thoiGianBinhLuan = thoiGianBinhLuan;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public Phim getPhim() {
		return phim;
	}

	public void setPhim(Phim phim) {
		this.phim = phim;
	}
	
	
}
