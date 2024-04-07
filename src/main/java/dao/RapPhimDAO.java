package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.RapPhim;
import model.ThanhPho;
import ultis.JpaUltis;

public class RapPhimDAO implements EntityDAO<RapPhim> {
	private EntityManager entityManager = JpaUltis.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public RapPhim create(RapPhim entity) {
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
	public RapPhim update(RapPhim entity) {
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
			RapPhim entity = entityManager.find(RapPhim.class, id);
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<RapPhim> selectAll() {
		String jpql = "SELECT o from RapPhim o";
		TypedQuery<RapPhim> query = entityManager.createQuery(jpql, RapPhim.class);
		List<RapPhim> rapPhims = query.getResultList();
		return rapPhims;
	}

	public List<RapPhim> selectAllByCity(String maThanhPho) {
		String jpql = "SELECT o from RapPhim o where o.thanhPho.maThanhPho = :thanhPho";
		TypedQuery<RapPhim> query = entityManager.createQuery(jpql, RapPhim.class);
		query.setParameter("thanhPho", maThanhPho);
		List<RapPhim> rapPhims = query.getResultList();
		return rapPhims;
	}

	public List<RapPhim> selectAllByCityAndName(String maThanhPho, String name) {
		String jpql = "SELECT o from RapPhim o where o.thanhPho.maThanhPho = :thanhPho and o.tenRapPhim = :name";
		TypedQuery<RapPhim> query = entityManager.createQuery(jpql, RapPhim.class);
		query.setParameter("thanhPho", maThanhPho);
		List<RapPhim> rapPhims = query.getResultList();
		return rapPhims;
	}

	public String maxIDRapPhim() {
		String jpql = "SELECT max(t.maRapPhim) from RapPhim t";
		TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
		return query.getSingleResult();
	}

	@Override
	public RapPhim findById(String id) {
		try {
			RapPhim entity = entityManager.find(RapPhim.class, id);
			return entity;
		} catch (Exception e) {

		}
		return null;
	}

}
