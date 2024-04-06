package admincontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.LoaiNhanVien;
import model.ThanhPho;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import dao.LoaiNhanVienDAO;
import dao.ThanhPhoDAO;

/**
 * Servlet implementation class LoaiNhanVienServlet
 */
@WebServlet({ "/admin/loainhanviens", "/admin/createloainhanvien", "/admin/updateloainhanvien",
		"/admin/deleteloainhanvien" })
public class LoaiNhanVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoaiNhanVienDAO loaiNhanVienDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoaiNhanVienServlet() {
		super();
		loaiNhanVienDAO = new LoaiNhanVienDAO();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.contains("loainhanviens")) {
			List<LoaiNhanVien> loaiNhanViens = loaiNhanVienDAO.selectAll();
			req.setAttribute("loaiNhanViens", loaiNhanViens);
			req.setAttribute("view", "/views/admin/loainhanvien/list.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		} else if (uri.contains("createloainhanvien")) {
			createLoaiNhanVien(req, resp);
		} else if (uri.contains("updateloainhanvien")) {
			updateLoaiNhanVien(req, resp);
		} else if (uri.contains("deleteloainhanvien")) {
			deleteLoaiNhanVien(req, resp);
		}
	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private void createLoaiNhanVien(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			try {
				LoaiNhanVien loaiNhanVien = new LoaiNhanVien();
				BeanUtils.populate(loaiNhanVien, req.getParameterMap());
				loaiNhanVienDAO.create(loaiNhanVien);
				resp.sendRedirect("/cinemastar/admin/loainhanviens");

			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			req.setAttribute("view", "/views/admin/loainhanvien/create.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}
	}

	private void updateLoaiNhanVien(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			try {
				LoaiNhanVien loaiNhanVien = new LoaiNhanVien();
				BeanUtils.populate(loaiNhanVien, req.getParameterMap());
				loaiNhanVienDAO.update(loaiNhanVien);
				resp.sendRedirect("/cinemastar/admin/loainhanviens");
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			LoaiNhanVien loaiNhanVien = loaiNhanVienDAO.findById(req.getParameter("maLoaiNhanVien"));
			req.setAttribute("loaiNhanVien", loaiNhanVien);
			req.setAttribute("view", "/views/admin/loainhanvien/update.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}
	}

	private void deleteLoaiNhanVien(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("maLoaiNhanVien");
		loaiNhanVienDAO.delete(id);
		resp.sendRedirect("/cinemastar/admin/loainhanviens");
	}

}
