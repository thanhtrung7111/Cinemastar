package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import model.DienVienDaoDien;
import model.HinhDienVien_DaoDien;
import ultis.JpaUltis;

public class HinhDienVien_DaoDienDAO  implements EntityDAO<HinhDienVien_DaoDien>{
	private EntityManager entityManager = JpaUltis.getEntityManager();
	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}
	@Override
	public HinhDienVien_DaoDien create(HinhDienVien_DaoDien entity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public HinhDienVien_DaoDien update(HinhDienVien_DaoDien entity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<HinhDienVien_DaoDien> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public HinhDienVien_DaoDien findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
