package utils;

import java.util.List;

import exceptions.MyException;
import persistance.builders.ObjectBuilder;

public class DataLoader<T> {
	private ObjectBuilder<T> builder;
	
	public DataLoader(ObjectBuilder<T> builder) {
		this.builder = builder;
	}
	
	public List<T> getData() throws MyException{
		return builder.getObjects();
	}
}
