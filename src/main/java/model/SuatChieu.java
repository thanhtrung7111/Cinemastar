package model;

import java.util.Date;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "SuatChieu")
public class SuatChieu {
	@Id
	@Column(name = "maSuatChieu")
	@GenericGenerator(name = "sequence_suatchieu_id",strategy = "helper.SuatChieuGeneratorID")
	@GeneratedValue(generator = "sequence_suatchieu_id")
	private String maSuatChieu;
	
	@Column(name = "thoiGianChieu")
	@Temporal(TemporalType.TIME)
	private Date thoiGianChieu;
	
	@Column(name="ngayChieu")
	@Temporal(TemporalType.DATE)
	private Date ngayChieu;
	
	@ManyToOne
	@JoinColumn(name="maPhongPhim")
	private PhongPhim phongPhim;
	
	@ManyToOne
	@JoinColumn(name="maPhim")
	private Phim phim;
	
	@OneToMany(mappedBy = "suatChieu")
	private List<Ve> ves;

	public SuatChieu() {
	
	}

	public String getMaSuatChieu() {
		return maSuatChieu;
	}

	public void setMaSuatChieu(String maSuatChieu) {
		this.maSuatChieu = maSuatChieu;
	}

	public Date getThoiGianChieu() {
		return thoiGianChieu;
	}

	public void setThoiGianChieu(Date thoiGianChieu) {
		this.thoiGianChieu = thoiGianChieu;
	}

	public Date getNgayChieu() {
		return ngayChieu;
	}

	public void setNgayChieu(Date ngayChieu) {
		this.ngayChieu = ngayChieu;
	}

	public PhongPhim getPhongPhim() {
		return phongPhim;
	}

	public void setPhongPhim(PhongPhim phongPhim) {
		this.phongPhim = phongPhim;
	}

	public Phim getPhim() {
		return phim;
	}

	public void setPhim(Phim phim) {
		this.phim = phim;
	}

	public List<Ve> getVes() {
		return ves;
	}

	public void setVes(List<Ve> ves) {
		this.ves = ves;
	}
	
	
}
