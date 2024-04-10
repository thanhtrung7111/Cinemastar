package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import model.ApDungKhuyenMai;
import model.HangGhe;
import ultis.JpaUltis;

public class ApDungKhuyenMaiDAO implements EntityDAO<ApDungKhuyenMai> {
	EntityManager entityManager = JpaUltis.getEntityManager();
	
	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public ApDungKhuyenMai create(ApDungKhuyenMai entity) {

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
	public ApDungKhuyenMai update(ApDungKhuyenMai entity) {
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
			ApDungKhuyenMai entity = entityManager.find(ApDungKhuyenMai.class, id);
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<ApDungKhuyenMai> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApDungKhuyenMai findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
