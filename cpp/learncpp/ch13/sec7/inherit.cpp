#include <iostream>

template <class T, int size> // size is the expression parameter
class StaticArray_Base {
protected:
	// The expression parameter controls the size of the array
	T m_array[size];

public:
	T* getArray() { return m_array; }

	T& operator[](int index) {
		return m_array[index];
	}

	void printArray() {
		for (int i = 0; i < size; ++i)
			std::cout << m_array[i];

		std::cout << '\n';
	}
};

template <class T, int size> // size is the expression parameter
class StaticArray : public StaticArray_Base<T, size> {
public:
	StaticArray()
	{
	}
};

template <int size> // size is the expression parameter
class StaticArray<double, size> : public StaticArray_Base<double, size> {
public:
	void printArray() {
		for (int i = 0; i < size; ++i)
			std::cout << std::scientific << this->m_array[i] << " ";

		std::cout << '\n';
	}
};

int main() {
	// declare an integer array with room for 12 integers
	StaticArray<int, 6> intArray;

	// fill it up in order, then print it backwards
	for (int count = 0; count < 6; ++count)
		intArray[count] = count;

	intArray.printArray();

	// declare a double buffer with room for 4 doubles
	StaticArray<double, 4> doubleArray;

	for (int count = 0; count < 4; ++count)
		doubleArray[count] = (4 + 0.1*count);

	doubleArray.printArray();

	return 0;
}