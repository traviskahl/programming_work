#include <iostream>
using arithmeticFcn = int(*)(int, int);

struct ArithmeticStruct {
    char op;
    arithmeticFcn fcn;
};

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

static ArithmeticStruct arithmeticArray[]= {{'+', add}, {'-', subtract}, {'*', multiply}, {'/', divide}};

arithmeticFcn getArithmeticFunction(char oper) {
    for (int x = 0; x < 4; x++) {
        if (arithmeticArray[x].op == oper) {
            return arithmeticArray[x].fcn;
        }
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