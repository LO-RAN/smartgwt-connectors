package org.loran.smartgwt.connectors.client;

import org.vaadin.gwtgraphics.client.Line;
import org.vaadin.gwtgraphics.client.animation.Animate;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.DragRepositionMoveEvent;
import com.smartgwt.client.widgets.events.DragRepositionMoveHandler;
import com.smartgwt.client.widgets.events.DragRepositionStartEvent;
import com.smartgwt.client.widgets.events.DragRepositionStartHandler;
import com.smartgwt.client.widgets.events.DragRepositionStopEvent;
import com.smartgwt.client.widgets.events.DragRepositionStopHandler;
import com.smartgwt.client.widgets.events.DragResizeMoveEvent;
import com.smartgwt.client.widgets.events.DragResizeMoveHandler;

public class Connector {
	// DrawingArea drawingArea;
	Line line;
	int lineWidth = 3;
	Canvas c1, c2;
	DrawingCanvas dc;
	String strokeColor;

	public Connector(Canvas c1, Canvas c2, final DrawingCanvas dc) {
		this.c1 = c1;
		this.c2 = c2;
		this.dc = dc;

		line = new Line(0, 0, 1, 1);
		line.setStrokeColor("green");
		line.setStrokeWidth(lineWidth);

		line.addMouseOverHandler(new MouseOverHandler() {

			@Override
			public void onMouseOver(MouseOverEvent event) {
				strokeColor = line.getStrokeColor();
				line.setStrokeColor("red");
			}
		});

		line.addMouseOutHandler(new MouseOutHandler() {

			@Override
			public void onMouseOut(MouseOutEvent event) {
				line.setStrokeColor(strokeColor);
			}
		});

		line.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				new Animate(line, "strokeopacity", 1, 0, 1000).start();
				new Animate(line, "strokeopacity", 0, 1, 1000).start();
			}
		});

		dc.add(line);

		refresh(true);

		addHandlers(c1);
		addHandlers(c2);

		c1.bringToFront();
		c2.bringToFront();
	}

	private void addHandlers(Canvas c) {
		c.addDragRepositionMoveHandler(new DragRepositionMoveHandler() {

			public void onDragRepositionMove(DragRepositionMoveEvent event) {
				refresh(false);
			}
		});

		c.addDragResizeMoveHandler(new DragResizeMoveHandler() {

			@Override
			public void onDragResizeMove(DragResizeMoveEvent event) {
				refresh(false);
			}
		});

		c.addDragRepositionStartHandler(new DragRepositionStartHandler() {

			@Override
			public void onDragRepositionStart(DragRepositionStartEvent event) {
				strokeColor = line.getStrokeColor();
				line.setStrokeColor("yellow");
			}
		});

		c.addDragRepositionStopHandler(new DragRepositionStopHandler() {

			@Override
			public void onDragRepositionStop(DragRepositionStopEvent event) {
				line.setStrokeColor(strokeColor);
			}
		});
	}

	private void refresh(Boolean animate) {
		int c1x, c1y, c2x, c2y;

		c1x = c1.getLeft() + (c1.getWidth() / 2);
		c2x = c2.getLeft() + (c2.getWidth() / 2);
		c1y = c1.getTop() + (c1.getHeight() / 2);
		c2y = c2.getTop() + (c2.getHeight() / 2);

		line.setX1(c1x);
		line.setY1(c1y);
		line.setX2(c2x);
		line.setY2(c2y);
		if (animate) {
			new Animate(line, "strokeopacity", 0, 1, 3000).start();
		}

	}

}
