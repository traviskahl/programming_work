/*
2. Write a program in C to calculate the sum of numbers from 1 to n using recursion. Go to the editor
Test Data :
Input the last number of the range starting from 1 : 5
Expected Output :

The sum of numbers from 1 to 5 : 
15
*/

#include <stdio.h>

int sum_recursive(int num);

int main() {
	printf("Input the last number of the range starting from 1 : ");
	int num;
	scanf("%d", &num);

	printf("The sum of numbers from 1 to %d:\n%d\n", num, sum_recursive(num));
}

int sum_recursive(int num) {
	if (num == 0)
		return 0;
	else
		return num + sum_recursive(num-1);
}