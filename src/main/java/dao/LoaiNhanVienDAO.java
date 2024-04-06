package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.LoaiNhanVien;
import model.ThanhPho;
import ultis.JpaUltis;

public class LoaiNhanVienDAO implements EntityDAO<LoaiNhanVien> {

	private EntityManager entityManager = JpaUltis.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public LoaiNhanVien create(LoaiNhanVien entity) {
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
	public LoaiNhanVien update(LoaiNhanVien entity) {
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
			LoaiNhanVien entity = entityManager.find(LoaiNhanVien.class, id);
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<LoaiNhanVien> selectAll() {
		String jpql = "SELECT o from LoaiNhanVien o";
		TypedQuery<LoaiNhanVien> query = entityManager.createQuery(jpql, LoaiNhanVien.class);
		List<LoaiNhanVien> loaiNhanViens = query.getResultList();
		return loaiNhanViens;
	}

	public String maxIDLoaiNhanVien() {
		String jpql = "SELECT max(t.maLoaiNhanVien) from LoaiNhanVien t";
		TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
		return query.getSingleResult();
	}

	@Override
	public LoaiNhanVien findById(String id) {
		try {
			LoaiNhanVien entity = entityManager.find(LoaiNhanVien.class, id);
			return entity;
		} catch (Exception e) {

		}
		return null;
	}
}
