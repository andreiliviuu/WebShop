package exceptions;

public class MyException extends Exception {

	private static final long serialVersionUID = 620676343787817836L;

	private String message;

	public MyException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
