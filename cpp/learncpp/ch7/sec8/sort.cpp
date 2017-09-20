#include <utility> // for std::swap, use <algorithm> if not c++11
#include <iostream>

// Note our user-defined comparison is the third parameter
void selectionSort(int *array, int size, bool (*comparisonFcn)(int, int)) {

    // step through each element of the array
    for (int startIndex = 0; startIndex < size; startIndex++) {

        // bestIndex is the index of the smallest/largest index we've found so far
        int bestIndex = startIndex;

        // look for smallest/largest element remaining in the array (starting at startIndex + 1)
        for (int currentIndex = startIndex + 1; currentIndex < size; currentIndex++) {

            // if the current element is smaller/larger than our previously found smallest
            if (comparisonFcn(array[bestIndex], array[currentIndex])) // COMPARISON DONE HERE
                // this is the new smallest/largest number for this iteration
                bestIndex = currentIndex;
        }

        // swap our start element with our smallest/largest element
        std::swap(array[startIndex], array[bestIndex]);
    }
}

// here is a comparison function that sorts in ascending order
// (note: it's exactly the same as the previous ascending() function)
bool ascending(int x, int y) {
    return x > y; // swap if the first element is greater than the second
}

// here is a comparison function that sortst in descending order
bool descending(int x, int y) {
    return x < y;
}

// this function prints out the values in the array
void printArray(int *array, int size) {
    for (int x = 0; x < size; x++)
        std::cout << array[x] << ' ';
    std::cout << '\n';
}

int main() {
    int array[9] = { 3, 7, 9, 5, 6, 1, 8, 2, 4 };

    // sort the array in descending order using the descending() function
    selectionSort(array, 9, descending);
    printArray(array, 9);

    // sort the array in ascending order using the ascending() function
    selectionSort(array, 9, ascending);
    printArray(array, 9);

    return 0;
}