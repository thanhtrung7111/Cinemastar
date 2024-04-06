package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.NhanVien;
import model.ThanhPho;
import ultis.JpaUltis;

public class NhanVienDAO implements EntityDAO<NhanVien> {
	private EntityManager entityManager = JpaUltis.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public NhanVien create(NhanVien entity) {
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
	public NhanVien update(NhanVien entity) {
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
			NhanVien entity = entityManager.find(NhanVien.class, id);
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<NhanVien> selectAll() {
		String jpql = "SELECT o from NhanVien o";
		TypedQuery<NhanVien> query = entityManager.createQuery(jpql, NhanVien.class);
		List<NhanVien> nhanViens = query.getResultList();
		return nhanViens;
	}

	public String maxIDNhanVien() {
		String jpql = "SELECT max(t.maNhanVien) from NhanVien t";
		TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
		return query.getSingleResult();
	}

	@Override
	public NhanVien findById(String id) {
		try {
			NhanVien entity = entityManager.find(NhanVien.class, id);
			return entity;
		} catch (Exception e) {

		}
		return null;
	}

}
