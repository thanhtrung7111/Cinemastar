package helper;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import dao.LoaiTaiKhoanDAO;
import dao.NhanVienDAO;

public class NhanVienGeneratorID implements IdentifierGenerator{
	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		NhanVienDAO nhanVienDAO = new NhanVienDAO();
		String id = nhanVienDAO.maxIDNhanVien();
		String result = "";
		if (id == null || id.equals("")) {
			result = "NV00000000";
		} else {
			int number = Integer.parseInt(id.substring(2));
			result = String.format("%s%08d", "NV", ++number);
		}
		return result;
	}
}
