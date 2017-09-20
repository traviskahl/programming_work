#include <iostream>
#include <vector>

class Point {
private:
	int m_x = 0;
	int m_y = 0;
	int m_z = 0;

public:
	Point(int x, int y, int z)
		: m_x(x), m_y(y), m_z(z)
	{
	}

	friend std::ostream& operator<<(std::ostream& out, const Point& p) {
		out << "Point(" << p.m_x << ", " << p.m_y << ", " << p.m_z << ")";
		return out;
	}
};

class Shape {
public:
	virtual std::ostream& print(std::ostream& out) const = 0;

	friend std::ostream& operator<<(std::ostream& out, const Shape& s) {
		return s.print(out);
	}

	virtual ~Shape() {}
};

class Circle : public Shape {
private:
	Point m_center;
	int m_radius;

public:
	Circle(const Point& center, int radius)
		: m_center(center), m_radius(radius)
	{
	}

	virtual std::ostream& print(std::ostream& out) const override {
		out << "Circle(" << m_center << ", radius " << m_radius << ")";
		return out;
	}

	int getRadius() const { return m_radius; }

	virtual ~Circle() {}
};

class Triangle : public Shape {
private:
	Point m_point1;
	Point m_point2;
	Point m_point3;

public:
	Triangle(const Point& p1, const Point& p2, const Point& p3)
		: m_point1(p1), m_point2(p2), m_point3(p3)
	{
	}

	virtual std::ostream& print(std::ostream& out) const override {
		out << "Triangle(" << m_point1 << ", " << m_point2 << ", " << m_point3 << ")";
		return out;
	}

	virtual ~Triangle() {}
};

int getLargestRadius(const std::vector<Shape*>& v) {
	int largestRadius = 0;
	for (unsigned int curShape = 0; curShape < v.size(); ++curShape) {
		Circle* c = dynamic_cast<Circle*>(v[curShape]);
		if (c && c->getRadius() > largestRadius)
			largestRadius = c->getRadius();
	}
	return largestRadius;
}

int main() {
	/*Circle c(Point(1, 2, 3), 7);
    std::cout << c << '\n';
 
    Triangle t(Point(1, 2, 3), Point(4, 5, 6), Point(7, 8, 9));
    std::cout << t << '\n';*/

	std::vector<Shape*> v;
	v.push_back(new Circle(Point(1, 2, 3), 7));
	v.push_back(new Triangle(Point(1, 2, 3), Point(4, 5, 6), Point(7, 8, 9)));
	v.push_back(new Circle(Point(4, 5, 6), 3));
 
	// print each shape in vector v on its own line here
	for (unsigned int curShape = 0; curShape < v.size(); ++curShape)
		std::cout << *(v[curShape]) << '\n';
 
    std::cout << "The largest radius is: " << getLargestRadius(v) << '\n'; // write this function
 
	// delete each element in the vector here
 
    return 0;
}