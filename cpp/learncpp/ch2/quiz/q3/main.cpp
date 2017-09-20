#include <iostream>

double getNumber() {
    std::cout << "Enter a number: ";
    double number;
    std::cin >> number;
    return number;
}

char getOperation() {
    std::cout << "Enter an operation (+ - * /): ";
    char op;
    std::cin >> op;
    return op;
}

int main() {
    double num1 = getNumber();
    char op = getOperation();
    double num2 = getNumber();

    if (op == '+') {
        std::cout << num1 + num2 << '\n';
    }
    else if (op == '-') {
        std::cout << num1 - num2 << '\n';
    }
    else if (op == '*') {
        std::cout << num1 * num2 << '\n';
    }
    else if (op == '/') {
        std::cout << num1 / num2 << '\n';
    }
    else {
        std::cout << '\n';
    }

    return 0;
}