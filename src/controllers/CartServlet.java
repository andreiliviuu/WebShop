package controllers;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.CartService;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 3646861990478497712L;
	private CartService cartService;

	@Override
	public void init(ServletConfig config) {
		cartService = new CartService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productIdParam = request.getParameter("productId");
		if (productIdParam != null) {
			String cartsResourcePath = request.getSession().getServletContext()
					.getRealPath("/resources/output/output.txt");
			cartService.addProductToCart(cartsResourcePath, productIdParam);
			response.getWriter().println("Product with id " + productIdParam + " was added to cart...");
		}
	}
}
