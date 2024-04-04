package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.ComboDoAn;
import model.ThanhPho;
import ultis.JpaUltis;

public class ComboDoAnDAO implements EntityDAO<ComboDoAn> {
	private EntityManager entityManager = JpaUltis.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public ComboDoAn create(ComboDoAn entity) {
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
	public ComboDoAn update(ComboDoAn entity) {
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
			ComboDoAn entity = entityManager.find(ComboDoAn.class, id);
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<ComboDoAn> selectAll() {
		String jpql = "SELECT o from ComboDoAn o";
		TypedQuery<ComboDoAn> query = entityManager.createQuery(jpql, ComboDoAn.class);
		List<ComboDoAn> combos = query.getResultList();
		return combos;
	}

	public String maxIDCombo() {
		String jpql = "SELECT max(t.maCombo) from ComboDoAn t";
		TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
		return query.getSingleResult();
	}

	@Override
	public ComboDoAn findById(String id) {
		try {
			ComboDoAn entity = entityManager.find(ComboDoAn.class, id);
			return entity;
		} catch (Exception e) {

		}
		return null;
	}
}
