#include <iostream>

struct Ads {
    int adsShown;
    int percentClicked;
    double averageEarned;
};

double calcRevenue(Ads ads) {
    return ads.adsShown * static_cast<double>(ads.percentClicked / 100) * ads.averageEarned;
}

void printInfo(Ads ads) {
    std::cout << "There were " << ads.adsShown << " ads shown.\n";
    std::cout << ads.percentClicked << " percent of these were clicked.\n";
    std::cout << "On average, each click gave you $" << ads.averageEarned << '\n';
    std::cout << "Through these numbers, you earned " << calcRevenue(ads) << " from ads today.\n";
}

int main() {
    std::cout << "How many ads were shown? > ";
    int shown;
    std::cin >> shown;

    std::cout << "What percent of ads were clicked? > ";
    int clicks;
    std::cin >> clicks;

    std::cout << "On average, how much did each click give you? > ";
    double earned;
    std::cin >> earned;

    Ads ads = {shown, clicks, earned};
    printInfo(ads);

    return 0;
}