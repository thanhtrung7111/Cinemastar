package model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ve")
public class Ve {
	@Id
	@Column(name = "maVe")
	@GenericGenerator(name = "sequence_ve_id",strategy = "helper.VeGeneratorID")
	@GeneratedValue(generator = "sequence_ve_id")
	private String maVe;
	
	@Column(name = "tongTien")
	private Double tongTien;
	
	@ManyToOne
	@JoinColumn(name = "maGhe")
	private Ghe ghe;
	
	
	@ManyToOne
	@JoinColumn(name = "maSuatChieu")
	private SuatChieu suatChieu;


	public Ve() {
		
	}


	public String getMaVe() {
		return maVe;
	}


	public void setMaVe(String maVe) {
		this.maVe = maVe;
	}


	public Double getTongTien() {
		return tongTien;
	}


	public void setTongTien(Double tongTien) {
		this.tongTien = tongTien;
	}


	public Ghe getGhe() {
		return ghe;
	}


	public void setGhe(Ghe ghe) {
		this.ghe = ghe;
	}


	public SuatChieu getSuatChieu() {
		return suatChieu;
	}


	public void setSuatChieu(SuatChieu suatChieu) {
		this.suatChieu = suatChieu;
	}
	
	
}
