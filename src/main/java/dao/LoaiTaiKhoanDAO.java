package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.LoaiTaiKhoan;
import model.ThanhPho;
import ultis.JpaUltis;

public class LoaiTaiKhoanDAO implements EntityDAO<LoaiTaiKhoan> {

	private EntityManager entityManager = JpaUltis.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public LoaiTaiKhoan create(LoaiTaiKhoan entity) {
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
	public LoaiTaiKhoan update(LoaiTaiKhoan entity) {
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
			LoaiTaiKhoan entity = entityManager.find(LoaiTaiKhoan.class, id);
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<LoaiTaiKhoan> selectAll() {
		String jpql = "SELECT o from LoaiTaiKhoan o";
		TypedQuery<LoaiTaiKhoan> query = entityManager.createQuery(jpql, LoaiTaiKhoan.class);
		List<LoaiTaiKhoan> loaiTaiKhoans = query.getResultList();
		return loaiTaiKhoans;
	}

	public String maxIDLoaiTaiKhoan() {
		String jpql = "SELECT max(t.maLoaiTaiKhoan) from LoaiTaiKhoan t";
		TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
		return query.getSingleResult();
	}

	@Override
	public LoaiTaiKhoan findById(String id) {
		try {
			LoaiTaiKhoan entity = entityManager.find(LoaiTaiKhoan.class, id);
			return entity;
		} catch (Exception e) {

		}
		return null;
	}
}
