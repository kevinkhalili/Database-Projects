package projects.exception;

@SuppressWarnings("serial") //to get rid of wornings
public class DbException extends RuntimeException {
	
	//default constructor

	public DbException() {

	}
	
	//user defined constructors

	public DbException(String message) {
		super(message);
		
	}

	public DbException(Throwable cause) {
		super(cause);
		
	}

	public DbException(String message, Throwable cause) {
		super(message, cause);
		
	}

}
