package de.ashesitr.eclipse;

import de.ashesitr.eclipse.ui.Rectangle;
import de.ashesitr.eclipse.ui.Texture;
import de.ashesitr.eclipse.ui.Window;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import org.newdawn.slick.opengl.PNGDecoder;

public class Main {
	private Window win;

	public static void main(String[] args) {
		new Main().run();
	}
	
	public void run() {
		win = new Window("Hello, World!", 600, 480, false);
		win.show();
		loop();
	}

	private void loop() {
		Texture texture = loadTexture("Test", GL_TEXTURE0);
		Rectangle rect = new Rectangle(0, 0, 10, 10, texture, 0, 0, 1, 1);
		Rectangle rect2 = new Rectangle(200, 100, 400, 400, texture, 0, 0, 1, 1);
		
		// Run the rendering loop until the user has attempted to close
		// the window or has pressed the ESCAPE key.
		while ( !win.shouldClose() ) {
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
			
			double[] cursor = win.getMouseCoords();
			glBegin(GL_LINES);
			glVertex2i(100, 100);
			glVertex2d(cursor[0], cursor[1]);
			glEnd();
			
			rect.setX(cursor[0] - 5);
			rect.setY(cursor[1] - 5);

			rect2.render();
			rect.render();
			
			win.update();
		}
		
		texture.destroy();
	}
	
	private Texture loadTexture(String name, int textureUnit) {
		try {
			FileInputStream fin = new FileInputStream("res/" + name + ".png");
			PNGDecoder decoder = new PNGDecoder(fin);
			ByteBuffer buf = ByteBuffer.allocateDirect(4 * decoder.getWidth() * decoder.getHeight());
			decoder.decode(buf, decoder.getWidth() * 4, PNGDecoder.RGBA);
			buf.flip();
			fin.close();
			return new Texture(decoder.getWidth(), decoder.getHeight(), buf, textureUnit);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
