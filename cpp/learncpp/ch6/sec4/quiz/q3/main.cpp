#include <utility> // for std::swap
#include <iostream>

int main() {
    const int length = 9;
    int array[length] = { 6, 3, 2, 9, 7, 1, 5, 4, 8 };

    int numSorted = 1;
    for (int pass = 1; pass <= length; pass++) {
        bool performedSort = false;
        for (int currentIndex = 0; currentIndex < length - numSorted; currentIndex++) {
            if (array[currentIndex] > array[currentIndex+1]) {
                std::swap(array[currentIndex], array[currentIndex+1]);
                performedSort = true;
            }
        }
        if (!(performedSort)) {
            std::cout << "Early termination on pass " << pass << '\n';
            break;
        }
        numSorted++;
    }

    for (int x = 0; x < length; x++) {
        std::cout << array[x] << ' ';
    }
    std::cout << '\n';

    return 0;
}