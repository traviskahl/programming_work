/*
4. Write a program in C to check a given number is even or odd using the function. Go to the editor
Test Data :
Input any number : 5
Expected Output :

 The entered number is odd.
 */

#include <stdio.h>

typedef enum { false, true } bool;

bool is_even(int num);

int main() {
	printf("Input any number : ");
	int num;
	scanf("%d", &num);

	if (is_even(num))
		printf("The entered number is even.\n");
	else
		printf("The entered number is odd.\n");
}

bool is_even(int num) {
	return num % 2 == 0;
}