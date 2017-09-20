#include <iostream>
#include <string>
#include <exception> // for std::exception

class ArrayException : public std::exception {
private:
	std::string m_error;

public:
	ArrayException(std::string error)
		: m_error(error)
	{
	}

	const char* what() { return m_error.c_str(); } // return the std::string as a const c-style string
};

class IntArray {
private:
	int m_data[3]; // assume array is length 3 for simplicity

public:
	IntArray() {}

	int getLength() { return 3; }

	int& operator[](const int index) {
		if (index < 0 || index >= getLength())
			throw ArrayException("Invalid Index");

		return m_data[index];
	}
};

int main() {
	IntArray array;

	try {
		int value = array[5];
	}
	catch (ArrayException &exception) { // derived catch blocks go first
		std::cerr << "An array exception occurred (" << exception.what() << ")\n";
	}
	catch (std::exception &exception) {
		std::cerr << "Some other std::exception occurred (" << exception.what() << "(\n";
	}

	return 0;
}