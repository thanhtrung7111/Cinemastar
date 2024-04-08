package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Phim;
import model.RapPhim;

import java.io.IOException;
import java.util.List;

import dao.PhimDAO;
import dao.RapPhimDAO;

/**
 * Servlet implementation class PageUserServlet
 */
@WebServlet({ "/user/chonsuat","/user/chonghe" })
public class PageUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PhimDAO phimDAO;
	private RapPhimDAO rapPhimDAO;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PageUserServlet() {
		super();
		phimDAO = new PhimDAO();
		rapPhimDAO = new RapPhimDAO();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.contains("chonsuat")) {
			doChonSuat(req, resp);
		}
	}

	private void doChonSuat(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String maPhim = req.getParameter("maPhim");
		Phim phim = phimDAO.findById(maPhim);
		List<RapPhim> rapPhims = rapPhimDAO.selectAllByPhim(maPhim);
		req.getSession().setAttribute("phim", phim);
		req.getSession().setAttribute("rapPhims", rapPhims);
		req.setAttribute("view", "/views/user/main/chonsuat.jsp");
		req.getRequestDispatcher("/views/user/layoutthanhtoan.jsp").forward(req, resp);
	}

}
