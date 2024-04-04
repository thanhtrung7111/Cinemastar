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
		String result="";
		if (id == null || id.equals("")) {
			result = "KK00000000";
		} else {
			int number = Integer.parseInt(id.substring(2));
			result = String.format("%s%08d", "KK", ++number);
		}
		return result;
	}
}
