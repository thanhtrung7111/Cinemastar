package helper;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import dao.KhuyenMaiDAO;
import dao.ThanhPhoDAO;

public class KhuyenMaiGeneratorID implements IdentifierGenerator{
	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		KhuyenMaiDAO khuyenMaiDAO = new KhuyenMaiDAO();
		String id = khuyenMaiDAO.maxIDKhuyenMai();
		int number = Integer.parseInt(id.substring(2));
		String result =String.format("%s%08d","KK",++number);
		return result;
	}
}
