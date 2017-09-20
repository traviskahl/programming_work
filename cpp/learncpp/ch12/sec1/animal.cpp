#include <string>
#include <iostream>

class Animal {
protected:
	std::string m_name;

	// We're making this constructor protected because
	// we don't want people creating Animal objects directly,
	// but we still want derived classes to be able to use it.
	Animal(std::string name)
		: m_name(name)
	{
	}

public:
	std::string getName() { return m_name; }
	const char* speak() { return "???"; }
};

class Cat : public Animal {
public:
	Cat(std::string name)
		: Animal(name)
	{
	}

	const char* speak() { return "Meow"; }
};

class Dog : public Animal {
public:
	Dog(std::string name)
		: Animal(name)
	{
	}

	const char* speak() { return "Woof"; }
};

int main() {
	Cat cat("Fred");
	std::cout << "cat is named " << cat.getName() << ", and it says " << cat.speak() << '\n';

	Dog dog("Garbo");
	std::cout << "dog is named " << dog.getName() << ", and it says " << dog.speak() << '\n';

	Animal *pAnimal = &cat;
	std::cout << "pAnimal is named " << pAnimal->getName() << ", and it says " << pAnimal->speak() << '\n';

	pAnimal = &dog;
	std::cout << "pAnimal is named " << pAnimal->getName() << ", and it says " << pAnimal->speak() << '\n';

	return 0;
}