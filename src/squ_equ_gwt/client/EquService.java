package squ_equ_gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("solve")
public interface EquService extends RemoteService{
	
	String equ(Integer a, Integer b, Integer c);

}
