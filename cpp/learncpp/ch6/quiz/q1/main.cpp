#include <iostream>
#include <string>

enum Items {
    HEALTH_POT,
    TORCH,
    ARROW,
    MAX_ITEMS
};

int countTotalItems(int *inven) {
    int totalItems = 0;
    for (int x = 0; x < MAX_ITEMS; x++) {
        totalItems += inven[x];
    }

    return totalItems;
}

int main() {
    int player[] = { 2, 5, 10 };
    std::cout << "The player has " << countTotalItems(player) << " items.\n";

    return 0;
}