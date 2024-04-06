package admincontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Ghe;
import model.HangGhe;
import model.LoaiGhe;
import model.PhongPhim;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import dao.GheDAO;
import dao.HangGheDAO;
import dao.LoaiGheDAO;
import dao.PhongPhimDAO;

/**
 * Servlet implementation class GheServlet
 */
@WebServlet({ "/admin/ghes", "/admin/createghe", "/admin/updateghe", "/admin/deleteghe" })
public class GheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoaiGheDAO loaiGheDAO;
	private PhongPhimDAO phongPhimDAO;
	private HangGheDAO hangGheDAO;
	private GheDAO gheDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GheServlet() {
		super();
		loaiGheDAO = new LoaiGheDAO();
		phongPhimDAO = new PhongPhimDAO();
		hangGheDAO = new HangGheDAO();
		gheDAO = new GheDAO();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.contains("ghes")) {
			List<Ghe> ghes = gheDAO.selectAll();
			req.setAttribute("ghes", ghes);
			req.setAttribute("view", "/views/admin/ghe/list.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		} else if (uri.contains("createghe")) {
			createGhe(req, resp);
		} else if (uri.contains("updateghe")) {
			updateGhe(req, resp);
		} else if (uri.contains("deleteghe")) {
			deleteGhe(req, resp);
		}

	}

	private void createGhe(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			PhongPhim phongPhim = phongPhimDAO.findById(req.getParameter("maPhongPhim"));
			LoaiGhe loaiGhe = loaiGheDAO.findById(req.getParameter("maLoaiGhe"));
			List<HangGhe> hangGhes = hangGheDAO.selectAll();
			for (HangGhe hangGhe : hangGhes) {
				for (int i = 1; i <= 10; i++) {
					Ghe ghe = new Ghe();
					ghe.setTenGhe(hangGhe.getTenHangGhe() + i);
					ghe.setLoaiGhe(loaiGhe);
					ghe.setPhongPhim(phongPhim);
					ghe.setHangGhe(hangGhe);

					gheDAO.create(ghe);
				}
			}
			resp.sendRedirect("/cinemastar/admin/ghes");
		} else {
			List<LoaiGhe> loaiGhes = loaiGheDAO.selectAll();
			List<PhongPhim> phongPhims = phongPhimDAO.selectAll();
			req.setAttribute("loaiGhes", loaiGhes);
			req.setAttribute("phongPhims", phongPhims);
			req.setAttribute("view", "/views/admin/ghe/create.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}
	}

	private void updateGhe(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//		if (req.getMethod().equalsIgnoreCase("post")) {
//			try {
//				HangGhe hangGhe = new HangGhe();
//				BeanUtils.populate(hangGhe, req.getParameterMap());
//				hangGheDAO.update(hangGhe);
//				resp.sendRedirect("/cinemastar/admin/hangghes");
//			} catch (IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InvocationTargetException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		} else {
//			List<LoaiGhe> loaiGhes = loaiGheDAO.selectAll();
//			List<PhongPhim> phongPhims = phongPhimDAO.selectAll();
//			req.setAttribute("hangGhe", hangGhe);
//			req.setAttribute("loaiGhes", loaiGhes);
//			req.setAttribute("phongPhims", phongPhims);
//			req.setAttribute("view", "/views/admin/hangghe/update.jsp");
//			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
//		}
	}

	private void deleteGhe(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//		String id = req.getParameter("maHangGhe");
//		hangGheDAO.delete(id);
//		resp.sendRedirect("/cinemastar/admin/hangghes");
	}

}
