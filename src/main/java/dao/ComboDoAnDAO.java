package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import model.ComboDoAn;
import ultis.JpaUltis;

public class ComboDoAnDAO implements EntityDAO<ComboDoAn>{
	private EntityManager entityManager =JpaUltis.getEntityManager();
	
	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public ComboDoAn create(ComboDoAn entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComboDoAn update(ComboDoAn entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ComboDoAn> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComboDoAn findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
