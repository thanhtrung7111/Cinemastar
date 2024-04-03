package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import model.LoaiGhe;
import ultis.JpaUltis;

public class LoaiGheDAO implements EntityDAO<LoaiGhe> {

	private EntityManager entityManager = JpaUltis.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public LoaiGhe create(LoaiGhe entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoaiGhe update(LoaiGhe entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<LoaiGhe> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoaiGhe findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
