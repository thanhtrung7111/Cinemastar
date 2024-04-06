package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Ghe;
import model.ThanhPho;
import ultis.JpaUltis;

public class GheDAO implements EntityDAO<Ghe> {

	private EntityManager entityManager = JpaUltis.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public Ghe create(Ghe entity) {
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
	public Ghe update(Ghe entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Ghe> selectAll() {
		String jpql = "SELECT o from Ghe o";
		TypedQuery<Ghe> query = entityManager.createQuery(jpql, Ghe.class);
		List<Ghe> ghes = query.getResultList();
		return ghes;
	}

	public String maxIDGhe() {
		String jpql = "SELECT max(t.maGhe) from Ghe t";
		TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
		return query.getSingleResult();
	}

	@Override
	public Ghe findById(String id) {
		try {
			Ghe entity = entityManager.find(Ghe.class, id);
			return entity;
		} catch (Exception e) {

		}
		return null;
	}
}
