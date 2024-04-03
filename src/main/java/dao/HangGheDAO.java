package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import model.HangGhe;
import ultis.JpaUltis;

public class HangGheDAO implements EntityDAO<HangGhe> {
	
	private EntityManager entityManager =JpaUltis.getEntityManager();
	
	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public HangGhe create(HangGhe entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HangGhe update(HangGhe entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<HangGhe> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HangGhe findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
