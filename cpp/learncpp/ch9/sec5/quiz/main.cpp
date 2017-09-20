#include <iostream>

class Point {
private:
	double m_x;
	double m_y;
	double m_z;

public:
	Point(double x=0.0, double y=0.0, double z=0.0)
		: m_x(x), m_y(y), m_z(z)
	{
	}

	// convert a Point to its negative equivalent
	Point operator-() const;

	// return true if the point is set at the origin
	bool operator!() const;

	// this was added by Travis Kahl
	Point operator+() const;

	double getX() { return m_x; }
	double getY() { return m_y; }
	double getZ() { return m_z; }
};

// convert a Point to its negative equivalent
Point Point::operator-() const {
	return Point(-m_x, -m_y, -m_z);
}

// this was added by Travis Kahl as well
Point Point::operator+() const {
	return *this;
}

// return true if the point is set at the origin, false otherwise
bool Point::operator!() const {
	return (m_x == 0.0 && m_y == 0.0 && m_z == 0.0);
}

int main() {
	Point point; // use default constructor to set to (0.0, 0.0, 0.0)

	if (!point)
		std::cout << "point is set at the origin\n";
	else
		std::cout << "point is not set at the origin\n";

	return 0;
}