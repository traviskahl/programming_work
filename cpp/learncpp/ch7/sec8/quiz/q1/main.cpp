#include <iostream>
using arithmeticFcn = int(*)(int, int);

int getNumber() {
    std::cout << "Enter a number: ";
    int input;
    std::cin >> input;
    return input;
}

char getOperation() {
    char input;
    do {
        std::cout << "Enter an operator (+ - * /): ";
        std::cin >> input;
    } while (input != '+' && input != '-' && input != '*' && input != '/');
    return input;
}

int add(int x, int y) {
    return x + y;
}

int subtract(int x, int y) {
    return x - y;
}

int multiply(int x, int y) {
    return x * y;
}

int divide(int x, int y) {
    return x / y;
}

arithmeticFcn getArithmeticFunction(char op) {
    switch (op) {
        case '+':       return add;
        case '-':       return subtract;
        case '*':       return multiply;
        case '/':       return divide;
        default:        return nullptr;
    }
}

int main() {

    int x = getNumber();
    char op = getOperation();
    int y = getNumber();

    arithmeticFcn fcnToUse = getArithmeticFunction(op);

    std::cout << x << op << y << " is " << fcnToUse(x, y) << '\n';

    return 0;
}