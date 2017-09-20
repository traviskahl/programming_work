#include <iostream>
#include <cstring>

// our Storage class for non-pointers
template <class T>
class Storage {
private:
	T m_value;

public:
	Storage(T value) {
		m_value = value;
	}

	~Storage()
	{
	}

	void print() {
		std::cout << m_value << '\n';
	}
};

// partial-specialization of Storage class for pointers
template <class T>
class Storage<T*> {
private:
	T* m_value;

public:
	Storage(T* value) {
		m_value = new T(*value);
	}

	~Storage() {
		delete m_value;
	}

	void print() {
		std::cout << *m_value << '\n';
	}
};

// full-specialization of constructor for type char*
template <>
Storage<char*>::Storage(char* value) {
	// figure out how long the string in value is
	int length = 0;
	while (value[length] != '\0')
		++length;

	++length; // +1 to account for null terminator

	// allocate memory to hold the value string
	m_value = new char[length];

	// copy the actual value string into the m_value memory we just allocated
	for (int count = 0; count < length; ++count)
		m_value[count] = value[count];
}

// full specialization of destructor for type char*
template <>
Storage<char*>::~Storage() {
	delete[] m_value;
}

// full specialization of print function for type char*
// without this, printing a Storage<char*> would call Storage<T*>::print(), which only prints the first element
template <>
void Storage<char*>::print() {
	std::cout << m_value;
}

int main() {
	// declare a non-pointer Storage to show it works
	Storage<int> myint(5);
	myint.print();

	// declare a pointer Storage to show it works
	int x = 7;
	Storage<int*> myintptr(&x);

	// if myintptr did a pointer assignment on x,
	// then changing x will change myintptr too
	x = 9;
	myintptr.print();

	// dynamically allocate a temporary string
	//char* name = new char[40] { "Alex" }; // requires c++14

	// if your compiler isn't c+++14 compatible, comment out the above line and uncomment these
	char* name = new char[40];
	strcpy(name, "Alex");

	// store the name
	Storage<char*> myname(name);

	// delete the temporary string
	delete[] name;

	// print out our name
	myname.print();

	return 0;
}