package admincontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ComboDoAn;
import model.LoaiHinh;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import dao.LoaiHinhDAO;

/**
 * Servlet implementation class LoaiHinhServlet
 */
@WebServlet({ "/admin/loaihinhs", "/admin/createloaihinh", "/admin/updateloaihinh", "/admin/deleteloaihinh" })
public class LoaiHinhServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoaiHinhDAO loaiHinhDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoaiHinhServlet() {
		super();
		loaiHinhDAO = new LoaiHinhDAO();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if(uri.contains("loaihinhs")) {
			List<LoaiHinh> loaiHinhs = loaiHinhDAO.selectAll();
			
			req.setAttribute("loaiHinhs", loaiHinhs);
			req.setAttribute("view", "/views/admin/loaihinh/list.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}else if(uri.contains("createloaihinh")) {
			createLoaiHinh(req, resp);
		}else if(uri.contains("updateloaihinh")) {
			updateLoaiHinh(req, resp);
		}else if(uri.contains("deleteloaihinh")) {
			deleteLoaiHinh(req, resp);
		}
		
	}

	private void createLoaiHinh(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			try {
				LoaiHinh loaiHinh = new LoaiHinh();
				BeanUtils.populate(loaiHinh, req.getParameterMap());
				loaiHinhDAO.create(loaiHinh);
				resp.sendRedirect("/cinemastar/admin/loaihinhs");
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			req.setAttribute("view", "/views/admin/loaihinh/create.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}
	}

	private void updateLoaiHinh(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			try {
				LoaiHinh loaiHinh = new LoaiHinh();
				BeanUtils.populate(loaiHinh, req.getParameterMap());
				loaiHinhDAO.update(loaiHinh);
				resp.sendRedirect("/cinemastar/admin/loaihinhs");
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			LoaiHinh loaiHinh = loaiHinhDAO.findById(req.getParameter("maLoaiHinh"));
			req.setAttribute("combo", loaiHinh);
			req.setAttribute("view", "/views/admin/loaihinh/update.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}
	}

	private void deleteLoaiHinh(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("maLoaiHinh");
		loaiHinhDAO.delete(id);
		resp.sendRedirect("/cinemastar/admin/loaiHinhs");
	}
}
