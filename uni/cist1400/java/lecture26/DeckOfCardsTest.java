public class DeckOfCardsTest {
	public static void main(String[] args) {
		DeckOfCards myDeck = new DeckOfCards();
		for (int i = 0; i < 13; i++) {
			System.out.printf("%-20s%-20s%-20s%-20s\n",
								myDeck.dealCard(), myDeck.dealCard(),
								myDeck.dealCard(), myDeck.dealCard());
		}
		System.out.print("\n\n\n");
		myDeck.shuffle();
		for (int i = 0; i < 13; i++) {
			System.out.printf("%-20s%-20s%-20s%-20s\n",
								myDeck.dealCard(), myDeck.dealCard(),
								myDeck.dealCard(), myDeck.dealCard());
		}
	}
}