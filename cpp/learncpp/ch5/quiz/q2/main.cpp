#include <iostream>
#include <cstdlib>
#include <ctime>

int getRandomNumber(int min, int max) {
    double fraction = 1.0 / (static_cast<double>(RAND_MAX) + 1.0);

    return static_cast<int>(rand() * fraction * (max - min + 1) + min);
}

bool willPlayAgain() {
    bool ret;
    while (true) {
        std::cout << "Would you like to play again (y/n)? ";
        char input;
        std::cin >> input;

        if (input == 'y') {
            ret = true;
            break;
        }
        else if (input == 'n') {
            ret = false;
            break;        
        }
        else {
            std::cin.ignore(32767, '\n');
        }
    }

    return ret;
}

void playGame() {
    std::cout << "Let's play a game. I'm thinking of a number between 1 and 100. You have 7 tries to guess what it is.\n";
    int numberToGuess = getRandomNumber(1, 100);
    bool numberGuessed = false;
    int tries = 1;

    while (!(numberGuessed) && (tries <= 7)) {
        std::cout << "Guess #" << tries << ": ";
        double doubleGuess; // prevent oddness from happening when the user enters a double
        std::cin >> doubleGuess;

        int guess = static_cast<int>(doubleGuess);

        // check for bad input;
        if (std::cin.fail()) {
            std::cin.clear();
            std::cin.ignore(32767, '\n');
            std::cout << "Enter a NUMBER\n";
            continue;
        }

        // check for out of bounds numbers
        if (guess < 1 || guess > 100) {
            std::cout << "That number is out of bounds.\n";
            continue;
        }

        if (guess == numberToGuess) {
            std::cout << "Correct! You win!\n";
            numberGuessed = true;
        }
        else if (guess < numberToGuess) {
            std::cout << "Your guess is too low.\n";
        }
        else {
            std::cout << "Your guess is too high.\n";
        }
        tries++;
    }
    if (!(numberGuessed)) {
        std::cout << "Sorry, you lose. The number was " << numberToGuess << ".\n";
    }
}

int main() {
    srand(static_cast<unsigned int>(time(0)));
    bool willPlay = true;
    while (willPlay) {
        playGame();
        willPlay = willPlayAgain();
    }

    std::cout << "Thank you for playing.\n";
    return 0;
}