package org.heavywater.ex;

public class HWException extends RuntimeException{	
	private static final long serialVersionUID = 7031093269429385881L;
	
	public HWException(){
		super();
	}
	public HWException(String msg){
		super(msg);
	}
	public HWException(Exception ex){
		super(ex);
	}
}

