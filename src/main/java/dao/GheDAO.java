package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import model.Ghe;
import ultis.JpaUltis;

public class GheDAO implements EntityDAO<Ghe>{

	private EntityManager entityManager = JpaUltis.getEntityManager();
	
	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public Ghe create(Ghe entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ghe update(Ghe entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Ghe> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ghe findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
