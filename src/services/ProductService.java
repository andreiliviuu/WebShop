package services;

import java.util.ArrayList;
import java.util.List;
import exceptions.MyException;
import objects.Product;
import persistance.builders.concretebuilders.ProductBuilder;
import utils.DataLoader;

public class ProductService {

	public List<Product> getProducts(String resourcePath) {
		ProductBuilder productBuilder = new ProductBuilder(resourcePath);
		DataLoader<Product> dataLoader = new DataLoader<>(productBuilder);
		List<Product> products;
		try {
			products = dataLoader.getData();
		} catch (MyException e) {
			e.printStackTrace();
			products = new ArrayList<>();
		}
		return products;
	}
}
