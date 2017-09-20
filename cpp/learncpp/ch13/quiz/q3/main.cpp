#include <iostream>
#include <string>

template <class T1, class T2>
class Pair {
private:
	T1 m_var1;
	T2 m_var2;

public:
	Pair(const T1& var1, const T2& var2)
		: m_var1(var1), m_var2(var2)
	{
	}

	const T1& first() const { return m_var1; }
	const T2& second() const { return m_var2; }
};

template <class T>
class StringValuePair : public Pair<std::string, T> {
public:
	StringValuePair(const std::string& str, const T& val)
		: Pair<std::string, T>(str, val)
	{
	}
};

int main() {
	StringValuePair<int> svp("Hello", 5);
	std::cout << "Pair: " << svp.first() << ' ' << svp.second() << '\n';
 
	return 0;
}