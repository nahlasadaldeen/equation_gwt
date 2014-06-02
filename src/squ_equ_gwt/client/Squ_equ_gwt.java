package squ_equ_gwt.client;

import squ_equ_gwt.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Squ_equ_gwt implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
	final EquServiceAsync addservice = GWT.create(EquService.class);
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		VerticalPanel verticalPanel = new VerticalPanel();
		RootPanel.get().add(verticalPanel, 579, 150);
		verticalPanel.setSize("158px", "240px");
		
		 final IntegerBox intbox1 = new IntegerBox();
		verticalPanel.add(intbox1);
		
		final IntegerBox intbox2 = new IntegerBox();
		verticalPanel.add(intbox2);
		
		final IntegerBox intbox3 = new IntegerBox();
		verticalPanel.add(intbox3);
		
		Button btnAdd = new Button("Solve");
		verticalPanel.add(btnAdd);
		btnAdd.setWidth("151px");
		
		
		
		final Label lblResult = new Label("New label");
		verticalPanel.add(lblResult);


		btnAdd.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				addservice.equ(intbox1.getValue(), intbox2.getValue(),intbox3.getValue(),
						new AsyncCallback<String>() {
							
							@Override
							public void onSuccess(String result) {
								
								lblResult.setText(result);
							}
							
							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								lblResult.setText(caught.getMessage());
								
								
							}
						});
			}
		});
	}
}