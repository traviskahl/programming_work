#include <iostream>
#include <chrono> // for std::chrono functions

template <class T>
class DynamicArray {
private:
	T* m_array;
	int m_length;

public:
	DynamicArray(int length)
		: m_length(length), m_array(new T[length])
	{
	}

	~DynamicArray() {
		delete[] m_array;
	}

	// Copy constructor
	DynamicArray(const DynamicArray &arr)
		: m_length(arr.m_length) {
		m_array = new T[m_length];
		for (int i = 0; i < m_length; ++i)
			m_array[i] = arr.m_array[i];
	}

	// Copy assignment
	DynamicArray& operator=(const DynamicArray &arr) {
		if (&arr == this)
			return *this;

		delete[] m_array;

		m_length = arr.m_length;
		m_array = new T[m_length];

		for (int i = 0; i < m_length; ++i)
			m_array[i] = arr.m_array[i];

		return *this;
	}

	int getLength() const { return m_length; }
	T& operator[](int index) { return m_array[index]; }
	const T& operator[](int index) const { return m_array[index]; }
};

class Timer {
private:
	// Type aliases to make accessing nested type easier
	using clock_t = std::chrono::high_resolution_clock;
	using second_t = std::chrono::duration<double, std::ratio<1> >;

	std::chrono::time_point<clock_t> m_beg;

public:
	Timer()
		: m_beg(clock_t::now())
	{
	}

	void reset() {
		m_beg = clock_t::now();
	}

	double elapsed() const {
		return std::chrono::duration_cast<second_t>(clock_t::now() - m_beg).count();
	}
};

// Return a copy of arr with all of the values doubled
DynamicArray<int> cloneArrayAndDouble(const DynamicArray<int> &arr) {
	DynamicArray<int> dbl(arr.getLength());
	for (int i = 0; i < arr.getLength(); ++i)
		dbl[i] = arr[i] * 2;

	return dbl;
}

int main() {
	Timer t;

	DynamicArray<int> arr(1000000); // this is 1mil btw
	for (int i = 0; i < arr.getLength(); ++i) {
		arr[i] = i;
	}

	arr = cloneArrayAndDouble(arr);

	std::cout << t.elapsed() << '\n';

	return 0;
}