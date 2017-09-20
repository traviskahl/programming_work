#include <iostream>

class MyString {
private:
	char* m_data;
	int m_length;

public:
	MyString(const char* data="", int length=0)
		: m_length(length)
	{
		if (!length)
			m_data = nullptr;
		else
			m_data = new char[length];

		for (int i = 0; i < length; ++i)
			m_data[i] = data[i];
	}

	// overloaded assignment
	MyString& operator=(const MyString& str);

	friend std::ostream& operator<<(std::ostream& out, const MyString& s);
};

std::ostream& operator<<(std::ostream& out, const MyString& s) {
	out << s.m_data;
	return out;
}

// a simplistic implementation of operator= (do not use)
MyString& MyString::operator=(const MyString& str) {
	// if data exists in the current string, delete it
	if (m_data) delete[] m_data;

	m_length = str.m_length;

	// copy the data from str to the implicit object
	m_data = new char[str.m_length];

	for (int i = 0; i < str.m_length; ++i)
		m_data[i] = str.m_data[i];

	// return the existing object so we can chain this operator
	return *this;
}

int main() {
	/*MyString alex("Alex", 5); // meet alex
	MyString employee;
	employee = alex; // alex is our newest employee
	std::cout << employee << '\n'; // say your name, employee*/

	MyString alex("Alex", 5); // meet alex
	alex = alex; // alex is himself
	std::cout << alex << '\n'; // say your name, alex

	return 0;
}