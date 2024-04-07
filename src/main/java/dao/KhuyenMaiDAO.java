package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.KhuyenMai;
import model.ThanhPho;
import ultis.JpaUltis;

public class KhuyenMaiDAO implements EntityDAO<KhuyenMai> {
	private EntityManager entityManager = JpaUltis.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public KhuyenMai create(KhuyenMai entity) {
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
	public KhuyenMai update(KhuyenMai entity) {
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
			KhuyenMai entity = entityManager.find(KhuyenMai.class, id);
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<KhuyenMai> selectAll() {
		String jpql = "SELECT o from KhuyenMai o";
		TypedQuery<KhuyenMai> query = entityManager.createQuery(jpql, KhuyenMai.class);
		List<KhuyenMai> khuyenMais = query.getResultList();
		return khuyenMais;
	}
	
	public List<KhuyenMai> selectAllByDate() {
		String jpql = "SELECT o from KhuyenMai o where o.ngayApDung <= CURRENT_DATE and o.ngayKetThuc >= CURRENT_DATE";
		TypedQuery<KhuyenMai> query = entityManager.createQuery(jpql, KhuyenMai.class);
		List<KhuyenMai> khuyenMais = query.getResultList();
		return khuyenMais;
	}
	
	public List<KhuyenMai> selectAllByDate(int begin, int max) {
		String jpql = "SELECT o from KhuyenMai o where o.ngayApDung <= CURRENT_DATE and o.ngayKetThuc >= CURRENT_DATE";
		TypedQuery<KhuyenMai> query = entityManager.createQuery(jpql, KhuyenMai.class);
		query.setFirstResult(begin);
		query.setMaxResults(max);
		List<KhuyenMai> khuyenMais = query.getResultList();
		return khuyenMais;
	}
	
	public String maxIDKhuyenMai() {
		String jpql = "SELECT max(t.maKhuyenMai) from KhuyenMai t";
		TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
		if(query == null || query.equals("")) {
			return "KK00000000";
		}
		return query.getSingleResult();
	}


	@Override
	public KhuyenMai findById(String id) {
		try {
			KhuyenMai entity = entityManager.find(KhuyenMai.class, id);
			return entity;
		} catch (Exception e) {

		}
		return null;
	}

}
