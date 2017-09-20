#include <iostream>
#include <string>

class Animal {
protected:
	std::string m_name;

	// We're making this constructor protected because
	// we don't want people creating Animal objects directly,
	// but we still want derived classes to be able to use it
	Animal (std::string name)
		: m_name(name)
	{
	}

public:
	std::string getName() { return m_name; }
	virtual const char* speak() { return "???"; }
};

class Cat : public Animal {
public:
	Cat(std::string name)
		: Animal(name)
	{
	}

	virtual const char* speak() { return "Meow"; }
};

class Dog : public Animal {
public:
	Dog(std::string name)
		: Animal(name)
	{
	}

	virtual const char* speak() { return "Woof"; }
};

void report(Animal &animal) {
	std::cout << animal.getName() << " says " << animal.speak() << '\n';
}

int main() {
	Cat cat("Fred");
	Dog dog("Garbo");

	report(cat);
	report(dog);

	return 0;
}