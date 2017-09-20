#include <iostream>

class MinMax {
private:
	int m_min; // the min value seen so far
	int m_max; // the max value seen so far

public:
	MinMax(int min, int max) {
		m_min = min;
		m_max = max;
	}
	
	int getMin() { return m_min; }
	int getMax() { return m_max; }

	friend MinMax operator+(const MinMax& m1, const MinMax& m2);
	friend MinMax operator+(const MinMax& m, int value);
	friend MinMax operator+(int value, const MinMax& m);
};

MinMax operator+(const MinMax& m1, const MinMax& m2) {
	// get the minimum value seen in m1 and m2
	int min = m1.m_min < m2.m_min ? m1.m_min : m2.m_min;

	// get the maximum value seen in m1 and m2
	int max = m1.m_max > m2.m_max ? m1.m_max : m2.m_max;

	return MinMax(min, max);
}

MinMax operator+(const MinMax& m, int value) {
	// get the minimum value seen in m and value
	int min = m.m_min < value ? m.m_min : value;

	// get the maximum value seen in m and value
	int max = m.m_max > value ? m.m_max : value;

	return MinMax(min, max);
}

MinMax operator+(int value, const MinMax& m) {
	// call operator+(MinMax, int)
	return MinMax(m + value);
}

int main(int argc, char const *argv[])
{
	MinMax m1(10, 15);
	MinMax m2(8, 11);
	MinMax m3(3, 12);

	MinMax mFinal = m1 + m2 + 5 + 8 + m3 + 16;

	std::cout << "Result: (" << mFinal.getMin() << ", " << mFinal.getMax() << ")\n";
	
	return 0;
}