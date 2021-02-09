package services;

import utils.DataPrinter;

public class CartService {

	public void addProductToCart(String outputFilePath, String productIdParam) {
		Long productId = Long.parseLong(productIdParam);

		String output = "Product " + productId + " was added to cart...\n";
		DataPrinter dp = new DataPrinter();
		dp.addLineToFile(outputFilePath, output);

	}
}
