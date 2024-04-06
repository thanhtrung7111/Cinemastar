package model;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "RapPhim")
public class RapPhim {
	@Id
	@Column(name = "maRapPhim")
	@GenericGenerator(name = "sequence_rapphim_id",strategy = "helper.RapPhimGeneratorID")
	@GeneratedValue(generator = "sequence_rapphim_id")
	private String maRapPhim;

	@Column(name = "tenRapPhim")
	private String tenRapPhim;

	@Column(name = "diaChi")
	private String diaChi;

	@Column(name = "soDienThoai")
	private String soDienThoai;

	@ManyToOne
	@JoinColumn(name = "maThanhPho")
	private ThanhPho thanhPho;

	@OneToMany(mappedBy = "rapPhim")
	List<PhongPhim> phongPhims;
	
	@OneToMany(mappedBy = "rapPhim")
	List<NhanVien> nhanViens;

	public RapPhim() {

	}

	public String getMaRapPhim() {
		return maRapPhim;
	}

	public void setMaRapPhim(String maRapPhim) {
		this.maRapPhim = maRapPhim;
	}


	public String getTenRapPhim() {
		return tenRapPhim;
	}

	public void setTenRapPhim(String tenRapPhim) {
		this.tenRapPhim = tenRapPhim;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public ThanhPho getThanhPho() {
		return thanhPho;
	}

	public void setThanhPho(ThanhPho thanhPho) {
		this.thanhPho = thanhPho;
	}

	public List<PhongPhim> getPhongPhims() {
		return phongPhims;
	}

	public void setPhongPhims(List<PhongPhim> phongPhims) {
		this.phongPhims = phongPhims;
	}

	public List<NhanVien> getNhanViens() {
		return nhanViens;
	}

	public void setNhanViens(List<NhanVien> nhanViens) {
		this.nhanViens = nhanViens;
	}

}
