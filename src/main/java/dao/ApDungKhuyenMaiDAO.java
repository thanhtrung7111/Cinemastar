package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import model.ApDungKhuyenMai;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApDungKhuyenMai update(ApDungKhuyenMai entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
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
