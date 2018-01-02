/*
5. Write a program in C to count the digits of a given number using recursion. Go to the editor
Test Data :
Input a number : 50
Expected Output :

The number of digits in the number is :  2
*/

#include <stdio.h>

int num_digits_recursive(int num);

int main() {
	printf("Input a number : ");
	int num;
	scanf("%d", &num);

	printf("The number of digits in the number is : %d\n", num_digits_recursive(num));
}

int num_digits_recursive(int num) {
	if (num < 1)
		return 0;
	else
		return num_digits_recursive(num / 10) + 1;
}