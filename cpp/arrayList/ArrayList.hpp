#ifndef ARRAYLIST_H
#define ARRAYLIST_H

#include <iostream>
#include <typeinfo> // for testing and debugging

#define ADDITIONAL_ELEMENTS 5 // the number of additional elements to add

template <class T>
class ArrayList {
private:
	T* m_data;
	unsigned m_length;
	unsigned m_seen;

	void resize() {
		// let's copy data into a temporary array
		T* temp = new T[m_length];
		for (unsigned index = 0; index < m_length; ++index)
			temp[index] = m_data[index];

		// update our information
		delete[] m_data;
		m_length += ADDITIONAL_ELEMENTS;
		m_data = new T[m_length];
		for (unsigned index = 0; index < m_seen; ++index)
			m_data[index] = temp[index];

		delete[] temp;
	}

public:
	ArrayList(const T* data, unsigned length) {
		m_length = length + ADDITIONAL_ELEMENTS;
		m_seen = length;
		m_data = new T[m_length];

		// we should deep copy
		for (unsigned index = 0; index < m_seen; ++index)
			m_data[index] = data[index];
	}

	~ArrayList() {
		delete[] m_data;
	}

	friend std::ostream& operator<<(std::ostream& out, const ArrayList& al) {
		for (unsigned index = 0; index < al.m_seen; ++index)
			out << al.m_data[index] << ' ';
		out << '\n';

		return out;
	}

	const T& operator[](int index) const { return m_data[index]; }
	T& operator[](int index) { return m_data[index]; }

	// to add another element to the end of the array list
	void push(T element) {
		// if the array is full
		// we should resize
		if (m_seen == m_length)
			resize();

		m_data[m_seen++] = element;
	}

	// just for testing
	unsigned getSeen() { return m_seen; }
	unsigned getLength() { return m_length; }
};

#endif