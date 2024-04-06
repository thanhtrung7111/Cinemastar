package admincontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.LoaiNhanVien;
import model.NhanVien;
import model.RapPhim;
import model.VaiTro;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import dao.LoaiNhanVienDAO;
import dao.NhanVienDAO;
import dao.RapPhimDAO;

/**
 * Servlet implementation class NhanVienServlet
 */
@WebServlet({ "/admin/nhanviens", "/admin/createnhanvien", "/admin/updatenhanvien", "/admin/deletenhanvien" })
public class NhanVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NhanVienDAO nhanVienDAO;
	private LoaiNhanVienDAO loaiNhanVienDAO;
	private RapPhimDAO rapPhimDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NhanVienServlet() {
		super();
		nhanVienDAO = new NhanVienDAO();
		loaiNhanVienDAO = new LoaiNhanVienDAO();
		rapPhimDAO = new RapPhimDAO();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.contains("nhanviens")) {
			List<NhanVien> nhanViens = nhanVienDAO.selectAll();
			req.setAttribute("nhanViens", nhanViens);
			req.setAttribute("view", "/views/admin/nhanvien/list.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		} else if (uri.contains("createnhanvien")) {
			createNhanVien(req, resp);
		} else if (uri.contains("updatenhanvien")) {
			updateNhanVien(req, resp);
		} else if (uri.contains("deletenhanvien")) {
			deleteNhanVien(req, resp);
		}
	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private void createNhanVien(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			try {
				System.out.print(req.getParameter("maloaiNhanVien"));
				DateTimeConverter dtc = new DateConverter(new Date());
				dtc.setPattern("MM/dd/yyyy");
				ConvertUtils.register(dtc, Date.class);
				NhanVien nhanVien = new NhanVien();
				RapPhim rapPhim = rapPhimDAO.findById(req.getParameter("maRapPhim"));
				LoaiNhanVien loaiNhanVien = loaiNhanVienDAO.findById(req.getParameter("maLoaiNhanVien"));
				BeanUtils.populate(nhanVien, req.getParameterMap());
				nhanVien.setRapPhim(rapPhim);
				nhanVien.setLoaiNhanVien(loaiNhanVien);
				nhanVienDAO.create(nhanVien);
				resp.sendRedirect("/cinemastar/admin/nhanviens");

			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			List<RapPhim> rapPhims = rapPhimDAO.selectAll();
			List<LoaiNhanVien> loaiNhanViens = loaiNhanVienDAO.selectAll();
			req.setAttribute("loaiNhanViens", loaiNhanViens);
			req.setAttribute("rapPhims", rapPhims);
			req.setAttribute("view", "/views/admin/nhanvien/create.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}
	}

	private void updateNhanVien(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			try {
				DateTimeConverter dtc = new DateConverter(new Date());
				dtc.setPattern("MM/dd/yyyy");
				ConvertUtils.register(dtc, Date.class);
				NhanVien nhanVien = new NhanVien();
				RapPhim rapPhim = rapPhimDAO.findById(req.getParameter("maRapPhim"));
				LoaiNhanVien loaiNhanVien = loaiNhanVienDAO.findById(req.getParameter("maLoaiNhanVien"));
				BeanUtils.populate(nhanVien, req.getParameterMap());
				nhanVien.setRapPhim(rapPhim);
				nhanVien.setLoaiNhanVien(loaiNhanVien);
				nhanVienDAO.update(nhanVien);
				resp.sendRedirect("/cinemastar/admin/nhanviens");
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			NhanVien nhanVien = nhanVienDAO.findById(req.getParameter("maNhanVien"));
			List<RapPhim> rapPhims = rapPhimDAO.selectAll();
			List<LoaiNhanVien> loaiNhanViens = loaiNhanVienDAO.selectAll();
			req.setAttribute("nhanVien", nhanVien);
			req.setAttribute("rapPhims", rapPhims);
			req.setAttribute("loaiNhanViens", loaiNhanViens);
			req.setAttribute("view", "/views/admin/nhanvien/update.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}
	}

	private void deleteNhanVien(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("maNhanVien");
		nhanVienDAO.delete(id);
		resp.sendRedirect("/cinemastar/admin/nhanviens");
	}

}
