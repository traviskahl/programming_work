#ifndef SHADER_PROGRAM_HPP
#define SHADER_PROGRAM_HPP

#include "Shader.hpp"
#include <glm/glm.hpp>

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
	// not gonna lie, these were all taken from the tutorial
	// but honestly, how many ways are there to do this?

	// first are for primitives
	void setBool(const std::string& name, bool value) const {
		glUniform1i(glGetUniformLocation(m_ID, name.c_str()), (int)value);
	}
	void setInt(const std::string& name, int value) const {
		glUniform1i(glGetUniformLocation(m_ID, name.c_str()), value);
	}
	void setFloat(const std::string& name, float value) const {
		glUniform1f(glGetUniformLocation(m_ID, name.c_str()), value);
	}

	// next for setting vectors
	void setVec2(const std::string& name, const glm::vec2& vec) const {
		glUniform2fv(glGetUniformLocation(m_ID, name.c_str()), 1, &vec[0]);
	}
	void setVec2(const std::string& name, float x, float y) const {
		glUniform2f(glGetUniformLocation(m_ID, name.c_str()), x, y);
	}
	void setVec3(const std::string& name, const glm::vec3& vec) const {
		glUniform3fv(glGetUniformLocation(m_ID, name.c_str()), 1, &vec[0]);
	}
	void setVec3(const std::string& name, float x, float y, float z) const {
		glUniform3f(glGetUniformLocation(m_ID, name.c_str()), x, y, z);
	}
	void setVec4(const std::string& name, const glm::vec4& vec) const {
		glUniform4fv(glGetUniformLocation(m_ID, name.c_str()), 1, &vec[0]);
	}
	void setVec4(const std::string& name, float x, float y, float z, float w) const {
		glUniform4f(glGetUniformLocation(m_ID, name.c_str()), x, y, z, w);
	}

	// finally for setting matrices
	void setMat2(const std::string& name, const glm::mat2& mat) const {
		glUniformMatrix2fv(glGetUniformLocation(m_ID, name.c_str()), 1, GL_FALSE, &mat[0][0]);
	}
	void setMat3(const std::string& name, const glm::mat3& mat) const {
		glUniformMatrix3fv(glGetUniformLocation(m_ID, name.c_str()), 1, GL_FALSE, &mat[0][0]);
	}
	void setMat4(const std::string& name, const glm::mat4& mat) const {
		glUniformMatrix4fv(glGetUniformLocation(m_ID, name.c_str()), 1, GL_FALSE, &mat[0][0]);
	}

	// this function is used to activate the program
	void use() const {
		glUseProgram(m_ID);
	}
};

#endif