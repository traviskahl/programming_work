#include <iostream>

// ref is a reference to the argument passed in, not a copy
void changeN(int &ref) {
    ref = 6;
}

int main() {
    int n = 5;

    std::cout << n << '\n';

    changeN(n); // note that this is a non-reference argument

    std::cout << n << '\n';
    return 0;
}