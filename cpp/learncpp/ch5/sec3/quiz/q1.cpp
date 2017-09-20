#include <iostream>

int calculate(int x, int y, char op) {
    int ret = 0;

    switch (op) {
        case '+':
            ret = x + y;
            break;
        case '-':
            ret = x - y;
            break;
        case '*':
            ret = x * y;
            break;
        case '/':
            ret = x / y;
            break;
    }

    return ret;
}

int main() {
    std::cout << calculate(3, 5, '+') << '\n';
    std::cout << calculate(3, 5, '-') << '\n';
    std::cout << calculate(3, 5, '*') << '\n';
    std::cout << calculate(3, 5, '/') << '\n';

    return 0;
}