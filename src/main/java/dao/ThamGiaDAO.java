package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.QuocGia;
import model.ThamGia;
import ultis.JpaUltis;

public class ThamGiaDAO implements EntityDAO<ThamGia> {
	private EntityManager entityManager = JpaUltis.getEntityManager();

	@Override
	public ThamGia create(ThamGia entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println(e);
		}
		return null;
	}

	@Override
	public ThamGia update(ThamGia entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println(e);
		}
		return null;
	}

	@Override
	public boolean delete(String id) {
		try {
			entityManager.getTransaction().begin();
			ThamGia entity = entityManager.find(ThamGia.class, id);
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<ThamGia> selectAll() {
		String jpql = "SELECT o from QuocGia o";
		TypedQuery<ThamGia> query = entityManager.createQuery(jpql, ThamGia.class);
		List<ThamGia> thamGias = query.getResultList();
		return thamGias;
	}

	@Override
	public ThamGia findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
