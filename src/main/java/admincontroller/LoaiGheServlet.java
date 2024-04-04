package admincontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.LoaiGhe;

import java.io.IOException;
import java.util.List;
import javax.security.auth.callback.ConfirmationCallback;

import dao.LoaiGheDAO;

/**
 * Servlet implementation class LoaiGheServlet
 */
@WebServlet({ "/admin/loaighes", "/admin/createloaighe", "/admin/updateloaighe", "/admin/deleteloaighe" })
public class LoaiGheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoaiGheServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.contains("/loaighes")) {
			doLoaiGheList(req, resp);
		} else if (uri.contains("/createloaighe")) {
			doLoaiGheCreate(req, resp);
		} else if (uri.contains("/updateloaighe")) {
			doUpdateLoaiGhe(req, resp);
		} else if (uri.contains("/deleteloaighe")) {
			doDeleteLoaiGhe(req, resp);
		}
	}

	private void doLoaiGheCreate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getMethod().equalsIgnoreCase("POST")) {

			String maLoaiGhe = request.getParameter("maLoaiGhe");
			String tenLoaiGhe = request.getParameter("tenLoaiGhe");
			String chiPhi = request.getParameter("chiPhi");
			System.out.println(maLoaiGhe);
			LoaiGheDAO lgDAO = new LoaiGheDAO();
			LoaiGhe lg = new LoaiGhe(maLoaiGhe, tenLoaiGhe, Double.parseDouble(chiPhi));
			lgDAO.create(lg);
			System.out.println("Thêm thành công");
//				request.setAttribute("alertMessage", "Bạn vừa thêm mới thành công 1 loại ghế: " +tenLoaiGhe);
//				request.getSession().setAttribute("alertBoolean", true);
			response.sendRedirect("/cinemastar/admin/loaighes");

		} else {// GET METHOD
			request.setAttribute("alertBoolean", false);
			request.setAttribute("view", "/views/admin/loaighe/loaiGheCreate.jsp");
			request.getRequestDispatcher("/views/admin/layout.jsp").forward(request, response);
		}
	}

	private void doUpdateLoaiGhe(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getMethod().equalsIgnoreCase("POST")) {

			String maLoaiGhe = request.getParameter("maLG");
			String tenLoaiGhe = request.getParameter("tenLoaiGhe");
			String chiPhi = request.getParameter("chiPhi");
			LoaiGheDAO lgDAO = new LoaiGheDAO();
			LoaiGhe lg = new LoaiGhe(maLoaiGhe, tenLoaiGhe, Double.parseDouble(chiPhi));
			lgDAO.update(lg);
//				request.setAttribute("alertMessage", "Bạn vừa thêm mới thành công 1 loại ghế: " +tenLoaiGhe);
//				request.getSession().setAttribute("alertBoolean", true);
			response.sendRedirect("/cinemastar/admin/loaighes");

		} else { // GET METHOD
//			request.setAttribute("alertBoolean", false);
			String maLoaiGhe = request.getParameter("IdLG");
			LoaiGheDAO lgDAO = new LoaiGheDAO();
			LoaiGhe lg = lgDAO.findById(maLoaiGhe);
			request.setAttribute("lg", lg);
			System.out.println(lg.getMaLoaiGhe());
			request.setAttribute("view", "/views/admin/loaighe/loaiGheUpdate.jsp");
			request.getRequestDispatcher("/views/admin/layout.jsp").forward(request, response);
		}
	}

	private void doDeleteLoaiGhe(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String maLoaiGhe = request.getParameter("IdLG");
		System.out.println(maLoaiGhe);
		LoaiGheDAO lgDAO = new LoaiGheDAO();
		lgDAO.delete(maLoaiGhe);
		response.sendRedirect("/cinemastar/admin/loaighes");
	}

	private void doLoaiGheList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoaiGheDAO lgDAO = new LoaiGheDAO();
		List<LoaiGhe> lgList = lgDAO.selectAll();
		request.setAttribute("lgList", lgList);
		request.setAttribute("view", "/views/admin/loaighe/loaiGheList.jsp");
		request.getRequestDispatcher("/views/admin/layout.jsp").forward(request, response);
	}

}
