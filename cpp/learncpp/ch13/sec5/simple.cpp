#include <iostream>

template <class T>
class Storage {
private:
	T m_value;

public:
	Storage(T value) {
		m_value = value;
	}

	~Storage() {}

	void print() { std::cout << m_value << '\n'; }
};

template <>
void Storage<double>::print() {
	std::cout << std::scientific << m_value << '\n';
}

template<>
Storage<char*>::Storage(char* value) {
	// figure out how long the string in value is
	int length = 0;
	while (value[length] != 0)
		++length;

	++length; // +1 to account for null terminator

	// Allocate memory to hold the value string
	m_value = new char[length];

	// Copy the actual value string into the m_value memory we just allocated
	for (int count = 0; count < length; ++count)
		m_value[count] = value[count];
}

template <>
Storage<char*>::~Storage() {
	delete[] m_value;
}

int main() {
	/**
	// define some storage units
	Storage<int> nValue(5);
	Storage<double> dValue(6.7);

	// print some values
	nValue.print();
	dValue.print();
	**/

	// dynamically allocate a temporary string
	char* string = new char[40];

	// ask user for their name
	std::cout << "Enter your name: ";
	std::cin >> string;

	// store the name
	Storage<char*> value(string);

	// delete the temporary string
	delete[] string;

	// print out our value
	value.print(); // without specialization this prints garbage

	return 0;
}