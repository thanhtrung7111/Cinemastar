package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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
		EntityManager em = JpaUltis.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}

		return entity;

	}

	@Override
	public LoaiGhe update(LoaiGhe entity) {
		EntityManager em = JpaUltis.getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}

		return entity;

	}

	public String maxIDLoaiGhe() {
		String jpql = "SELECT max(t.maLoaiGhe) from LoaiGhe t";
		TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
		return query.getSingleResult();
	}

	@Override
	public boolean delete(String id) {
		EntityManager em = JpaUltis.getEntityManager();
		try {
			em.getTransaction().begin();
			LoaiGhe lg = em.find(LoaiGhe.class, id);
			em.remove(lg);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;

		} finally {
			em.close();
		}
		return true;

	}

	@Override
	public List<LoaiGhe> selectAll() {
		EntityManager em = JpaUltis.getEntityManager();
		String jpql = "SELECT lg FROM LoaiGhe lg";
		TypedQuery<LoaiGhe> query = em.createQuery(jpql, LoaiGhe.class);
		List<LoaiGhe> list = query.getResultList();
		return list;
	}

	@Override
	public LoaiGhe findById(String maLG) {
		EntityManager em = JpaUltis.getEntityManager();
		LoaiGhe entity = em.find(LoaiGhe.class, maLG);
		return entity;
	}

}
