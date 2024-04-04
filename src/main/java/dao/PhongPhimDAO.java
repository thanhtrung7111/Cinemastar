package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.PhongPhim;
import model.ThanhPho;
import ultis.JpaUltis;

public class PhongPhimDAO implements EntityDAO<PhongPhim> {
	private EntityManager entityManager = JpaUltis.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public PhongPhim create(PhongPhim entity) {
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
	public PhongPhim update(PhongPhim entity) {
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
			PhongPhim entity = entityManager.find(PhongPhim.class, id);
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<PhongPhim> selectAll() {
		String jpql = "SELECT o from PhongPhim o";
		TypedQuery<PhongPhim> query = entityManager.createQuery(jpql, PhongPhim.class);
		List<PhongPhim> phongPhims = query.getResultList();
		return phongPhims;
	}

	public String maxIDPhongPhim() {
		String jpql = "SELECT max(t.maPhongPhim) from PhongPhim t";
		TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
		return query.getSingleResult();
	}

	@Override
	public PhongPhim findById(String id) {
		try {
			PhongPhim entity = entityManager.find(PhongPhim.class, id);
			return entity;
		} catch (Exception e) {

		}
		return null;
	}

}
