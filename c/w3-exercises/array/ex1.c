/*
Write a program in C to store elements in an array and print it. Go to the editor
Test Data :
Input 10 elements in the array :
element - 0 : 1
element - 1 : 1
element - 2 : 2
.......
Expected Output :
Elements in array are: 1 1 2 3 4 5 6 7 8 9
*/

#include <stdio.h>

int main() {
	int elements[10];
	printf("Input 10 elements in the array :\n");

	for (unsigned i = 0; i < sizeof(elements)/sizeof(elements[0]); ++i) {
		printf("element - %d : ", i);
		scanf("%d", (elements+i));
	}

	printf("Elements in array are: ");
	for (unsigned i = 0; i < sizeof(elements)/sizeof(elements[0]); ++i) {
		printf("%d ", elements[i]);
	}

	printf("\n");

	return 0;
}