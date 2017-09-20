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

// Override print() for fully specialized StaticArray<char, 14>
template <>
void print(StaticArray<char, 14>& array) {
	for (int count = 0; count < 14; ++count)
		std::cout << array[count];
}

int main() {
	// declare an int array
	StaticArray<int, 4> int4;
	int4[0] = 0;
	int4[1] = 1;
	int4[2] = 2;
	int4[3] = 3;

	// print the array
	print(int4);
	std::cout << '\n';

	// declare a char array
	StaticArray<char, 14> char14;

	strcpy(char14.getArray(), "Hello, world!");

	// print the array
	print(char14);
	std::cout << '\n';

	return 0;
}