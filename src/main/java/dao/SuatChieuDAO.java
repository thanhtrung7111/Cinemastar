package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import model.SuatChieu;
import ultis.JpaUltis;

public class SuatChieuDAO implements EntityDAO<SuatChieu>{
	private EntityManager entityManager = JpaUltis.getEntityManager();
	
	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public SuatChieu create(SuatChieu entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SuatChieu update(SuatChieu entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<SuatChieu> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SuatChieu findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
