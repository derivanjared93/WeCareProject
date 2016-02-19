package com.project.exception;

public enum StatusCode 
{
	DB_ERROR("Error accessing database. Please try again later."), SUCCESS("Success."), NEW("Riddly Diddly Derp");
	
	private String msg;
	
	StatusCode(String msg)
	{
		this.setMsg(msg);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
