#include <iostream>
#include <cassert>
#include <cstring>

class MyString {
private:
	char* m_data;
	int m_length;

public:
	MyString(const char* source="") {
		assert(source); // make sure source isn't a null string

		// find the length of the string
		// plus one character for a terminator
		m_length = strlen(source) + 1;

		// allocate a buffer equal to this length
		m_data = new char[m_length];

		// copy the parameter string into our internal buffer
		for (int i = 0; i < m_length; ++i)
			m_data[i] = source[i];

		// make sure the string is terminated
		m_data[m_length-1] = '\0';
	}

	~MyString() { // destructor
		// we need to deallocate our string
		delete[] m_data;
	}

	char* getString() { return m_data; }
	int getLength() { return m_length; }
};

int main(int argc, char const *argv[])
{
	MyString hello("Hello, world!");
	{
		MyString copy = hello; // use default copy constructor
	} // copy is a local variable, so it gets destroyed here. the destructor deletes copy's string, which leaves hello with a dangling pointer

	std::cout << hello.getString() << '\n'; // this has undefined behavior

	return 0;
}