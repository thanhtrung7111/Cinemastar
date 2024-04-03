package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.ThanhPho;
import ultis.JpaUltis;

public class ThanhPhoDAO implements EntityDAO<ThanhPho> {
	private EntityManager entityManager = JpaUltis.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public ThanhPho create(ThanhPho entity) {
		System.out.println(entity.getMaThanhPho());
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
	public ThanhPho update(ThanhPho entity) {
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
			ThanhPho entity = entityManager.find(ThanhPho.class, id);
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<ThanhPho> selectAll() {
		String jpql = "SELECT o from ThanhPho o";
		TypedQuery<ThanhPho> query = entityManager.createQuery(jpql, ThanhPho.class);
		List<ThanhPho> thanhPhos = query.getResultList();
		return thanhPhos;
	}

	public Long countThanhPho() throws Exception {
		try {
			String jpql = "SELECT COUNT(*) from ThanhPho";
			TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
			return query.getSingleResult();
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public String maxIDThanhPho() {
		String jpql = "SELECT max(t.maThanhPho) from ThanhPho t";
		TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
		return query.getSingleResult();
	}

	@Override
	public ThanhPho findById(String id) {
		try {
			ThanhPho entity = entityManager.find(ThanhPho.class, id);
			return entity;
		} catch (Exception e) {

		}
		return null;
	}
}
