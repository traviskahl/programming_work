#include <iostream>
#include <cmath>

class Point2d {
private:
    double m_x;
    double m_y;
public:
    Point2d(double x=0, double y=0) : m_x { x }, m_y { y }
    {
    }

    void print() {
        std::cout << "Point2d(" << m_x << ", " << m_y << ")\n";
    }

    friend double distanceTo(const Point2d &point1, const Point2d &point2);
};

double distanceTo(const Point2d &point1, const Point2d &point2) {
    return sqrt((point1.m_x - point2.m_x) * (point1.m_x - point2.m_x) + (point1.m_y - point2.m_y) * (point1.m_y - point2.m_y));
}

int main() {
    Point2d first;
    Point2d second(3.0, 4.0);
    first.print();
    second.print();
    std::cout << "Distance between two points: " << distanceTo(first, second) << '\n';

    return 0;
}