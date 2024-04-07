package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.DienVienDaoDien;
import model.ThanhPho;
import ultis.JpaUltis;

public class DienVienDaoDienDAO implements EntityDAO<DienVienDaoDien> {

	private EntityManager entityManager = JpaUltis.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public DienVienDaoDien create(DienVienDaoDien entity) {
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
	public DienVienDaoDien update(DienVienDaoDien entity) {
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
			DienVienDaoDien entity = entityManager.find(DienVienDaoDien.class, id);
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<DienVienDaoDien> selectAll() {
		String jpql = "SELECT o from DienVienDaoDien o";
		TypedQuery<DienVienDaoDien> query = entityManager.createQuery(jpql, DienVienDaoDien.class);
		List<DienVienDaoDien> dienVienDaoDiens = query.getResultList();
		return dienVienDaoDiens;
	}
	

	public List<DienVienDaoDien> selectAllByRole(String name) {
		String jpql = "SELECT o from DienVienDaoDien o where o.vaiTro.tenVaiTro = :name";
		TypedQuery<DienVienDaoDien> query = entityManager.createQuery(jpql, DienVienDaoDien.class);
		query.setParameter("name", name);
		List<DienVienDaoDien> dienVienDaoDiens = query.getResultList();
		return dienVienDaoDiens;
	}
	
	

	public String maxIDDienVien() {
		String jpql = "SELECT max(t.maDV_DD) from DienVienDaoDien t";
		TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
		return query.getSingleResult();
	}

	@Override
	public DienVienDaoDien findById(String id) {
		try {
			DienVienDaoDien entity = entityManager.find(DienVienDaoDien.class, id);
			return entity;
		} catch (Exception e) {

		}
		return null;
	}
}
