package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import model.LoaiNhanVien;
import ultis.JpaUltis;

public class LoaiNhanVienDAO implements EntityDAO<LoaiNhanVien>{
	
	private EntityManager entityManager = JpaUltis.getEntityManager();
	
	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public LoaiNhanVien create(LoaiNhanVien entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoaiNhanVien update(LoaiNhanVien entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<LoaiNhanVien> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoaiNhanVien findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
