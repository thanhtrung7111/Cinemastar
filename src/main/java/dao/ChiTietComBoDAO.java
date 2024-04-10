package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import model.ChiTietCombo;
import model.HangGhe;
import ultis.JpaUltis;

public class ChiTietComBoDAO implements EntityDAO<ChiTietCombo> {

	private EntityManager entityManager = JpaUltis.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public ChiTietCombo create(ChiTietCombo entity) {

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
	public ChiTietCombo update(ChiTietCombo entity) {
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
			ChiTietCombo entity = entityManager.find(ChiTietCombo.class, id);
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<ChiTietCombo> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChiTietCombo findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
