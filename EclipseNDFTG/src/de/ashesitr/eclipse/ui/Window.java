package de.ashesitr.eclipse.ui;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

public class Window {
	private long window;
	private int width, height;
	
	public Window(long window) {
		this.window = window;
	}
	
	public Window(String title, int width, int height, boolean resizable) {
		GLFWErrorCallback.createPrint(System.err).set();

		// Initialize GLFW. Most GLFW functions will not work before doing this.
		if ( !glfwInit() )
			throw new IllegalStateException("Unable to initialize GLFW");

		// Configure our window
		glfwDefaultWindowHints(); // optional, the current window hints are already the default
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
		glfwWindowHint(GLFW_RESIZABLE, resizable ? GLFW_TRUE : GLFW_FALSE); // the window will be resizable

		// Create the window
		window = glfwCreateWindow(width, height, title, NULL, NULL);
		if ( window == NULL )
			throw new RuntimeException("Failed to create the GLFW window");
		
		this.width = width;
		this.height = height;
	}
	
	public double getMouseX() {
		return getMouseCoords()[0];
	}
	
	public double getMouseY() {
		return getMouseCoords()[1];
	}
	
	public double[] getMouseCoords() {
		double[] pos = new double[2];
		double[] x = new double[1], y = new double[1];
		GLFW.glfwGetCursorPos(window, x, y);
		pos[0] = x[0];
		pos[1] = y[0];
		return pos;
	}
	
	public void show() {
		// Get the resolution of the primary monitor
		GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		// Center our window
		glfwSetWindowPos(
			window,
			(vidmode.width() - width) / 2,
			(vidmode.height() - height) / 2
		);

		// Make the OpenGL context current
		glfwMakeContextCurrent(window);
		// Enable v-sync
		glfwSwapInterval(1);

		// Make the window visible
		glfwShowWindow(window);
		
		// This line is critical for LWJGL's interoperation with GLFW's
		// OpenGL context, or any context that is managed externally.
		// LWJGL detects the context that is current in the current thread,
		// creates the GLCapabilities instance and makes the OpenGL
		// bindings available for use.
		GL.createCapabilities();

		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, width, height, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

		// Set the clear color
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
	}
	
	public void update() {
		glfwSwapBuffers(window);
		glfwPollEvents();
	}
	
	public boolean shouldClose() {
		return glfwWindowShouldClose(window);
	}
}
