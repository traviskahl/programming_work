#include <iostream>

int main() {
    const int numStudents = 5;
    int scores[numStudents] = { 84, 92, 76, 81, 56 };
    int maxScore = 0; // keep track of index of our largest score
    for (auto score : scores) { // iterate over array scores, assigning each value in turn to variable score
        if (score > maxScore)
            maxScore = score;
    }
    std::cout << "The best score was " << maxScore << '\n';

    return 0;
}