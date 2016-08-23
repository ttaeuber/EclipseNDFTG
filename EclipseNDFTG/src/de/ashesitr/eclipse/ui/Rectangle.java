package de.ashesitr.eclipse.ui;

import static org.lwjgl.opengl.GL11.*;

public class Rectangle {
	double x, y, width, height;
	Texture texture;
	double s0, t0, s1, t1;
	
	public Rectangle(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.texture = null;
		this.s0 = 0;
		this.t0 = 0;
		this.s1 = 1;
		this.t1 = 1;
	}
	
	public Rectangle(double x, double y, double width, double height, Texture texture, double s0, double t0, double s1, double t1) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.texture = texture;
		this.s0 = s0;
		this.t0 = t0;
		this.s1 = s1;
		this.t1 = t1;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void render() {
		if (texture != null) {
			texture.bind();
			glBegin(GL_QUADS);
			glTexCoord2d(s0, t0);
			glVertex2d(x, y);
			glTexCoord2d(s0, t1);
			glVertex2d(x, y + height);
			glTexCoord2d(s1, t1);
			glVertex2d(x + width, y + height);
			glTexCoord2d(s1, t0);
			glVertex2d(x + width, y);
			glEnd();
			texture.unbind();
		} else {
			glBegin(GL_QUADS);
			glVertex2d(x, y);
			glVertex2d(x, y + height);
			glVertex2d(x + width, y + height);
			glVertex2d(x + width, y);
			glEnd();
		}
	}
}
