package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import model.HinhPhim;
import ultis.JpaUltis;

public class HinhPhimDAO implements EntityDAO<HinhPhim>{

	private EntityManager entityManager = JpaUltis.getEntityManager();
	
	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public HinhPhim create(HinhPhim entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HinhPhim update(HinhPhim entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<HinhPhim> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HinhPhim findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
