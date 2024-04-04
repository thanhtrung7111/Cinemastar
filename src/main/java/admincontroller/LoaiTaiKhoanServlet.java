package admincontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.LoaiTaiKhoan;
import model.ThanhPho;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import dao.LoaiTaiKhoanDAO;
import dao.ThanhPhoDAO;

/**
 * Servlet implementation class LoaiTaiKhoanServlet
 */
@WebServlet({ "/admin/loaitaikhoans", "/admin/createloaitaikhoan", "/admin/updateloaitaikhoan",
		"/admin/deleteloaitaikhoan" })
public class LoaiTaiKhoanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoaiTaiKhoanDAO loaiTaiKhoanDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoaiTaiKhoanServlet() {
		super();
		loaiTaiKhoanDAO = new LoaiTaiKhoanDAO();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.contains("loaitaikhoans")) {
			List<LoaiTaiKhoan> loaiTaiKhoans = loaiTaiKhoanDAO.selectAll();
			req.setAttribute("loaiTaiKhoans", loaiTaiKhoans);
			req.setAttribute("view", "/views/admin/loaitaikhoan/list.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		} else if (uri.contains("createloaitaikhoan")) {
			createLoaiTaiKhoan(req, resp);
		} else if (uri.contains("updateloaitaikhoan")) {
			updateLoaiTaiKhoan(req, resp);
		} else if (uri.contains("deleteloaitaikhoan")) {
			deleteLoaiTaiKhoan(req, resp);
		}

	}

	private void createLoaiTaiKhoan(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			try {
				LoaiTaiKhoan loaiTaiKhoan = new LoaiTaiKhoan();
				BeanUtils.populate(loaiTaiKhoan, req.getParameterMap());
				loaiTaiKhoanDAO.create(loaiTaiKhoan);
				resp.sendRedirect("/cinemastar/admin/loaitaikhoans");
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			req.setAttribute("view", "/views/admin/loaitaikhoan/create.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}
	}

	private void updateLoaiTaiKhoan(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			try {
				LoaiTaiKhoan loaiTaiKhoan = new LoaiTaiKhoan();
				BeanUtils.populate(loaiTaiKhoan, req.getParameterMap());
				loaiTaiKhoanDAO.update(loaiTaiKhoan);
				resp.sendRedirect("/cinemastar/admin/loaitaikhoans");
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			LoaiTaiKhoan loaiTaiKhoan = loaiTaiKhoanDAO.findById(req.getParameter("maLoaiTaiKhoan"));
			req.setAttribute("loaiTaiKhoan", loaiTaiKhoan);
			req.setAttribute("view", "/views/admin/loaitaikhoan/update.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}
	}

	private void deleteLoaiTaiKhoan(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("maLoaiTaiKhoan");
		loaiTaiKhoanDAO.delete(id);
		resp.sendRedirect("/cinemastar/admin/loaitaikhoans");
	}
}
