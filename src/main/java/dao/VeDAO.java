package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import model.Ve;
import ultis.JpaUltis;

public class VeDAO implements EntityDAO<Ve>{
	private EntityManager entityManager = JpaUltis.getEntityManager();
	
	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public Ve create(Ve entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ve update(Ve entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Ve> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ve findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
