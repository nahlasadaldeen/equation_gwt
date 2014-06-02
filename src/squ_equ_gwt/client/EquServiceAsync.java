package squ_equ_gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface EquServiceAsync {

	
	void equ(Integer a, Integer b, Integer c,
			AsyncCallback<String> asyncCallback);

}
