package com.project.exception;

public class WrongEntryException extends Exception 
{

	private static final long serialVersionUID = -2034908642656726016L;
	private Throwable exception;
	private StatusCode status;
	
	public WrongEntryException()
	{
		
	}
	
	public WrongEntryException(Throwable exception, StatusCode status)
	{
		super();
		this.setException(exception);
		this.setStatus(status);
	}

	
	public Throwable getException() {
		return exception;
	}

	public void setException(Throwable exception) {
		this.exception = exception;
	}

	public StatusCode getStatus() {
		return status;
	}

	public void setStatus(StatusCode status) {
		this.status = status;
	}
	
	
}
