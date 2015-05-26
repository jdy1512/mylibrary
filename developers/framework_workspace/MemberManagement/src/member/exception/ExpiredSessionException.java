package member.exception;

public class ExpiredSessionException extends Exception {
	private String errorMessage;

	public ExpiredSessionException(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	@Override
	public String getMessage() {
		return errorMessage;
	}
}
