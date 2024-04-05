package helper;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import dao.LoaiGheDAO;
import dao.LoaiHinhDAO;

public class LoaiHinhGeneratorID implements IdentifierGenerator{
	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		LoaiHinhDAO loaiHinhDAO = new LoaiHinhDAO();
		String id = loaiHinhDAO.maxIDLoaiHinh();
		String result = "";
		if (id == null || id.equals("")) {
			result = "LH00000000";
		} else {
			int number = Integer.parseInt(id.substring(2));
			result = String.format("%s%08d", "LH", ++number);
		}
		return result;
	}
}
