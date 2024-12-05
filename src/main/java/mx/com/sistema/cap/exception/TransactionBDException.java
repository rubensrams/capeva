package mx.com.sistema.cap.exception;

public class TransactionBDException extends Exception {

	private static final long serialVersionUID = -7832740703986319819L;
	
	public TransactionBDException() {
		super();
	}
	public TransactionBDException(String idException) {
		super(idException);
	}
	

}
