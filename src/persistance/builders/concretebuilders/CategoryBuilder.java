package persistance.builders.concretebuilders;

import java.util.ArrayList;
import java.util.List;
import exceptions.MyException;
import objects.Category;
import persistance.builders.ObjectBuilder;
import utils.CSVParser;

public class CategoryBuilder implements ObjectBuilder<Category> {
	private CSVParser parser;
	
	public CategoryBuilder(String resource) {
		this.parser = new CSVParser(resource);
	}

	@Override
	public List<Category> getObjects() throws MyException {
		List<Category> categoryList = new ArrayList<>();
		try {
			List<String[]> tokensArray = parser.getTokens();
			for(String[] array : tokensArray) {
				String idString = array[0];
				long id = Long.parseLong(idString);
				
				Category category = new Category();
				category.setId(id);
				category.setName(array[1]);
				category.setDescription(array[2]);
				categoryList.add(category);
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
			MyException exception = new MyException(e.getMessage());
			throw exception;
		}
		return categoryList;
	}

}
