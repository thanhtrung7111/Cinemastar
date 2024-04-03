package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import model.PhongPhim;
import ultis.JpaUltis;

public class PhongPhimDAO implements EntityDAO<PhongPhim> {
	private EntityManager entityManager = JpaUltis.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public PhongPhim create(PhongPhim entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PhongPhim update(PhongPhim entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PhongPhim> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PhongPhim findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
