#include <iostream>

int main() {
    std::cout << "Enter an integer: ";
    int smallNum;
    std::cin >> smallNum;

    std::cout << "Enter a larger integer: ";
    int largeNum;
    std::cin >> largeNum;
    
    if (smallNum > largeNum) {
        int temp = largeNum;
        largeNum = smallNum;
        smallNum = temp;
    } // temp dies here

    std::cout << "The smaller value is " << smallNum << '\n';
    std::cout << "The larger value is " << largeNum << '\n';

    return 0;
} // smallNum and largeNum die here