/*
10. Write a program in C to separate odd and even integers in separate arrays. Go to the editor
Test Data :
Input the number of elements to be stored in the array :5
Input 5 elements in the array :
element - 0 : 25
element - 1 : 47
element - 2 : 42
element - 3 : 56
element - 4 : 32
Expected Output :
The Even elements are :
42 56 32
The Odd elements are :
25 47
*/

#include <stdio.h>
#include <stdlib.h>

int main() {
	printf("Input the number of elements to be stored in the array : ");
	int num;
	scanf("%d", &num);

	int* arr = (int*) malloc(num * sizeof(int));

	printf("Input %d elements in the array :\n", num);
	for (int i = 0; i < num; ++i) {
		printf("element - %d : ", i);
		scanf("%d", &arr[i]);
	}

	// sort into separate arrays
	// let's find out how many of each we have
	int num_evens, num_odds;
	for (int i = 0; i < num; ++i) {
		if (arr[i] % 2 == 0)
			++num_evens;
		else
			++num_odds;
	}

	// now we know how many we have, we can allocate our arrays
	int* evens = (int*) malloc(num_evens * sizeof(int));
	int* odds = (int*) malloc(num_odds * sizeof(int));

	// and finally place them in the arrays
	int count_evens = 0;
	int count_odds = 0;
	for (int i = 0; i < num; ++i) {
		if (arr[i] % 2 == 0)
			evens[count_evens++] = arr[i];
		else
			odds[count_odds++] = arr[i];
	}

	free(arr);

	printf("The Even elements are :\n");
	for (int i = 0; i < num_evens; ++i)
		printf("%d ", evens[i]);

	printf("\nThe Odd elements are :\n");
	for (int i = 0; i < num_odds; ++i)
		printf("%d ", odds[i]);

	free(evens);
	free(odds);
	printf("\n");

	return 0;
}