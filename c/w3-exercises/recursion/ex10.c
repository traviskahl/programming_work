/*
10. Write a program in C to find the Factorial of a number using recursion. Go to the editor
Test Data :
Input a number : 5
Expected Output :

The Factorial of 5 is : 120
*/

#include <stdio.h>

int factorial_recursive(int num);

int main() {
	printf("Input a number : ");
	int num;
	scanf("%d", &num);

	printf("The factorial of %d is : %d\n", num, factorial_recursive(num));

	return 0;
}

int factorial_recursive(int num) {
	if (num == 1)
		return 1;
	else
		return num * factorial_recursive(num-1);
}