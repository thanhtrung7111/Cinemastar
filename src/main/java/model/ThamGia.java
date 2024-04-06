package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="thamgia")
public class ThamGia {

	@Id
	@ManyToOne
	@JoinColumn(name="maDV_DD")
	private DienVienDaoDien dienVienDaoDien;
	
	@Id
	@ManyToOne
	@JoinColumn(name="maPhim")
	private Phim phim;

	public ThamGia() {
		
	}

	public DienVienDaoDien getDienVienDaoDien() {
		return dienVienDaoDien;
	}

	public void setDienVienDaoDien(DienVienDaoDien dienVienDaoDien) {
		this.dienVienDaoDien = dienVienDaoDien;
	}

	public Phim getPhim() {
		return phim;
	}

	public void setPhim(Phim phim) {
		this.phim = phim;
	}

	
	
	
}
