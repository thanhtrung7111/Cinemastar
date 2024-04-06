package helper;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import dao.ComboDoAnDAO;
import dao.VaiTroDAO;

public class VaiTroGeneratorID implements IdentifierGenerator {
	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		VaiTroDAO vaiTroDAO = new VaiTroDAO();
		String id = vaiTroDAO.maxIDVaiTro();
		String result = "";
		if (id == null || id.equals("")) {
			result = "VT00000000";
		} else {
			int number = Integer.parseInt(id.substring(2));
			result = String.format("%s%08d", "VT", ++number);
		}
		return result;
	}
}
