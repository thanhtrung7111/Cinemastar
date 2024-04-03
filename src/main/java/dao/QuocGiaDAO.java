package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import model.QuocGia;
import ultis.JpaUltis;

public class QuocGiaDAO implements EntityDAO<QuocGia> {
	
	private EntityManager entityManager = JpaUltis.getEntityManager();
	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}
	
	@Override
	public QuocGia create(QuocGia entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
	
	

	@Override
	public QuocGia update(QuocGia entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<QuocGia> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		QuocGiaDAO quocGiaDAO = new QuocGiaDAO();
		QuocGia qg = new QuocGia();
		qg.setMaQuocGia("qg00005");
		qg.setTenQuocGia("Viet Nam");
		quocGiaDAO.create(qg);
	}

	@Override
	public QuocGia findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
