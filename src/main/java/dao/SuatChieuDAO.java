package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.SuatChieu;
import model.ThanhPho;
import ultis.JpaUltis;

public class SuatChieuDAO implements EntityDAO<SuatChieu> {
	private EntityManager entityManager = JpaUltis.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public SuatChieu create(SuatChieu entity) {
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
	public SuatChieu update(SuatChieu entity) {
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
			SuatChieu entity = entityManager.find(SuatChieu.class, id);
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<SuatChieu> selectAll() {
		String jpql = "SELECT o from SuatChieu o";
		TypedQuery<SuatChieu> query = entityManager.createQuery(jpql, SuatChieu.class);
		List<SuatChieu> suatChieus = query.getResultList();
		return suatChieus;
	}
	
	public List<SuatChieu> selectAllOnDay() {
		String jpql = "SELECT o from SuatChieu o where o.ngayChieu = CURRENT_DATE";
		TypedQuery<SuatChieu> query = entityManager.createQuery(jpql, SuatChieu.class);
		List<SuatChieu> suatChieus = query.getResultList();
		return suatChieus;
	}

	public String maxIDSuatChieu() {
		String jpql = "SELECT max(t.maSuatChieu) from SuatChieu t";
		TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
		return query.getSingleResult();
	}

	@Override
	public SuatChieu findById(String id) {
		try {
			SuatChieu entity = entityManager.find(SuatChieu.class, id);
			return entity;
		} catch (Exception e) {

		}
		return null;
	}

}
