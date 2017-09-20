#include <iostream>
#include <array>
#include <ctime> // for time()
#include <cstdlib> // for rand() and srand()

class Card {
public:
    enum CardSuit {
	    SUIT_CLUB,
	    SUIT_DIAMOND,
	    SUIT_HEART,
	    SUIT_SPADE,
	    MAX_SUITS
    };

    enum CardRank {
	    RANK_2,
	    RANK_3,
	    RANK_4,
	    RANK_5,
	    RANK_6,
	    RANK_7,
	    RANK_8,
	    RANK_9,
	    RANK_10,
	    RANK_JACK,
	    RANK_QUEEN,
	    RANK_KING,
	    RANK_ACE,
	    MAX_RANKS
    };

    Card(CardRank rank=RANK_2, CardSuit suit=SUIT_CLUB) : m_suit { suit }, m_rank { rank }
    {
    }

    void printCard() const {
	    switch (m_rank) {
		    case RANK_2:		std::cout << '2'; break;
		    case RANK_3:		std::cout << '3'; break;
		    case RANK_4:		std::cout << '4'; break;
		    case RANK_5:		std::cout << '5'; break;
		    case RANK_6:		std::cout << '6'; break;
		    case RANK_7:		std::cout << '7'; break;
		    case RANK_8:		std::cout << '8'; break;
		    case RANK_9:		std::cout << '9'; break;
		    case RANK_10:		std::cout << 'T'; break;
		    case RANK_JACK:		std::cout << 'J'; break;
		    case RANK_QUEEN:	std::cout << 'Q'; break;
		    case RANK_KING:		std::cout << 'K'; break;
		    case RANK_ACE:		std::cout << 'A'; break;
	    }

        switch (m_suit) {
		    case SUIT_CLUB:		std::cout << 'C'; break;
		    case SUIT_DIAMOND:	std::cout << 'D'; break;
		    case SUIT_HEART:	std::cout << 'H'; break;
		    case SUIT_SPADE:	std::cout << 'S'; break;
	    }
    }

    int getCardValue() const {
	    switch (m_rank) {
	        case RANK_2:		return 2;
	        case RANK_3:		return 3;
	        case RANK_4:		return 4;
	        case RANK_5:		return 5;
	        case RANK_6:		return 6;
	        case RANK_7:		return 7;
	        case RANK_8:		return 8;
	        case RANK_9:		return 9;
	        case RANK_10:		return 10;
	        case RANK_JACK:		return 10;
	        case RANK_QUEEN:	return 10;
	        case RANK_KING:		return 10;
	        case RANK_ACE:		return 11;
	    }
	    return 0;
    }   

private:
    CardSuit m_suit;
    CardRank m_rank;
};

class Deck {
private:
    std::array<Card, 52> m_deck;
    int m_cardIndex = 0;

    static void swapCard(Card &a, Card &b) {
	    Card temp = a;
	    a = b;
	    b = temp;
    }

    // Generate a random number between min and max (inclusive)
    // Assumes srand() has already been called
    static int getRandomNumber(int min, int max) {
	    static const double fraction = 1.0 / (static_cast<double>(RAND_MAX) + 1.0);  // static used for efficiency, so we only calculate this value once
 	    // evenly distribute the random number across our range
	    return static_cast<int>(rand() * fraction * (max - min + 1) + min);
    }

public:
    Deck() {
        int card = 0;
        for (int rank = 0; rank < Card::MAX_RANKS; rank++) {
            for (int suit = 0; suit < Card::MAX_SUITS; suit++) {
                m_deck[card++] = Card(static_cast<Card::CardRank>(rank), static_cast<Card::CardSuit>(suit));
            }
        }
    }

    void shuffleDeck() {
        m_cardIndex = 0;
	    // Step through each card in the deck
	    for (int index = 0; index < 52; ++index) {
		    // Pick a random card, any card
		    int swapIndex = getRandomNumber(0, 51);
		    // Swap it with the current card
		    swapCard(m_deck[index], m_deck[swapIndex]);
	    }
    }

    void printDeck() {
	    for (const auto &card : m_deck) {
	    	card.printCard();
		    std::cout << ' ';
	    }
	    std::cout << '\n';
    }

    const Card &dealCard() {
        const Card &ret = m_deck[m_cardIndex++];
        return ret;
    }
};
 
bool playBlackjack(Deck &deck) {
    // initialize game values
	int playerTotal = deck.dealCard().getCardValue();
	int dealerTotal = deck.dealCard().getCardValue();
    dealerTotal += deck.dealCard().getCardValue();
    bool didWin = false;

    // main loop of the function
	while (true) {
        // display helpful information
        std::cout << "Your score is: " << playerTotal << '\n';
        std::cout << "The dealer's score is: " << dealerTotal << '\n';

        // get input
        std::cout << "Do you hit (h) or stand (s)? > ";
        char input;
        std::cin >> input;

        // what was the user's choice?
        if (input == 'h') {
            playerTotal += deck.dealCard().getCardValue();
            std::cout << "You hit.\n";
        }
        else {
            std::cout << "You stand.\n";
        }

        // did the player bust?
        if (playerTotal >= 21) {
            didWin = false;
            break;
        }

        // should the dealer hit?
        if (dealerTotal < 17) {
            dealerTotal += deck.dealCard().getCardValue();
            std::cout << "The dealer hits.\n";
        }
        else {
            std::cout << "The dealer stands.\n";
        }

        // did the dealer bust?
        if (dealerTotal > 21) {
            didWin = true;
            break;
        }
        else if ((dealerTotal >= 17 && dealerTotal <= 21) && (playerTotal > dealerTotal)) { // did the player win by having a higher score?
            didWin = true;
            break;
        }

    }

    // display final scores
    std::cout << "The final scores were:\n";
    std::cout << "Dealer: " << dealerTotal << '\n';
    std::cout << "Player: " << playerTotal << '\n';
	return didWin;
}

int main() {
    srand(static_cast<unsigned int>(time(0)));
    
    Deck deck;

    bool willPlay = true;
    do {
        deck.shuffleDeck();
        if (playBlackjack(deck)) {
            std::cout << "You win!\n";
        }
        else {
            std::cout << "You lose!\n";
        }

        std::cout << "Play again? (y/n) ";
        char input;
        std::cin >> input;

        if (input != 'y')
            willPlay = false;
    } while (willPlay);
    return 0;
}

/*
 
int main() {
	srand(static_cast<unsigned int>(time(0))); // set initial seed value to system clock
	rand(); // If using Visual Studio, discard first random value
 
	std::array<Card, 52> deck;
	
	// We could initialize each card individually, but that would be a pain.  Let's use a loop.
	int card = 0;
	for (int suit = 0; suit < MAX_SUITS; ++suit)
	for (int rank = 0; rank < MAX_RANKS; ++rank) {
		deck[card].suit = static_cast<CardSuit>(suit);
		deck[card].rank = static_cast<CardRank>(rank);
		++card;
	}
	
	shuffleDeck(deck);
 
	if (playBlackjack(deck))
		std::cout << "You win!\n";
	else
		std::cout << "You lose!\n";
 
	return 0;
}*/