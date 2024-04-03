package helper;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import dao.ThanhPhoDAO;

public class ThanhPhoGeneratorID implements IdentifierGenerator {

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		ThanhPhoDAO thanhPhoDAO = new ThanhPhoDAO();
		String id = thanhPhoDAO.maxIDThanhPho();
		int number = Integer.parseInt(id.substring(2));
		String result =String.format("%s%08d","TT",++number);
		return result;
	}

}
