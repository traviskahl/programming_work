#include <iostream>

struct Fraction {
    int numerator;
    int denominator;
};

double multiply(Fraction fract1, Fraction fract2) {
    return static_cast<double>(fract1.numerator * fract2.numerator) / (fract1.denominator * fract2.denominator);
}

int main() {
    Fraction fract1;
    std::cout << "Enter the first numerator: ";
    std::cin >> fract1.numerator;

    std::cout << "Enter the first denominator: ";
    std::cin >> fract1.denominator;

    Fraction fract2;
    std::cout << "Enter the second numerator: ";
    std::cin >> fract2.numerator;

    std::cout << "Enter the second denominator: ";
    std::cin >> fract2.denominator;

    std::cout << "The product of the two is " << multiply (fract1, fract2) << '\n';

    return 0;
}