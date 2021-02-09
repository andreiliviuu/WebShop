package persistance.builders.concretebuilders;

import java.util.ArrayList;
import java.util.List;

import exceptions.MyException;
import objects.Product;
import persistance.builders.ObjectBuilder;
import utils.CSVParser;

public class ProductBuilder implements ObjectBuilder<Product> {
	private CSVParser parser;
	
	public ProductBuilder(String resource) {
		this.parser = new CSVParser(resource);
	}

	@Override
	public List<Product> getObjects() throws MyException {
		List<Product> productsList = new ArrayList<>();
		try {
			List<String[]> tokenArraysList = parser.getTokens();
			for(String[] array : tokenArraysList) {
				String idString = array[0];
				long id = Long.parseLong(idString);
				String categoryIdString = array[3];
				long categoryId = Long.parseLong(categoryIdString);
				
				Product product = new Product();
				product.setId(id);
				product.setCategoryId(categoryId);
				product.setName(array[1]);
				product.setDescription(array[2]);
				productsList.add(product);
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
			MyException exception = new MyException(e.getMessage());
			throw exception;
		}
		return productsList;
	}

}
