package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import model.LoaiHinh;
import ultis.JpaUltis;

public class LoaiHinhDAO implements EntityDAO<LoaiHinh>{

	private EntityManager entityManager = JpaUltis.getEntityManager();
	
	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public LoaiHinh create(LoaiHinh entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoaiHinh update(LoaiHinh entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<LoaiHinh> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoaiHinh findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
