#include <iostream>

template <class T>
class Pair1 {
private:
	T m_var1;
	T m_var2;

public:
	Pair1(const T& var1, const T& var2)
		: m_var1(var1), m_var2(var2)
	{
	}

	const T& first() const { return m_var1; }
	const T& second() const { return m_var2; }
};

int main() {
	Pair1<int> p1(5, 8);
	std::cout << "Pair: " << p1.first() << ' ' << p1.second() << '\n';
 
	const Pair1<double> p2(2.3, 4.5);
	std::cout << "Pair: " << p2.first() << ' ' << p2.second() << '\n';
 
	return 0;
}