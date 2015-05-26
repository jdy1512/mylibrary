package member.exception;

public class DuplicateIdException extends Exception {
	private String errorMessage;

	public DuplicateIdException(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	@Override
	public String getMessage() {
		return errorMessage;
	}
}
