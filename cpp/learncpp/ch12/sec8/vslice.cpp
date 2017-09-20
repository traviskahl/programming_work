#include <iostream>
#include <vector>

class Base
{
protected:
    int m_value;
 
public:
    Base(int value)
        : m_value(value)
    {
    }
 
    virtual const char* getName() const { return "Base"; }
    int getValue() const { return m_value; }
};
 
class Derived: public Base
{
public:
    Derived(int value)
        : Base(value)
    {
    }
 
    virtual const char* getName() const { return "Derived"; }
};

int main() {
	std::vector<Base> v;
	v.push_back(Base(5)); // add a Base object to our vector
	v.push_back(Derived(6)); // add a Derived object to our vector

	// Print out all of the elements in our vector
	for (int count = 0; count < v.size(); ++count)
		std::cout << "I am a " << v[count].getName() << " with value " << v[count].getValue() << '\n';

	return 0;
}