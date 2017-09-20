#ifndef SHADER_H
#define SHADER_H

#include <glad/glad.h>

#include <string>
#include <string.h>
#include <fstream>
#include <sstream>
#include <iostream>

// boolean constants
const bool TYPE_VERTEX = true;
const bool TYPE_FRAGMENT = false;

class Shader {

protected:
	std::string m_code;
	unsigned int m_ID;

	void checkCompileErrors() {

		int success;
		char infoLog[1024];

		glGetShaderiv(m_ID, GL_COMPILE_STATUS, &success);
		if (!success) {
			glGetShaderInfoLog(m_ID, 1024, nullptr, infoLog);
			std::cout << "Error compiling shader.\n";
			std::cout << infoLog << '\n';
		}
	}

private:

	void getSource(const char* path) {
		std::ifstream shaderFile;
		// make sure ifstream objects can throw exceptions
		shaderFile.exceptions(std::ifstream::failbit | std::ifstream::badbit);
		try {
			// open file
			shaderFile.open(path);
			std::stringstream shaderStream;
			// read file's buffer contents into stream
			shaderStream << shaderFile.rdbuf();
			// close file
			shaderFile.close();
			// convert stream into string
			m_code = shaderStream.str();
		}
		catch(std::ifstream::failure e) {
			std::cout << "Error reading shader\n";
			std::cout << "File could not be read: " << path << '\n';
		}
	}

	virtual void compileShader() = 0; // the VertexShader and FragmentShader classes should override this function themselves

public:
	// default constructor
	Shader() = delete; // we really don't want someone initializing this with no parameters

	// constructor taking a string
	Shader(const char* path) {
		getSource(path);
	}

	// copy constructor
	Shader(const Shader& source) {
		m_code = source.m_code;
		m_ID = source.m_ID;
	}

	const std::string getCode() const { return m_code; }
	unsigned int getID() const { return m_ID; }

};

class VertexShader : public Shader {
private:
	virtual void compileShader() {
		m_ID = glCreateShader(GL_VERTEX_SHADER);
		const char* code = m_code.c_str();
		glShaderSource(m_ID, 1, &code, nullptr);
		glCompileShader(m_ID);
		checkCompileErrors();
	}

public:
	// default constructor
	VertexShader() = delete; // we don't want one to be initialized with no parameters

	// constructor taking a string
	VertexShader(const char* path)
		: Shader(path)
	{
		compileShader();
	}

	// copy constructor
	VertexShader(const VertexShader& vs)
		: Shader(vs)
	{
	}
};

class FragmentShader : public Shader {
private:
	virtual void compileShader() {
		m_ID = glCreateShader(GL_FRAGMENT_SHADER);
		const char* code = m_code.c_str();
		glShaderSource(m_ID, 1, &code, nullptr);
		glCompileShader(m_ID);
		checkCompileErrors();
	}

public:
	// default constructor
	FragmentShader() = delete; // we don't want one to be initialized with no parameters

	// constructor taking a string
	FragmentShader(const char* path)
		: Shader(path)
	{
		compileShader();
	}

	// copy constructor
	FragmentShader(const VertexShader& vs)
		: Shader(vs)
	{
	}
};

#endif