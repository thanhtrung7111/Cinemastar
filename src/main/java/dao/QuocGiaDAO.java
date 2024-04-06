package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.QuocGia;
import model.ThanhPho;
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
			System.out.println(e);
		}
		return null;
	}

	@Override
	public QuocGia update(QuocGia entity) {
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
			QuocGia entity = entityManager.find(QuocGia.class, id);
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<QuocGia> selectAll() {
		String jpql = "SELECT o from QuocGia o";
		TypedQuery<QuocGia> query = entityManager.createQuery(jpql, QuocGia.class);
		List<QuocGia> quocGias = query.getResultList();
		return quocGias;
	}

	public String maxIDQuocGia() {
		String jpql = "SELECT max(t.maQuocGia) from QuocGia t";
		TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
		return query.getSingleResult();
	}

	@Override
	public QuocGia findById(String id) {
		try {
			QuocGia entity = entityManager.find(QuocGia.class, id);
			return entity;
		} catch (Exception e) {

		}
		return null;
	}
}
