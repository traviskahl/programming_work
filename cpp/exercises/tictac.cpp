/*
Requires:
variables, data types, and numerical operators
basic input/output
logic (if statements, switch statements)
loops (for, while, do-while)
arrays

Make a two player tic tac toe game.

★ Modify the program so that it will announce when a player has won the game (and which player won, x or o)

★★ Modify the program so that it is a one player game against the computer (with the computer making its moves randomly)

★★★★ Modify the program so that anytime the player is about to win (aka, they have 2 of 3 x's in a row, the computer will block w/ an o)
*/

#include <iostream>
#include <string>

void print_line();
void print_board(char board[3][3]);
void make_selection(int player, char board[3][3]);
bool check_board(char board[3][3]);
int play_game(char board[3][3]);

int main() {

	// create board and initialize everything to '0'
	char board[3][3];
	for (int i = 0; i < 3; ++i) {
		for (int j = 0; j < 3; ++j)
			board[i][j] = '0';
	}

	play_game(board);

	int winner = play_game(board);

	return 0;
}

// a utility function to print a solid line
void print_line() {
	std::cout << "-----------------------\n";
}

void print_board(char board[3][3]) {
	// we should start by printing a header
	std::cout << " |  0  |  1  |  2  |\n";
	for (int i = 0; i < 3; ++i) {
		print_line();
		std::cout << i << "|  ";
		for (int j = 0; j < 3; ++j) {
			std::cout << board[i][j] << "  |  ";
		}
		std::cout << '\n';
	}
}

void make_selection(int player, char board[3][3]) {
	char marker;
	if (player == 1)
		marker = 'X';
	else
		marker = 'O';

	std::cout << "Player " << player << ":\n";

	do {
		std::cout << "Give the X-Value of the space you want: ";
		int xval;
		std::cin >> xval;
	} while (xval < 0 && xval > 3);

	std::cout << "Give the Y-Value of the space you want: ";
	int yval;
	std::cin >> yval;
}

bool check_board(char board[3][3]) {
	return false;
}

int play_game(char board[3][3]) {
	bool player_has_won = false;
	bool is_player_one = true;
	while (!player_has_won) {
		if (is_player_one)
			make_selection(1, board);
		else
			make_selection(2, board);

		check_board(board);
		is_player_one = !is_player_one;
	}

	return 1;
}