package org.loran.smartgwt.connectors.client;

import com.smartgwt.client.widgets.Window;

public class MyDialog extends Window {

	private DrawingCanvas canvas;
	private DragLabel dragLabel1;
	private DragLabel dragLabel2;
	private DragLabel dragLabel3;

	public MyDialog() {
		setShowHeaderIcon(true);
		setShowFooter(true);
		setShowTitle(true);
		setShowStatusBar(true);
		setShowResizer(true);
		setShowModalMask(true);
		setTitle("New dialog");
		setIsModal(true);
		setModalMaskOpacity(30);
		setRedrawOnResize(true);
		setCanDragResize(true);
		setCanDragReposition(true);

		resizeTo(640, 480);

		addItem(getCanvas());
	}

	private DrawingCanvas getCanvas() {

		if (canvas == null) {
			canvas = new DrawingCanvas();
			canvas.setWidth(getInnerWidth());
			canvas.setHeight(getInnerHeight());

			canvas.addChild(getDragLabel1());
			canvas.addChild(getDragLabel2());
			canvas.addChild(getDragLabel3());
			
			new Connector(dragLabel1, dragLabel2, canvas);
			new Connector(dragLabel1, dragLabel3, canvas);
		}

		return canvas;
	}

	private DragLabel getDragLabel1() {
		if (dragLabel1 == null) {
			dragLabel1 = new DragLabel("Shadow 1", 100,40);
			dragLabel1.setSize("100px", "40px");
		}
		return dragLabel1;
	}
	
	private DragLabel getDragLabel2() {
		if (dragLabel2 == null) {
			dragLabel2 = new DragLabel("Shadow 2", 300, 60);
			dragLabel2.setSize("100px", "40px");
		}
		return dragLabel2;
	}
	private DragLabel getDragLabel3() {
		if (dragLabel3 == null) {
			dragLabel3 = new DragLabel("Shadow 3", 200, 120);
			dragLabel3.setSize("100px", "40px");
		}
		return dragLabel3;
	}
}
