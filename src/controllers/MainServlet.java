package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import objects.Category;
import objects.Product;
import services.CategoryService;
import services.ProductService;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/pages/index.jsp")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryService categoryService;
	private ProductService productService;

	@Override
	public void init(ServletConfig config) {
		categoryService = new CategoryService();
		productService = new ProductService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productsResourcePath = request.getSession().getServletContext()
				.getRealPath("/resources/csv/products.csv");
		String categoriesResourcePath = request.getSession().getServletContext()
				.getRealPath("/resources/csv/categories.csv");

		List<Product> products = productService.getProducts(productsResourcePath);
		List<Category> categories = categoryService.getCategories(categoriesResourcePath);

		request.getSession().setAttribute("products", products);
		request.getSession().setAttribute("categories", categories);

		request.getRequestDispatcher("/pages/verySimpleWebShop.jsp").forward(request, response);
	}

}
