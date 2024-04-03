package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import model.HoaDon;
import ultis.JpaUltis;

public class HoaDonDAO implements EntityDAO<HoaDon>{

	private EntityManager entityManager = JpaUltis.getEntityManager();
	
	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public HoaDon create(HoaDon entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HoaDon update(HoaDon entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<HoaDon> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HoaDon findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
