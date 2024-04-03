package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import model.VaiTro;
import ultis.JpaUltis;

public class VaiTroDAO implements EntityDAO<VaiTro>{
	private EntityManager entityManager = JpaUltis.getEntityManager();
	
	
	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}


	@Override
	public VaiTro create(VaiTro entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public VaiTro update(VaiTro entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<VaiTro> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public VaiTro findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
