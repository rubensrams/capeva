package mx.com.sistema.cap.exception;

public class AuthenticacionException extends Exception {

	private static final long serialVersionUID = -7832740703986319819L;
	
	public AuthenticacionException() {
		super();
	}
	public AuthenticacionException(String idException) {
		super(idException);
	}
	

}
