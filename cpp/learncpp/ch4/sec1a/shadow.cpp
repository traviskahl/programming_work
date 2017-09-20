#include <iostream>

int main() { // outer block
    int apples = 5; // here's the outer block apples

    if (apples >= 5) { // refers to outer block apples
        int apples; // hides previous variable named apples

        // apples now refers to the nested block apples
        // the outer block apples is temporarily hidden

        apples = 10; // assigns value 10 to nested block apples, not outer block apples

        std::cout << apples << '\n';
    } // nested block apples destroyed

    // apples now refers to the outer block apples again

    std::cout << apples << '\n';

    return 0;
} // outer block apples destroyed