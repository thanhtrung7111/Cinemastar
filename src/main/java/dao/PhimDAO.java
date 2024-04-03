package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import model.Phim;
import ultis.JpaUltis;

public class PhimDAO implements EntityDAO<Phim>{
	private EntityManager entityManager = JpaUltis.getEntityManager();
	
	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public Phim create(Phim entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Phim update(Phim entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Phim> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Phim findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
