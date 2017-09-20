#define STB_IMAGE_IMPLEMENTATION
#include <stb_image.h>
#include <glad/glad.h>
#include <GLFW/glfw3.h>

#include <typeinfo>
#include <iostream>

class Texture {
private:
	unsigned int m_ID;
	const char* m_path;
	unsigned char* m_data;

	int m_height;
	int m_width;
	int m_nrChannels;
	GLenum m_format;

public:
	Texture(const char* path)
		: m_path(path)
	{
		// let's set some default options
		setOption(GL_TEXTURE_WRAP_S, GL_REPEAT);
		setOption(GL_TEXTURE_WRAP_T, GL_REPEAT);
		setOption(GL_TEXTURE_MIN_FILTER, GL_LINEAR);
		setOption(GL_TEXTURE_MAG_FILTER, GL_LINEAR);

		// let's load a texture just for testing
		loadTexture();
	}

	void setOption(int option, int choice) {
		glTexParameteri(GL_TEXTURE_2D, option, choice);
	}

	void setFlipVertically(bool isFlipped) {
		stbi_set_flip_vertically_on_load(isFlipped);
	}
	
	void loadTexture() {
		glGenTextures(1, &m_ID);
		glBindTexture(GL_TEXTURE_2D, m_ID);
		m_data = stbi_load(m_path, &m_width, &m_height, &m_nrChannels, 0);
		if (m_data) {
			// let's determine the format
			if (m_nrChannels == 3)
				m_format = GL_RGB;
			else if (m_nrChannels == 4)
				m_format = GL_RGBA;

			glTexImage2D(GL_TEXTURE_2D, 0, m_format, m_width, m_height, 0, m_format, GL_UNSIGNED_BYTE, m_data);
			glGenerateMipmap(GL_TEXTURE_2D);
			stbi_image_free(m_data);
		}
	}

};