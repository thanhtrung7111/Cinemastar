package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.DienVienDaoDien;
import model.KhuyenMai;
import model.Phim;
import model.SuatChieu;
import model.TaiKhoan;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import dao.DienVienDaoDienDAO;
import dao.KhuyenMaiDAO;
import dao.PhimDAO;
import dao.SuatChieuDAO;
import dao.TaiKhoanDAO;

/**
 * Servlet implementation class PageServlet
 */
@WebServlet({ "/trangchu", "/daodiens", "/dienviens", "/detaildienvien", "/phims", "/detailphim", "/uudais", "/login",
		"/register", "/confirmaccount", "/logout" })
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SuatChieuDAO suatChieuDAO;
	private PhimDAO phimDAO;
	private DienVienDaoDienDAO daoDienVienDaoDienDAO;
	private KhuyenMaiDAO khuyenMaiDAO;
	private TaiKhoanDAO taiKhoanDAO;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PageServlet() {
		super();
		suatChieuDAO = new SuatChieuDAO();
		phimDAO = new PhimDAO();
		daoDienVienDaoDienDAO = new DienVienDaoDienDAO();
		khuyenMaiDAO = new KhuyenMaiDAO();
		taiKhoanDAO = new TaiKhoanDAO();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.contains("trangchu")) {
			pageTrangChu(req, resp);
			req.getRequestDispatcher("/views/user/layout.jsp").forward(req, resp);
		} else if (uri.contains("daodiens")) {
			pageDaoDien(req, resp);
			req.getRequestDispatcher("/views/user/layout.jsp").forward(req, resp);
		} else if (uri.contains("dienviens")) {
			pageDienVien(req, resp);
			req.getRequestDispatcher("/views/user/layout.jsp").forward(req, resp);
		} else if (uri.contains("detaildienvien")) {
			pageDetailDienVien(req, resp);
			req.getRequestDispatcher("/views/user/layout.jsp").forward(req, resp);
		} else if (uri.contains("phims")) {
			pagePhims(req, resp);
			req.getRequestDispatcher("/views/user/layout.jsp").forward(req, resp);
		} else if (uri.contains("detailphim")) {
			pageDetailPhim(req, resp);
			req.getRequestDispatcher("/views/user/layout.jsp").forward(req, resp);
		} else if (uri.contains("uudais")) {
			pageUuDais(req, resp);
			req.getRequestDispatcher("/views/user/layout.jsp").forward(req, resp);
		} else if (uri.contains("login")) {
			doLogin(req, resp);
		} else if (uri.contains("logout")) {
			doLogout(req, resp);
		} else if (uri.contains("register")) {
			doRegister(req, resp);
		}

	}

	private void pageTrangChu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Phim> phims = phimDAO.selectAllOnDay();
		req.setAttribute("phims", phims);
		req.setAttribute("view", "/views/user/page/trangchu.jsp");
	}

	private void pageDaoDien(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<DienVienDaoDien> dienViens = daoDienVienDaoDienDAO.selectAllByRole("Đạo diễn");
		List<Phim> phimDangChieus = phimDAO.selectAllOnDay(0, 4);
		List<KhuyenMai> khuyenMais = khuyenMaiDAO.selectAllByDate(0, 4);
		req.setAttribute("khuyenMais", khuyenMais);
		req.setAttribute("phimDangChieus", phimDangChieus);
		req.setAttribute("dienViens", dienViens);
		req.setAttribute("title", "Đạo Diễn");
		req.setAttribute("view", "/views/user/page/dienviendaodien.jsp");
	}

	private void pageDienVien(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<DienVienDaoDien> dienViens = daoDienVienDaoDienDAO.selectAllByRole("Diễn viên");
		List<Phim> phimDangChieus = phimDAO.selectAllOnDay(0, 4);
		List<KhuyenMai> khuyenMais = khuyenMaiDAO.selectAllByDate(0, 4);
		req.setAttribute("khuyenMais", khuyenMais);
		req.setAttribute("phimDangChieus", phimDangChieus);
		req.setAttribute("dienViens", dienViens);
		req.setAttribute("title", "Diễn Viên");
		req.setAttribute("view", "/views/user/page/dienviendaodien.jsp");
	}

	private void pageDetailDienVien(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		DienVienDaoDien dienVien = daoDienVienDaoDienDAO.findById(req.getParameter("maDienVien"));
		List<Phim> phimDangChieus = phimDAO.selectAllOnDay(0, 4);
		dienVien.setLuotXem(dienVien.getLuotXem() + 1);
		daoDienVienDaoDienDAO.update(dienVien);
		List<Phim> phims = phimDAO.selectAllByDienVien(dienVien.getMaDV_DD());
		req.setAttribute("phimDangChieus", phimDangChieus);
		req.setAttribute("dienVien", dienVien);
		req.setAttribute("phims", phims);
		req.setAttribute("view", "/views/user/page/detaildienvien.jsp");
	}

	private void pagePhims(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Phim> phims = phimDAO.selectAll();
		List<Phim> phimDangChieus = phimDAO.selectAllOnDay(0, 4);
		List<KhuyenMai> khuyenMais = khuyenMaiDAO.selectAllByDate(0, 4);
		req.setAttribute("phimDangChieus", phimDangChieus);
		req.setAttribute("phims", phims);
		req.setAttribute("khuyenMais", khuyenMais);
		req.setAttribute("view", "/views/user/page/danhsachphim.jsp");
	}

	private void pageDetailPhim(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Phim phim = phimDAO.findById(req.getParameter("maPhim"));
		List<Phim> phimDangChieus = phimDAO.selectAllOnDay(0, 4);
		phim.setLuotXem(phim.getLuotXem() + 1);
		phimDAO.update(phim);
		List<DienVienDaoDien> dienViens = daoDienVienDaoDienDAO.selectAllByPhim(phim.getMaPhim());
		List<KhuyenMai> khuyenMais = khuyenMaiDAO.selectAllByDate(0, 4);
		req.setAttribute("khuyenMais", khuyenMais);
		req.setAttribute("phimDangChieus", phimDangChieus);
		req.setAttribute("phim", phim);
		req.setAttribute("dienViens", dienViens);
		req.setAttribute("view", "/views/user/page/detailphim.jsp");
	}

	private void pageUuDais(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Phim> phimDangChieus = phimDAO.selectAllOnDay(0, 4);
		List<KhuyenMai> khuyenMais = khuyenMaiDAO.selectAllByDate(0, 4);
		req.setAttribute("khuyenMais", khuyenMais);
		req.setAttribute("phimDangChieus", phimDangChieus);
		req.setAttribute("view", "/views/user/page/danhsachuudai.jsp");
	}

	private void doLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("tenDangNhap");
		String password = req.getParameter("matKhau");
		TaiKhoan taiKhoan = taiKhoanDAO.findByIdAndPassword(username, password);
		if (taiKhoan != null) {
			req.getSession().setAttribute("user", taiKhoan);
			req.getSession().removeAttribute("errorlogin");
			resp.sendRedirect("/cinemastar/trangchu");
		} else {
			req.getSession().setAttribute("errorlogin", "Tài khoản hoặc mật khẩu không chính xác");
			resp.sendRedirect("/cinemastar/trangchu");
		}
	}

	private void doLogout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().removeAttribute("errorlogin");
		req.getSession().removeAttribute("user");
		resp.sendRedirect("/cinemastar/trangchu");
	}

	private void doRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			TaiKhoan taiKhoan = new TaiKhoan();
			DateTimeConverter dtc = new DateConverter(null);
			dtc.setPattern("yyyy-MM-dd");
			ConvertUtils.register(dtc, Date.class);
			BeanUtils.populate(taiKhoan, req.getParameterMap());
			taiKhoan.setLoaiTaiKhoan(null);
			req.setAttribute("view", "/views/user/page/confirmaccount.jsp");
			req.getRequestDispatcher("/views/user/layout.jsp").forward(req, resp);
		} catch (Exception e) {
			resp.sendRedirect("/cinemastar/trangchu");
		}
	}
}
