#include <iostream>
#include <string>

class Mystring {
private:
	std::string m_string;

public:
	Mystring(const std::string& str)
		: m_string(str)
	{
	}

	const std::string operator()(int start, int num) const;
};

const std::string Mystring::operator()(int start, int num) const {
	std::string ret = "";
	for (int index = start; index < start + num; ++index)
		ret += m_string[index];

	return ret;
}

int main() {
    Mystring string("Hello, world!");
    std::cout << string(7, 5); // start at index 7 and return 5 characters
 
    return 0;
}