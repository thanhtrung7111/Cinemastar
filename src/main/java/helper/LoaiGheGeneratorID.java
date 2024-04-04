package helper;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import dao.KhuyenMaiDAO;
import dao.LoaiGheDAO;

public class LoaiGheGeneratorID implements IdentifierGenerator {
	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		LoaiGheDAO loaiGheDAO = new LoaiGheDAO();
		String id = loaiGheDAO.maxIDLoaiGhe();
		String result = "";
		if (id == null || id.equals("")) {
			result = "LG00000000";
		} else {
			int number = Integer.parseInt(id.substring(2));
			result = String.format("%s%08d", "LG", ++number);
		}
		return result;
	}
}
