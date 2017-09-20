#include <iostream>

template <class T>
class Auto_ptr1 {
	T* m_ptr;

public:
	// Pass in a pointer to "own" via the constructor
	Auto_ptr1(T* ptr=nullptr)
		: m_ptr(ptr)
	{
	}

	// The destructor will make sure it gets deallocated
	~Auto_ptr1() {
		delete m_ptr;
	}

	// Overload dereference and operator-> so we can use Auto_ptr1 like m_ptr
	T& operator*() const { return *m_ptr; }
	T* operator->() const { return m_ptr; }
};

// A sample class to prove the above works
class Resource {
public:
	Resource() { std::cout << "Resource aquired\n"; }
	~Resource() { std::cout << "Resource destroyed\n"; }
	void sayHi() { std::cout << "Hi!\n"; }
};

void someFunction() {
	Auto_ptr1<Resource> ptr(new Resource); // ptr now owns the resource

	int x;
	std::cout << "Enter an integer: ";
	std::cin >> x;

	if (x == 0)
		return; // the function returns early

	// do stuff with ptr here
	ptr->sayHi();
}

int main() {
	// Auto_ptr1<Resource> res(new Resource); // note the allocation of memory here

	// ... but no explicit delete needed

	// also note that the Resource in angled braces doesn't need a * symbol, since that's supplied by the template

	// someFunction();

	Auto_ptr1<Resource> res1(new Resource);
	Auto_ptr1<Resource> res2(res1);

	return 0;
} // res goes out of scope here, and destroys the allocated Resource for us