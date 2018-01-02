/*
9. Write a program in C to find the maximum and minimum element in an array. Go to the editor
Test Data :
Input the number of elements to be stored in the array :3
Input 3 elements in the array :
element - 0 : 45
element - 1 : 25
element - 2 : 21
Expected Output :
Maximum element is : 45
Minimum element is : 21 
*/

#include <stdio.h>
#include <stdlib.h>

int main() {
	int num_elements;
	printf("Input the number of elements to be stored in the array : ");
	scanf("%d", &num_elements);

	int* arr = (int*) malloc(num_elements * sizeof(int));

	printf("Input %d elements in the array :\n", num_elements);
	for (int count = 0; count < num_elements; ++count) {
		printf("element - %d : ", count);
		scanf("%d", &arr[count]);
	}

	// find minimum and maximum
	int minimum = arr[0];
	int maximum = arr[0];

	for (int count = 1; count < num_elements; ++count) {
		if (arr[count] < minimum)
			minimum = arr[count];
		if (arr[count] > maximum)
			maximum = arr[count];
	}

	printf("Maximum element is : %d\n", maximum);
	printf("Minimum element is : %d\n", minimum);

	free(arr);
	return 0;
}