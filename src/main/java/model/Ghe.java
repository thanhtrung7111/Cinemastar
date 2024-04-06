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
@Table(name = "Ghe")
public class Ghe {
	@Column(name = "maGhe")
	@Id
	@GenericGenerator(name = "sequence_ghe_id", strategy = "helper.GheGeneratorID")
	@GeneratedValue(generator = "sequence_ghe_id")
	private String maGhe;

	@Column(name = "tenGhe")
	private String tenGhe;

	@ManyToOne
	@JoinColumn(name = "maLoaiGhe")
	private LoaiGhe loaiGhe;

	@ManyToOne
	@JoinColumn(name = "maPhongPhim")
	private PhongPhim phongPhim;

	@ManyToOne
	@JoinColumn(name = "maHangGhe")
	private HangGhe hangGhe;

	@OneToMany(mappedBy = "ghe")
	private List<Ve> ves;

	public Ghe() {

	}

	public String getMaGhe() {
		return maGhe;
	}

	public void setMaGhe(String maGhe) {
		this.maGhe = maGhe;
	}

	public String getTenGhe() {
		return tenGhe;
	}

	public void setTenGhe(String tenGhe) {
		this.tenGhe = tenGhe;
	}

	public LoaiGhe getLoaiGhe() {
		return loaiGhe;
	}

	public void setLoaiGhe(LoaiGhe loaiGhe) {
		this.loaiGhe = loaiGhe;
	}

	public PhongPhim getPhongPhim() {
		return phongPhim;
	}

	public void setPhongPhim(PhongPhim phongPhim) {
		this.phongPhim = phongPhim;
	}

	public HangGhe getHangGhe() {
		return hangGhe;
	}

	public void setHangGhe(HangGhe hangGhe) {
		this.hangGhe = hangGhe;
	}

	public List<Ve> getVes() {
		return ves;
	}

	public void setVes(List<Ve> ves) {
		this.ves = ves;
	}

}
