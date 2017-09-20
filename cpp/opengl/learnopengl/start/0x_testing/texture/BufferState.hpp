#ifndef BUFFER_STATE_HPP
#define BUFFER_STATE_HPP

#include <glad/glad.h>
#include <cassert>

class BufferState {
private:
	// the IDs for the objects
	unsigned m_VAO;
	unsigned m_VBO;
	unsigned m_EBO;

	// the data for the buffers
	float* m_vertices;
	unsigned* m_indices;
	unsigned m_vLength;
	unsigned m_iLength;

public:

	// empty default constructor
	BufferState() {
		glGenVertexArrays(1, &m_VAO);
		glGenBuffers(1, &m_VBO);
		glGenBuffers(1, &m_EBO);

		m_vertices = nullptr;
		m_indices = nullptr;
	}

	BufferState(float* vertices, unsigned vLength, unsigned* indices, unsigned iLength)
		: m_vLength(vLength), m_iLength(iLength)
	{
		// first we should deep copy our arrays
		m_vertices = new float[vLength];
		m_indices = new unsigned[iLength];

		for (unsigned index = 0; index < m_vLength; ++index)
			m_vertices[index] = vertices[index];

		for (unsigned index = 0; index < m_iLength; ++index)
			m_indices[index] = indices[index];

		// after we have our data, we should initialize our buffers
		glGenVertexArrays(1, &m_VAO);
		glGenBuffers(1, &m_VBO);
		glGenBuffers(1, &m_EBO);

		glBindVertexArray(m_VAO);

		glBindBuffer(GL_ARRAY_BUFFER, m_VBO);
		glBufferData(GL_ARRAY_BUFFER, 4*m_vLength, m_vertices, GL_STATIC_DRAW);

		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, m_EBO);
		glBufferData(GL_ELEMENT_ARRAY_BUFFER, 4*m_iLength, m_indices, GL_STATIC_DRAW);

		//glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 3 * sizeof(float), (void*)0);
		//glEnableVertexAttribArray(0);
	}

	// we want to bind this object
	void bind() {
		// we want to make sure that ALL information is correct
		glBindVertexArray(m_VAO);
		glBindBuffer(GL_ARRAY_BUFFER, m_VBO);
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, m_EBO);
		glBufferData(GL_ARRAY_BUFFER, 4*m_vLength, m_vertices, GL_STATIC_DRAW);
		glBufferData(GL_ELEMENT_ARRAY_BUFFER, 4*m_iLength, m_indices, GL_STATIC_DRAW);
	}

	// we want to unbind this object
	// actually it unbinds every object
	// probably won't use this much
	void unbind() {
		glBindVertexArray(0);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
	}

	// we want to see if the current VAO is bound
	bool isBound() {
		int copy;
		glGetIntegerv(GL_VERTEX_ARRAY_BINDING, &copy);
		if (copy == m_VAO)
			return true;
		else
			return false;
	}

	// here we get the data members
	unsigned getVAO() const { return m_VAO; }
	unsigned getVBO() const { return m_VBO; }
	unsigned getEBO() const { return m_EBO; }

	float* getVertices() const { return m_vertices; }
	unsigned* getIndices() const { return m_indices; }
	unsigned getVLength() const { return m_vLength; }
	unsigned getILength() const { return m_iLength; }

	// now some functions to set them
	// these two are pretty similar to what copy assignment would look like
	void setVertices(float* vertices, unsigned length) {
		// self-assignment check
		if (vertices == m_vertices) {
			std::cout << "self assignment in setVertices\n";
			return;
		}
		
		if (m_vertices)
			delete[] m_vertices;
		m_vLength = length;
		m_vertices = new float[m_vLength];
		for (unsigned index = 0; index < m_vLength; ++index)
			m_vertices[index] = vertices[index];
	}

	void setIndices(unsigned* indices, unsigned length) {
		// self-assignment check
		if (indices == m_indices) {
			std::cout << "self assignment in setIndices\n";
			return;
		}

		if (m_indices)
			delete[] m_indices;
		m_iLength = length;
		m_indices = new unsigned[m_iLength];
		for (unsigned index = 0; index < m_iLength; ++index)
			m_indices[index] = indices[index];
	}

	// incomplete function, need some research
	void addAttribute(int num, int size, int datatype, bool isNormalized, int stride, int offset) {
		glVertexAttribPointer(num, size, datatype, isNormalized, stride, (void*)offset);
		glEnableVertexAttribArray(num);
	}
};

#endif