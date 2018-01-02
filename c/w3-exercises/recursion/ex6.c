/*
6. Write a program in C to find the sum of digits of a number using recursion. Go to the editor
Test Data :
Input any number to find sum of digits: 25
Expected Output :

The Sum of digits of 25 = 7 
*/

#include <stdio.h>

int sum_recursive(int num);

int main() {
	printf("Input any number to find sum of digits : ");
	int num;
	scanf("%d", &num);

	int sum = 0;
	while (num > 0) {
		sum += num/10;
		num /= 10;
	}

	printf("The Sum of digits of %d = %d\n", num, sum);

	return 0;
}

int sum_recursive(int num) {
	if (num > 0 && num < 10)
		return 1;
	else
		return sum_recursive(num / 10);
}