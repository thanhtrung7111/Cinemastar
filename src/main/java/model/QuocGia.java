package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "QuocGia")
public class QuocGia {

	@Column(name = "maquocgia")
	@Id
	private String maQuocGia;

	@Column(name="tenquocgia")
	private String tenQuocGia;
}
