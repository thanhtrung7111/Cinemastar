package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Phim;
import model.ThanhPho;
import ultis.JpaUltis;

public class PhimDAO implements EntityDAO<Phim> {
	private EntityManager entityManager = JpaUltis.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public Phim create(Phim entity) {
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
	public Phim update(Phim entity) {
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
			Phim entity = entityManager.find(Phim.class, id);
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Phim> selectAll() {
		String jpql = "SELECT o from Phim o";
		TypedQuery<Phim> query = entityManager.createQuery(jpql, Phim.class);
		List<Phim> phims = query.getResultList();
		return phims;
	}

	public List<Phim> selectAllOnDay() {
		String jpql = "SELECT distinct o.phim from SuatChieu o where o.ngayChieu = CURRENT_DATE";
		TypedQuery<Phim> query = entityManager.createQuery(jpql, Phim.class);
		List<Phim> phims = query.getResultList();
		return phims;
	}

	public List<Phim> selectAllOnDay(int begin, int maxResult) {
		String jpql = "SELECT distinct o.phim from SuatChieu o where o.ngayChieu = CURRENT_DATE";
		TypedQuery<Phim> query = entityManager.createQuery(jpql, Phim.class);
		query.setFirstResult(begin);
		query.setMaxResults(maxResult);
		List<Phim> phims = query.getResultList();
		return phims;
	}

	public List<Phim> selectAllByDienVien(String maDienVien) {
		String jpql = "SELECT distinct o.phim from ThamGia o where o.dienVienDaoDien.maDV_DD = :maDienVien";
		TypedQuery<Phim> query = entityManager.createQuery(jpql, Phim.class);
		query.setParameter("maDienVien", maDienVien);

		List<Phim> phims = query.getResultList();
		return phims;
	}

	public String maxIDPhim() {
		String jpql = "SELECT max(t.maPhim) from Phim t";
		TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
		return query.getSingleResult();
	}

	@Override
	public Phim findById(String id) {
		try {
			Phim entity = entityManager.find(Phim.class, id);
			return entity;
		} catch (Exception e) {

		}
		return null;
	}
}
