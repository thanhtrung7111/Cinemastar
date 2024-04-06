package model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

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
@Table(name = "daodien_dienvien")
public class DienVienDaoDien {
	@Id
	@Column(name = "maDV_DD")
	@GenericGenerator(name = "sequence_dienvien_id",strategy = "helper.DienVienDaoDienGeneratorID")
	@GeneratedValue(generator = "sequence_dienvien_id")
	private String maDV_DD;

	@Column(name = "tenDV_DD")
	private String tenDV_DD;

	@Column(name = "ngaySinh")
	@Temporal(TemporalType.DATE)
	private Date ngaySinh;
	
	@Column(name = "mota")
	private String mota;
	
	@Column(name = "chieuCao")
	private Integer ChieuCao;
	
	@Column(name = "hinhAnh")
	private String hinhAnh;
	
	@JoinColumn(name = "maVaiTro")
	@ManyToOne
	VaiTro vaiTro;
	
	@JoinColumn(name = "maQuocGia")
	@ManyToOne
	QuocGia quocGia;
	
	@OneToMany(mappedBy = "dienVienDaoDien")
	private List<ThamGia> thamGia;
	

	public List<ThamGia> getThamGia() {
		return thamGia;
	}

	public void setThamGia(List<ThamGia> thamGia) {
		this.thamGia = thamGia;
	}

	@OneToMany(mappedBy ="dienVienDaoDien")
	private List<HinhDienVien_DaoDien> hinhDienVien_DaoDiens;

	public DienVienDaoDien() {
		
	}

	public String getMaDV_DD() {
		return maDV_DD;
	}

	public void setMaDV_DD(String maDV_DD) {
		this.maDV_DD = maDV_DD;
	}

	public String getTenDV_DD() {
		return tenDV_DD;
	}

	public void setTenDV_DD(String tenDV_DD) {
		this.tenDV_DD = tenDV_DD;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public Integer getChieuCao() {
		return ChieuCao;
	}

	public void setChieuCao(Integer chieuCao) {
		ChieuCao = chieuCao;
	}

	public VaiTro getVaiTro() {
		return vaiTro;
	}

	public void setVaiTro(VaiTro vaiTro) {
		this.vaiTro = vaiTro;
	}

	public QuocGia getQuocGia() {
		return quocGia;
	}

	public void setQuocGia(QuocGia quocGia) {
		this.quocGia = quocGia;
	}

	public List<HinhDienVien_DaoDien> getHinhDienVien_DaoDiens() {
		return hinhDienVien_DaoDiens;
	}

	public void setHinhDienVien_DaoDiens(List<HinhDienVien_DaoDien> hinhDienVien_DaoDiens) {
		this.hinhDienVien_DaoDiens = hinhDienVien_DaoDiens;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	
	
	
}
