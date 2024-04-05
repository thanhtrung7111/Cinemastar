package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.LoaiHinh;
import model.ThanhPho;
import ultis.JpaUltis;

public class LoaiHinhDAO implements EntityDAO<LoaiHinh> {

	private EntityManager entityManager = JpaUltis.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public LoaiHinh create(LoaiHinh entity) {
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
	public LoaiHinh update(LoaiHinh entity) {
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
			LoaiHinh entity = entityManager.find(LoaiHinh.class, id);
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<LoaiHinh> selectAll() {
		String jpql = "SELECT o from LoaiHinh o";
		TypedQuery<LoaiHinh> query = entityManager.createQuery(jpql, LoaiHinh.class);
		List<LoaiHinh> loaiHinhs = query.getResultList();
		return loaiHinhs;
	}

	public String maxIDLoaiHinh() {
		String jpql = "SELECT max(t.maLoaiHinh) from LoaiHinh t";
		TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
		return query.getSingleResult();
	}

	@Override
	public LoaiHinh findById(String id) {
		try {
			LoaiHinh entity = entityManager.find(LoaiHinh.class, id);
			return entity;
		} catch (Exception e) {

		}
		return null;
	}
}
