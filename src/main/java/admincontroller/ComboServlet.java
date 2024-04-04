package admincontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ComboDoAn;
import model.LoaiTaiKhoan;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import dao.ComboDoAnDAO;

/**
 * Servlet implementation class ComboServlet
 */
@WebServlet({"/admin/combos","/admin/createcombo","/admin/updatecombo","/admin/deletecombo"})
public class ComboServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private ComboDoAnDAO comboDoAnDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComboServlet() {
        super();
        comboDoAnDAO = new ComboDoAnDAO();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String uri = req.getRequestURI();
    	if(uri.contains("combos")) {
    		List<ComboDoAn> combos = comboDoAnDAO.selectAll();
    		req.setAttribute("combos", combos);
    		req.setAttribute("view","/views/admin/combo/list.jsp");
    		req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
    	}else if(uri.contains("createcombo")) {
    		createCombo(req, resp);
    	}else if(uri.contains("updatecombo")) {
    		updateCombo(req, resp);
    	}else if(uri.contains("deletecombo")) {
    		deleteCombo(req, resp);
    	}
    }

	private void createCombo(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			try {
				ComboDoAn combo = new ComboDoAn();
				BeanUtils.populate(combo, req.getParameterMap());
				comboDoAnDAO.create(combo);
				resp.sendRedirect("/cinemastar/admin/combos");
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			req.setAttribute("view", "/views/admin/combo/create.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}
	}

	private void updateCombo(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			try {
				ComboDoAn combo = new ComboDoAn();
				BeanUtils.populate(combo, req.getParameterMap());
				comboDoAnDAO.update(combo);
				resp.sendRedirect("/cinemastar/admin/combos");
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			ComboDoAn combo = comboDoAnDAO.findById(req.getParameter("maCombo"));
			req.setAttribute("combo", combo);
			req.setAttribute("view", "/views/admin/combo/update.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}
	}

	private void deleteCombo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("maCombo");
		comboDoAnDAO.delete(id);
		resp.sendRedirect("/cinemastar/admin/combos");
	}

}
