package helper;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import dao.ComboDoAnDAO;
import dao.HoaDonDAO;

public class HoaDonGeneratorID implements IdentifierGenerator{
	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		HoaDonDAO hoaDonDAO = new HoaDonDAO();
		String id = hoaDonDAO.maxIDHoaDon();
		String result = "";
		if (id == null || id.equals("")) {
			result = "HD00000000";
		} else {
			int number = Integer.parseInt(id.substring(2));
			result = String.format("%s%08d", "HD", ++number);
		}
		return result;
	}
}
