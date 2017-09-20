import java.util.Random;
public class DeckOfCards {
	private Card deck[];
	private int currentCard;
	private final int NUM_OF_CARDS = 52;
	private Random randoms;

	public DeckOfCards() {
		String faces[] = { "Ace", "Deuce", "Three", "Four", 
							"Five", "Six", "Seven", "Eight",
							"Nine", "Ten", "Jack", "Queen",
							"King" };
		String suits[] = { "Hearts", "Diamonds", "Clubs", 
							"Spades" };

		deck = new Card[NUM_OF_CARDS];
		currentCard = 0; 
		randoms = new Random();

		for (int a = 0; a < deck.length; a++) {
			deck[a] = new Card(faces[a%13], suits[a/13]);
		}
	}

	public void shuffle() {
		currentCard = 0;
		for (int first = 0; first < deck.length; first++) {
			int second = randoms.nextInt(NUM_OF_CARDS);
			Card temp = deck[first];
			deck[first] = deck[second];
			deck[second] = temp;
		}
	}

	public Card dealCard() {
		Card whichOne;
		if (currentCard < deck.length) {
			whichOne = deck[currentCard++];
		}
		else {
			whichOne = null;
		}
		return whichOne;
	}

}