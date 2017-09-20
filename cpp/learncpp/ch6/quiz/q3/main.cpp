#include <iostream>

void swap(int &x, int &y) {
    int temp = x;
    x = y;
    y = temp;
}

int main() {
    int x = 5;
    int y = 3;

    std::cout << "Before swap:\n";
    std::cout << "x = " << x << ", y = " << y << '\n';

    swap(x, y);

    std::cout << "After swap:\n";
    std::cout << "x = " << x << ", y = " << y << '\n';

    return 0;
}
