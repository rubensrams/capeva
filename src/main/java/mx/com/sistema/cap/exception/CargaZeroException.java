package mx.com.sistema.cap.exception;

public class CargaZeroException extends Exception {

	private static final long serialVersionUID = -7832740703986319819L;
	
	public CargaZeroException() {
		super();
	}
	public CargaZeroException(String idException) {
		super(idException);
	}
	

}
