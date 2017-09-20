#include <iostream>
#include <math.h>

void getSinCos(double degrees, double &sinOut, double &cosOut) {
    // sin() and cos() take radians, not degrees, so we need to convert
    static const double pi = 3.14159265358979323846; // the value of pi
    double radians = degrees * pi / 180.0;
    sinOut = sin(radians);
    cosOut = cos(radians);
}

int main() {
    double sin = 0.0;
    double cos = 0.0;

    // getSinCos will return the sin and cos in variables sin and cos
    getSinCos(30.0, sin, cos);

    std::cout << "The sin is " << sin << '\n';
    std::cout << "The cos is " << cos << '\n';

    return 0;
}