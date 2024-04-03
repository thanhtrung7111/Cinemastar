package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import model.DienVienDaoDien;
import ultis.JpaUltis;

public class DienVienDaoDienDAO implements EntityDAO<DienVienDaoDien>{

	private EntityManager entityManager = JpaUltis.getEntityManager();
	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}
	@Override
	public DienVienDaoDien create(DienVienDaoDien entity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public DienVienDaoDien update(DienVienDaoDien entity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<DienVienDaoDien> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public DienVienDaoDien findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
