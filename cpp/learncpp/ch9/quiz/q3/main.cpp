#include <iostream>
#include <cassert>

class IntArray {
private:
	int* m_data;
	int m_length;

public:
	// default constructor
	IntArray(int length) {
		assert(length > 0);
		m_length = length;
		m_data = new int[m_length];
	}

	// copy constructor
	IntArray(const IntArray& source) {
		// we need to do a deep copy
		m_length = source.m_length;

		m_data = new int[m_length];

		for (int i = 0; i < m_length; ++i)
			m_data[i] = source.m_data[i];
	}

	// copy assignment
	IntArray operator=(const IntArray& source) {
		// self assignment check
		if (this == &source)
			return *this;

		// delete anything that might exist already
		delete[] m_data;

		// now copy data over
		m_length = source.m_length;

		for (int i = 0; i < m_length; ++i)
			m_data[i] = source.m_data[i];

		return *this; // for chaining, if we want
	}

	int& operator[](int index) {
		assert(index >= 0 && index < m_length);
		return m_data[index];
	}

	friend std::ostream& operator<<(std::ostream& out, IntArray& ia) {
		for (int i = 0; i < ia.m_length; ++i)
			out << ia[i] << ' ';

		return out;
	}
};

IntArray fillArray()
{
	IntArray a(5);
	a[0] = 5;
	a[1] = 8;
	a[2] = 2;
	a[3] = 3;
	a[4] = 6;
 
	return a;
}
 
int main()
{
	IntArray a = fillArray();
	std::cout << a << '\n';
 
	IntArray b(1);
	a = a;
	b = a;
 
	std::cout << b << '\n';
 
	return 0;
}