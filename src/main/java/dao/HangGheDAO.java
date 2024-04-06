package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.HangGhe;
import model.ThanhPho;
import ultis.JpaUltis;

public class HangGheDAO implements EntityDAO<HangGhe> {

	private EntityManager entityManager = JpaUltis.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public HangGhe create(HangGhe entity) {

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
	public HangGhe update(HangGhe entity) {
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
			HangGhe entity = entityManager.find(HangGhe.class, id);
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<HangGhe> selectAll() {
		String jpql = "SELECT o from HangGhe o";
		TypedQuery<HangGhe> query = entityManager.createQuery(jpql, HangGhe.class);
		List<HangGhe> hangGhes = query.getResultList();
		return hangGhes;
	}

	public String maxIDHangGhe() {
		String jpql = "SELECT max(t.maHangGhe) from HangGhe t";
		TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
		return query.getSingleResult();
	}

	@Override
	public HangGhe findById(String id) {
		try {
			HangGhe entity = entityManager.find(HangGhe.class, id);
			return entity;
		} catch (Exception e) {

		}
		return null;
	}

}
