package org.heavywater.core;

public class HException extends RuntimeException{	
	private static final long serialVersionUID = 7031093269429385881L;
	
	private String msg 		= null;
	private Throwable cause = null;
		
	public HException(){
		super();
	}
	public HException(String msg){
		super(msg);
		this.msg=msg;
	}
	public HException(Exception ex){
		super(ex);
		this.cause = ex;
	}
	public HException(String msg, Throwable cause){
		this.msg = msg;
		this.cause = cause;
	}
	public String getMessage(){
		return msg;
	}
	public Throwable getCause(){
		return cause;
	}
	public void printStackTrace(){
		super.printStackTrace();
		Throwable next=cause;
		while(next!=null){
			System.out.println("( caused by )");
			next.printStackTrace();
			next = next.getCause();
		}
	}
	 
}

