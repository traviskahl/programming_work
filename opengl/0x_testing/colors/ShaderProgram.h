#ifndef SHADER_PROGRAM_H
#define SHADER_PROGRAM_H

#include "Shader.h"

class ShaderProgram {

private:
	int m_ID;
	VertexShader m_vertexShader;
	FragmentShader m_fragmentShader;

	void linkProgram() {
		m_ID = glCreateProgram();
		glAttachShader(m_ID, m_vertexShader.getID()); // attach vertex shader
		glAttachShader(m_ID, m_fragmentShader.getID()); // attach fragment shader
		glLinkProgram(m_ID);
	}

public:
	ShaderProgram(const VertexShader& vShader, const FragmentShader& fShader)
		: m_vertexShader(vShader), m_fragmentShader(fShader)
	{
		linkProgram();
	}

	// these functions are for setting uniforms
	void setBool(const std::string& name, bool value) const {
		glUniform1i(glGetUniformLocation(m_ID, name.c_str()), (int)value);
	}
	void setInt(const std::string& name, int value) const {
		glUniform1i(glGetUniformLocation(m_ID, name.c_str()), value);
	}
	void setFloat(const std::string& name, float value) const {
		glUniform1f(glGetUniformLocation(m_ID, name.c_str()), value);
	}

	// this function is used to activate the program
	void use() const {
		glUseProgram(m_ID);
	}
};

#endif