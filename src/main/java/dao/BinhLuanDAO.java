package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import model.BinhLuan;
import ultis.JpaUltis;

public class BinhLuanDAO implements EntityDAO<BinhLuan>{
	private EntityManager entityManager = JpaUltis.getEntityManager();
	
	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public BinhLuan create(BinhLuan entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BinhLuan update(BinhLuan entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BinhLuan> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BinhLuan findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
