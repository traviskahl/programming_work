#include <iostream>

int main() {
    int outer = 5;
    while (outer >= 1) {
        int inner = 5;
        while (inner >= outer) {
            std::cout << inner++ << " ";
        }

        std::cout << '\n';
        --outer;
    }
}