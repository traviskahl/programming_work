#ifndef BUFFER_STATE_H
#define BUFFER_STATE_H

#include <glad/glad.h>
#include <cassert>

class BufferState {
private:
	// the IDs for the objects
	unsigned int m_VAO;
	unsigned int m_VBO;
	unsigned int m_EBO;

	// the data for the buffers
	float* m_vertices;
	unsigned int* m_indices;
	unsigned int m_vLength;
	unsigned int m_iLength;

	// place stuff here, functions maybe?

public:
	BufferState(float* vertices, unsigned int vLength, unsigned int* indices, unsigned int iLength)
		: m_vLength(vLength), m_iLength(iLength)
	{
		// first we should deep copy our arrays
		m_vertices = new float[vLength];
		m_indices = new unsigned int[iLength];

		for (unsigned int index = 0; index < m_vLength; ++index)
			m_vertices[index] = vertices[index];

		for (unsigned int index = 0; index < m_iLength; ++index)
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

		glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 3 * sizeof(float), (void*)0);
		glEnableVertexAttribArray(0);
	}
};

#endif