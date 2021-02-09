package persistance.builders;

import java.util.List;

import exceptions.MyException;

public interface ObjectBuilder <T> {
	public abstract List<T> getObjects() throws MyException;
}
