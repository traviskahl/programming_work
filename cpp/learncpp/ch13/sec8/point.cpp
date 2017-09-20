#include <iostream>

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

template <typename T>
class Storage<T*> { // this is a partial-specialization of Storage that works with pointer types
private:
	T* m_value;

public:
	Storage(T* value) { // for pointer type T
		// for pointers we'll do a deep copy
		m_value = new T(*value); // this copies a single value, not an array
	}

	~Storage() {
		delete m_value;
	}

	void print() {
		std::cout << *m_value << '\n';
	}
};

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

	return 0;
}