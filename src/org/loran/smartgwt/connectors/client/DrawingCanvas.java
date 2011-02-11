/**
 * 
 */
package org.loran.smartgwt.connectors.client;

import org.vaadin.gwtgraphics.client.DrawingArea;
import org.vaadin.gwtgraphics.client.Line;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.DragResizeMoveEvent;
import com.smartgwt.client.widgets.events.DragResizeMoveHandler;
import com.smartgwt.client.widgets.events.ResizedEvent;
import com.smartgwt.client.widgets.events.ResizedHandler;

/**
 * @author cwfr-lizac
 * 
 */
public class DrawingCanvas extends Canvas {
	DrawingArea drawingArea;
	Canvas canvas;

	/**
	 * 
	 */
	public DrawingCanvas() {

		canvas=new Canvas();
		addChild(canvas);
		drawingArea = new DrawingArea(1, 1);
		canvas.setWidth("100%");
		canvas.setHeight("100%");
		canvas.addChild(drawingArea);

		addDragResizeMoveHandler(new DragResizeMoveHandler() {

			@Override
			public void onDragResizeMove(DragResizeMoveEvent event) {
				resize();
			}
		});
		
		addResizedHandler(new ResizedHandler() {
			
			@Override
			public void onResized(ResizedEvent event) {
				resize();
			}
		});
	}
	
	public void add(Line line) {
		drawingArea.add(line);
	}

	private void resize(){
		drawingArea.setWidth(canvas.getInnerWidth());
		drawingArea.setHeight(canvas.getInnerHeight());	
	}
}
