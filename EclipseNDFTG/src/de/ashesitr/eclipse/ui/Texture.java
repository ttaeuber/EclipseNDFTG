package de.ashesitr.eclipse.ui;

import java.nio.ByteBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;
import static org.lwjgl.opengl.GL30.*;

public class Texture {
	private final int textureID, textureUnit;
	
	public Texture(int width, int height, ByteBuffer pixelData, int textureUnit) {
		this.textureUnit = textureUnit;
		this.textureID = glGenTextures();
		glActiveTexture(textureUnit);
		glBindTexture(GL_TEXTURE_2D, textureID);
		glPixelStorei(GL_UNPACK_ALIGNMENT, 1);
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, pixelData);
		glGenerateMipmap(GL_TEXTURE_2D);
	}
	
	public void bind() {
		glActiveTexture(textureUnit);
		glBindTexture(GL_TEXTURE_2D, textureID);
	}
	
	public void unbind() {
		glBindTexture(GL_TEXTURE_2D, 0);
	}
	
	public void destroy() {
		glDeleteTextures(textureID);
	}
}
