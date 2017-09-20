#include <iostream>

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

int main() {
	Pair<int, double> p1(5, 6.7);
	std::cout << "Pair: " << p1.first() << ' ' << p1.second() << '\n';
 
	const Pair<double, int> p2(2.3, 4);
	std::cout << "Pair: " << p2.first() << ' ' << p2.second() << '\n';
 
	return 0;
}