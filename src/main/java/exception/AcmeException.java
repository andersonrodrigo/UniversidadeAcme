package exception;

public class AcmeException extends Exception{


	private static final long serialVersionUID = -2668108308346232800L;
	
	public AcmeException(String message) {
		super(message);
	}
	
	public AcmeException(Throwable t) {
		super(t);
	}
	
	public AcmeException(String message, Throwable t) {
		super(message, t);
	}

}
