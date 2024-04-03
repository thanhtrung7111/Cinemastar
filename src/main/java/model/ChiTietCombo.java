package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ChiTietCombo")
public class ChiTietCombo {

	
	@Column(name = "soLuong")
	private Integer soLuong;
	
	@Column(name="tongTien")
	private Double tongTien;
	
	@ManyToOne
	@JoinColumn(name = "maHD")
	@Id
	private HoaDon hoaDon;
	
	@ManyToOne
	@JoinColumn(name="maCombo")
	@Id
	private ComboDoAn comboDoAn;

	public ChiTietCombo() {
		
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public Double getTongTien() {
		return tongTien;
	}

	public void setTongTien(Double tongTien) {
		this.tongTien = tongTien;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public ComboDoAn getComboDoAn() {
		return comboDoAn;
	}

	public void setComboDoAn(ComboDoAn comboDoAn) {
		this.comboDoAn = comboDoAn;
	}
	
}
