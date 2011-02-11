package org.loran.smartgwt.connectors.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;
import com.smartgwt.client.widgets.toolbar.ToolStripSeparator;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Main implements EntryPoint {
	private static final AppConstants CONSTANTS = GWT.create(AppConstants.class);
	private ToolStrip toolStrip;
	private ToolStripSeparator toolStripSeparator;
	private ToolStripButton toolStripButton;
	private DrawingCanvas canvas;
	private DragLabel label1;
	private DragLabel label2;

	public void onModuleLoad() {
		RootPanel rootPanel = RootPanel.get();
		rootPanel.add(getToolStrip(), 10, 3);
		rootPanel.add(getCanvas(), 10, 35);
	}


	private ToolStrip getToolStrip() {
		if (toolStrip == null) {
			toolStrip = new ToolStrip();
			toolStrip.setSize("620px", "25px");
			toolStrip.addMember(getToolStripSeparator());
			toolStrip.addButton(getToolStripButton());
		}
		return toolStrip;
	}

	private ToolStripSeparator getToolStripSeparator() {
		if (toolStripSeparator == null) {
			toolStripSeparator = new ToolStripSeparator();
		}
		return toolStripSeparator;
	}

	private ToolStripButton getToolStripButton() {
		if (toolStripButton == null) {
			toolStripButton = new ToolStripButton(CONSTANTS.toolStripButton_title());
			toolStripButton.addClickHandler(new ToolStripButtonClickHandler());
		}
		return toolStripButton;
	}
	private class ToolStripButtonClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			MyDialog md=new MyDialog();
			md.show();
		}
	}
	private DrawingCanvas getCanvas() {
		if (canvas == null) {
			canvas = new DrawingCanvas();
			canvas.setSize("620px", "435px");

			canvas.addChild(getLabel1());
			canvas.addChild(getLabel2());
			new Connector(label1,label2, canvas);			
		}
		return canvas;
	}
	private Label getLabel1() {
		if (label1 == null) {
			label1 = new DragLabel(CONSTANTS.lblNewLabel_contents(), 20,21);
			label1.setSize("100px", "40px");
		}
		return label1;
	}
	private Label getLabel2() {
		if (label2 == null) {
			label2 = new DragLabel(CONSTANTS.lblNewLabel_1_contents(), 279,90);
			label2.setSize("100px", "40px");
		}
		return label2;
	}
}
