package pl.madejski;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.madejski.dao.OrderDao;
import pl.madejski.model.Order;

@WebServlet("/products/add")
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/addorder.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String productName = request.getParameter("productName");
			if(productName == null || productName.length() == 0) throw new NullPointerException("Pole \"Nazwa produktu\" jest puste!");
			Order newProduct = new OrderDao(null, productName);
			OrderDao orderDao = new OrderDao();
			
			orderDao.save(newOrder);
			
			response.sendRedirect("/IDDBlab2/orders");
		} catch (Exception e) {
			request.setAttribute("error", true);
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("/addorder.jsp").forward(request, response);
		}
	}

}
