package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "HinhPhim")
public class HinhPhim {

	@Column(name = "hinhAnh")
	@Id
	private byte[] hinhAnh;
	
	@ManyToOne
	@JoinColumn(name = "maPhim")
	@Id
	private Phim phim;
	
	@ManyToOne
	@JoinColumn(name="maLoaiHinh")
	@Id
	private LoaiHinh loaiHinh;

	public HinhPhim() {
		
	}

	

	public byte[] getHinhAnh() {
		return hinhAnh;
	}



	public void setHinhAnh(byte[] hinhAnh) {
		this.hinhAnh = hinhAnh;
	}



	public Phim getPhim() {
		return phim;
	}

	public void setPhim(Phim phim) {
		this.phim = phim;
	}

	public LoaiHinh getLoaiHinh() {
		return loaiHinh;
	}

	public void setLoaiHinh(LoaiHinh loaiHinh) {
		this.loaiHinh = loaiHinh;
	}
	
	
}
