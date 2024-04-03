package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import model.LoaiTaiKhoan;
import ultis.JpaUltis;

public class LoaiTaiKhoanDAO implements EntityDAO<LoaiTaiKhoan> {

	private EntityManager entityManager = JpaUltis.getEntityManager();
	
	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public LoaiTaiKhoan create(LoaiTaiKhoan entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoaiTaiKhoan update(LoaiTaiKhoan entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<LoaiTaiKhoan> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoaiTaiKhoan findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
