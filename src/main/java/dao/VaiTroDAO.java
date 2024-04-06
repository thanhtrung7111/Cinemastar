package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.ThanhPho;
import model.VaiTro;
import ultis.JpaUltis;

public class VaiTroDAO implements EntityDAO<VaiTro> {
	private EntityManager entityManager = JpaUltis.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public VaiTro create(VaiTro entity) {
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
	public VaiTro update(VaiTro entity) {
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
			VaiTro entity = entityManager.find(VaiTro.class, id);
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<VaiTro> selectAll() {
		String jpql = "SELECT o from VaiTro o";
		TypedQuery<VaiTro> query = entityManager.createQuery(jpql, VaiTro.class);
		List<VaiTro> vaiTros = query.getResultList();
		return vaiTros;
	}

	public String maxIDVaiTro() {
		String jpql = "SELECT max(t.maVaiTro) from VaiTro t";
		TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
		return query.getSingleResult();
	}

	@Override
	public VaiTro findById(String id) {
		try {
			VaiTro entity = entityManager.find(VaiTro.class, id);
			return entity;
		} catch (Exception e) {

		}
		return null;
	}

}
