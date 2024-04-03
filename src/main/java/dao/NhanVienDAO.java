package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import model.NhanVien;
import ultis.JpaUltis;

public class NhanVienDAO implements EntityDAO<NhanVien>{
	private EntityManager entityManager = JpaUltis.getEntityManager();
	
	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public NhanVien create(NhanVien entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NhanVien update(NhanVien entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<NhanVien> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NhanVien findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
