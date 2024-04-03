package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import model.TaiKhoan;
import ultis.JpaUltis;

public class TaiKhoanDAO implements EntityDAO<TaiKhoan>{

	
	private EntityManager entityManager =JpaUltis.getEntityManager();
	
	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public TaiKhoan create(TaiKhoan entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaiKhoan update(TaiKhoan entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TaiKhoan> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaiKhoan findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
