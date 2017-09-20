#include <iostream>
#include <array>
#include <cstdlib>
#include <ctime>

enum CardRank {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING,
    MAX_RANKS
};

enum CardSuit {
    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES,
    MAX_SUITS
};

struct Card {
    CardRank rank;
    CardSuit suit;
};

void printCard(const Card &currCard) {

    switch (currCard.rank) {
        case ACE:           std::cout << 'A'; break;
        case TWO:           std::cout << '2'; break;
        case THREE:         std::cout << '3'; break;
        case FOUR:          std::cout << '4'; break;
        case FIVE:          std::cout << '5'; break;
        case SIX:           std::cout << '6'; break;
        case SEVEN:         std::cout << '7'; break;
        case EIGHT:         std::cout << '8'; break;
        case NINE:          std::cout << '9'; break;
        case TEN:           std::cout << 'T'; break;
        case JACK:          std::cout << 'J'; break;
        case QUEEN:         std::cout << 'Q'; break;
        case KING:          std::cout << 'K'; break;
    }

    switch (currCard.suit) {
        case CLUBS:         std::cout << 'C'; break;
        case DIAMONDS:      std::cout << 'D'; break;
        case HEARTS:        std::cout << 'H'; break;
        case SPADES:        std::cout << 'S'; break;
    }
}

void printDeck(const std::array<Card, 52> &deck) {
    for (const auto &currCard : deck) {
        printCard(currCard);
        std::cout << ' ';
    }
    std::cout << '\n';
}

void swapCard(Card &card1, Card &card2) {
    Card temp = card1;
    card1 = card2;
    card2 = temp;
}

int getRandomNumber(int min, int max) {
    static const double fraction = 1.0 / (static_cast<double>(RAND_MAX) + 1.0);
    return static_cast<int>(rand() * fraction * (max - min + 1) + min);
}

void shuffleDeck(std::array<Card, 52> &deck) {
    for (int x = 0; x < 52; x++) {
        int swapIndex = getRandomNumber(0 ,51);
        swapCard(deck[x], deck[swapIndex]);
    }
}

int getCardValue(Card currCard) {
    int ret = 0;
    switch (currCard.rank) {
        case ACE:       ret = 11; break;
        case TWO:       ret = 2; break;
        case THREE:     ret = 3; break;
        case FOUR:      ret = 4; break;
        case FIVE:      ret = 5; break;
        case SIX:       ret = 6; break;
        case SEVEN:     ret = 7; break;
        case EIGHT:     ret = 8; break;
        case NINE:      ret = 9; break;
        case TEN: case JACK:
        case QUEEN: case KING:
            ret = 10; break;
    }

    return ret;
}

bool playBlackjack(std::array<Card, 52> &deck) {
    Card *cardPtr = &deck[0];
    bool didWin = false;

    int dealerScore = getCardValue(*(cardPtr++));
    int playerScore = getCardValue(*(cardPtr++));
    playerScore += getCardValue(*(cardPtr++));

    while (true) {
        std::cout << "Your score is: " << playerScore << '\n';
        std::cout << "The dealer's score is: " << dealerScore << '\n';

        std::cout << "Do you hit(h) or stand(s)? > ";
        char choice;
        std::cin >> choice;

        if (choice == 'h') {
            playerScore += getCardValue(*(cardPtr++));
            std::cout << "You hit.\n";
        }
        else {
            std::cout << "You stand.\n";
        }

        if (playerScore >= 21) {
            didWin = false;
            break;
        }

        if (dealerScore < 17) {
            dealerScore += getCardValue(*(cardPtr++));
            std::cout << "The dealer hits.\n";
        }
        else {
            std::cout << "The dealer stands.\n";
        }

        if (dealerScore > 21) {
            didWin = true;
            break;
        }
        else if ((dealerScore >= 17 && dealerScore <= 21) && (playerScore > dealerScore)) {
            didWin = true;
            break;
        }
    }
    std::cout << '\n';
    std::cout << "The final scores were:\n";
    std::cout << "You: " << playerScore << '\n';
    std::cout << "Dealer: " << dealerScore << '\n';
    return didWin;
}

int main() {
    srand(static_cast<unsigned int>(time(0)));

    std::array<Card, 52> deck;

    int card = 0;
    for (int suit = 0; suit < MAX_SUITS; suit++) {
        for (int rank = 0; rank < MAX_RANKS; rank++) {
            deck[card].suit = static_cast<CardSuit>(suit);
            deck[card].rank = static_cast<CardRank>(rank);
            card++;
        }
    }

    shuffleDeck(deck);
    bool willPlay = true;
    do {
        bool didWin = playBlackjack(deck);
        if (didWin)
            std::cout << "You won!\n";
        else
            std::cout << "You lost!\n";

        std::cout << "Play again (y/n)? > ";
        char input;
        std::cin >> input;
        if (input == 'y')
            willPlay = true;
        else
            willPlay = false;
    } while (willPlay);

    return 0;
}