package services;

import java.util.ArrayList;
import java.util.List;
import exceptions.MyException;
import objects.Category;
import persistance.builders.concretebuilders.CategoryBuilder;
import utils.DataLoader;

public class CategoryService {
	
	public List<Category> getCategories(String resourcePath){ 
		CategoryBuilder categoryBuilder = new CategoryBuilder(resourcePath);
		DataLoader<Category> dataLoader = new DataLoader<>(categoryBuilder);
		List<Category> result;
		try {
			result = dataLoader.getData(); 
		} catch (MyException e) {
			e.printStackTrace();
			result = new ArrayList<>();
		}
		return result;
	}
}
