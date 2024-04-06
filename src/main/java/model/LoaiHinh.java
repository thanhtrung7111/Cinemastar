package model;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "LoaiHinh")
public class LoaiHinh {

	
	@Id
	@Column(name = "maLoaiHinh")
	@GenericGenerator(name = "sequence_loaihinh_id",strategy = "helper.LoaiHinhGeneratorID")
	@GeneratedValue(generator = "sequence_loaihinh_id")
	private String maLoaiHinh;
	
	@Column(name = "tenLoaiHinh")
	private String tenLoaiHinh;
	
	@OneToMany(mappedBy = "loaiHinh")
	private List<HinhPhim> hinhPhims;
	
	@OneToMany(mappedBy = "loaiHinh")
	private List<HinhDienVien_DaoDien> hinhDienVien_DaoDiens;

	public LoaiHinh() {
		
	}

	public String getMaLoaiHinh() {
		return maLoaiHinh;
	}

	public void setMaLoaiHinh(String maLoaiHinh) {
		this.maLoaiHinh = maLoaiHinh;
	}

	public String getTenLoaiHinh() {
		return tenLoaiHinh;
	}

	public void setTenLoaiHinh(String tenLoaiHinh) {
		this.tenLoaiHinh = tenLoaiHinh;
	}

	public List<HinhPhim> getHinhPhims() {
		return hinhPhims;
	}

	public void setHinhPhims(List<HinhPhim> hinhPhims) {
		this.hinhPhims = hinhPhims;
	}

	public List<HinhDienVien_DaoDien> getHinhDienVien_DaoDiens() {
		return hinhDienVien_DaoDiens;
	}

	public void setHinhDienVien_DaoDiens(List<HinhDienVien_DaoDien> hinhDienVien_DaoDiens) {
		this.hinhDienVien_DaoDiens = hinhDienVien_DaoDiens;
	}
	
	
	 
}
