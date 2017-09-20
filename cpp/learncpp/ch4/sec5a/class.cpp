#include <iostream>

int main() {
    enum class Color {
        RED,
        BLUE
    };

    enum class Fruit {
        BANANA,
        APPLE
    };

    Color color = Color::RED;
    Fruit fruit = Fruit::BANANA;

    if (color == fruit) // COMPILER ERROR, CAN'T COMPARE OUTSIDE OF DIFFERENT CLASSES
        std::cout << "color and fruit are equal\n";
    else
        std::cout << "color and fruit are not equal\n";

    return 0;
}