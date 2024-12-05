package mx.com.sistema.cap.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = -7832740703986319819L;
	
	public ServiceException() {
		super();
	}
	public ServiceException(String idException) {
		super(idException);
	}
	

}
