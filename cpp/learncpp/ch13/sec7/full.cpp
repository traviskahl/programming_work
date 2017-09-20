#include <iostream>
#include <cstring>

template <class T, int size> // size is the expression parameter
class StaticArray {
private:
	// The expression parameter controls the size of the array
	T m_array[size];

public:
	T* getArray() { return m_array; }

	T& operator[](int index) {
		return m_array[index];
	}
};

template <typename T, int size>
void print(StaticArray<T, size>& array) {
	for (int count = 0; count < size; ++count)
		std::cout << array[count] << ' ';
}

// overload of print() function for partially specialized StaticArray<char, size>
template <int size>
void print(StaticArray<char, size>& array) {
	for (int count = 0; count < size; ++count)
		std::cout << array[count];
}

int main() {
	// Declare a char array of size 14
	StaticArray<char, 14> char14;

	strcpy(char14.getArray(), "Hello, world!");

	// print the array
	print(char14);
	std::cout << '\n';

	// now declare an array of size 12
	StaticArray<char, 12> char12;

	strcpy(char12.getArray(), "Hello, mom!");

	// print the array
	print(char12);
	std::cout << '\n';

	return 0;
}