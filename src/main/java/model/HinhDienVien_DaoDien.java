package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "HinhDienVien_DaoDien")
public class HinhDienVien_DaoDien {

	@Column(name = "hinhAnh")
	@Id
	private byte[] hinhAnh;

	@ManyToOne
	@JoinColumn(name="maLoaiHinh")
	@Id
	private LoaiHinh loaiHinh;
	
	@ManyToOne
	@JoinColumn(name = "maDV_DD")
	@Id
	private DienVienDaoDien dienVienDaoDien;

	public HinhDienVien_DaoDien() {
		
	}

	

	public byte[] getHinhAnh() {
		return hinhAnh;
	}



	public void setHinhAnh(byte[] hinhAnh) {
		this.hinhAnh = hinhAnh;
	}



	public LoaiHinh getLoaiHinh() {
		return loaiHinh;
	}

	public void setLoaiHinh(LoaiHinh loaiHinh) {
		this.loaiHinh = loaiHinh;
	}

	public DienVienDaoDien getDienVienDaoDien() {
		return dienVienDaoDien;
	}

	public void setDienVienDaoDien(DienVienDaoDien dienVienDaoDien) {
		this.dienVienDaoDien = dienVienDaoDien;
	}
	
	
	
}
