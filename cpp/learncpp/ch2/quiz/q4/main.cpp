#include <iostream>
#include "constants.h"

int getHeight() {
    std::cout << "Enter the initial height of the tower in meters: ";
    int initialHeight;
    std::cin >> initialHeight;
    return initialHeight;
}

double calcHeight(double seconds) {
    // formula is gravity * (seconds^2) / 2
    double height = (myConstants::gravity * ((seconds * seconds) / 2));
    return height;
}

void printHeight(int seconds, double height) {
    if (height <= 0) {
        std::cout << "At " << seconds << " seconds, the ball is on the ground.\n";
    }
    else {
        std::cout << "At " << seconds << " seconds, the ball is at height: " << height << " meters.\n";
    }
}

int main() {
    int initialHeight = getHeight();
    printHeight(0, initialHeight);
    printHeight(1, initialHeight - calcHeight(1));
    printHeight(2, initialHeight - calcHeight(2));
    printHeight(3, initialHeight - calcHeight(3));
    printHeight(4, initialHeight - calcHeight(4));
    printHeight(5, initialHeight - calcHeight(5));

    return 0;
}