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

// Import necessary libraries
#include <stdio.h>
#include <stdlib.h>

// Runtime constants
#define SEPARATOR "----------------------\n"
#define PLAYER_1 0
#define PLAYER_2 1
#define P1_MARKER 'X'
#define P2_MARKER 'O'

char** get_board();
void destroy_board(char** board);
void print_board(char** board);
void get_input(int* xval, int* yval);
int make_selection(char** board, int player, int xval, int yval);
int check_board(char** board);
int play_game(char** board);

// The main function
// -----------------
int main() {
	char** board = get_board();
	int winner = play_game(board);
	if (winner == PLAYER_1)
		printf("Player 1 wins!\n");
	else if (winner == PLAYER_2)
		printf("Player 2 wins!\n");
	else
		printf("Draw!\n");

	destroy_board(board);
	return 0;
}

// Return a 3x3 board, all elements initialized to 'N'
// ---------------------------------------------------
char** get_board() {
	char* values = calloc(3*3, sizeof(char));
	char** board = malloc(3 * sizeof(char*));
	for (int i = 0; i < 3; ++i)
		board[i] = values + i*3;

	for (int i = 0; i < 3; ++i) {
		for (int j = 0; j < 3; ++j)
			board[i][j] = 'N';
	}

	return board;
}

// Deallocate the memory given to our board
// ----------------------------------------
void destroy_board(char** board) {
	free(*board);
	free(board);
}

// print the 3x3 board with labeled axes
// -------------------------------------
void print_board(char** board) {
	printf(" |  0  |  1  |  2  |\n");
	for (int row = 0; row < 3; ++row) {
		printf(SEPARATOR);
		printf("%d|  ", row);
		for (int col = 0; col < 3; ++col) {
			printf("%c  |  ", board[row][col]);
		}
		printf("\n");
	}
	printf("\n");
}

// Get the player's input on which tile they want to play on
// ---------------------------------------------------------
void get_input(int* xval, int* yval) {

	int xin, yin;
	do {
		printf("Enter in this format (x y): ");
		scanf("%d %d", &xin, &yin);
	} while (xin < 0 || xin > 3 || yin < 0 || yin > 3);

	*xval = xin;
	*yval = yin;
}

// Make the player's selection. Return 0 if choice already taken.
// --------------------------------------------------------------
int make_selection(char** board, int player, int xval, int yval) {
	// see if it's been taken
	if (board[xval][yval] != 'N')
		return 0;

	char marker;
	if (player == PLAYER_1)
		marker = P1_MARKER;
	else
		marker = P2_MARKER;

	board[xval][yval] = marker;
	return 1;
}

// Check the board to see if someone won
// COME HERE
// -------------------------------------
int check_board(char** board) {
	// first check across
	//for (int )
	return -1;
}

// Play the game out
// -----------------
int play_game(char** board) {
	int turn = 0;
	int player = PLAYER_1;
	while (turn < 9) {
		printf("Turn %d\n", turn+1);
		print_board(board);
		printf("Player %d:\n", player+1);
		int xval, yval;
		get_input(&xval, &yval);

		if (!make_selection(board, player, yval, xval)) { // it's important to switch our y and x here, otherwise movements are switched
			printf("Tile already played.\n");
			continue;
		}

		if (check_board(board))
			return player;

		player = !player; // alternate players
		++turn;
	}
	return -1; // for a draw
}