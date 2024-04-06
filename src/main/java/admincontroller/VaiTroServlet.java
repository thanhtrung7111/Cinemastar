package admincontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ThanhPho;
import model.VaiTro;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import dao.ThanhPhoDAO;
import dao.VaiTroDAO;

/**
 * Servlet implementation class VaiTroServlet
 */
@WebServlet({ "/admin/vaitros", "/admin/createvaitro", "/admin/updatevaitro", "/admin/deletevaitro" })
public class VaiTroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VaiTroDAO vaiTroDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VaiTroServlet() {
		super();
		vaiTroDAO = new VaiTroDAO();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.contains("vaitros")) {
			List<VaiTro> vaiTros = vaiTroDAO.selectAll();
			req.setAttribute("vaiTros", vaiTros);
			req.setAttribute("view", "/views/admin/vaitro/list.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		} else if (uri.contains("createvaitro")) {
			createVaiTro(req, resp);
		} else if (uri.contains("updatevaitro")) {
			updateVaiTro(req, resp);
		} else if (uri.contains("deletevaitro")) {
			deleteVaiTro(req, resp);
		}
	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private void createVaiTro(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			try {
				VaiTro vaiTro = new VaiTro();
				BeanUtils.populate(vaiTro, req.getParameterMap());
				vaiTroDAO.create(vaiTro);
				resp.sendRedirect("/cinemastar/admin/vaitros");

			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			req.setAttribute("view", "/views/admin/vaitro/create.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}
	}

	private void updateVaiTro(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			try {
				VaiTro vaiTro = new VaiTro();
				BeanUtils.populate(vaiTro, req.getParameterMap());
				vaiTroDAO.update(vaiTro);
				resp.sendRedirect("/cinemastar/admin/vaitros");
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			VaiTro vaiTro = vaiTroDAO.findById(req.getParameter("maVaiTro"));
			req.setAttribute("vaiTro", vaiTro);
			req.setAttribute("view", "/views/admin/vaitro/update.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}
	}

	private void deleteVaiTro(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("maVaiTro");
		vaiTroDAO.delete(id);
		resp.sendRedirect("/cinemastar/admin/vaitros");
	}

}
