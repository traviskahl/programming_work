/*
3. Write a program in C to swap two numbers using function. Go to the editor
Test Data :
Input 1st number : 2
Input 2nd number : 4
Expected Output :

Before swapping: n1 = 2, n2 = 4                                                  
After swapping: n1 = 4, n2 = 2 
*/

#include <stdio.h>

void swap_int(int* n1, int* n2);

int main() {
	int n1, n2;

	printf("Input 1st number : ");
	scanf("%d", &n1);
	printf("Input 2nd number : ");
	scanf("%d", &n2);

	printf("Before swapping: n1 = %d, n2 = %d\n", n1, n2);

	swap_int(&n1, &n2);

	printf("After swapping: n1 = %d, n2 = %d\n", n1, n2);

	return 0;
}

void swap_int(int* n1, int* n2) {
	int temp = *n1;
	*n1 = *n2;
	*n2 = temp;
}