/*
3. Write a program in C to find the sum of all elements of the array. Go to the editor
Test Data :
Input the number of elements to be stored in the array :3
Input 3 elements in the array :
element - 0 : 2
element - 1 : 5
element - 2 : 8
Expected Output :
Sum of all elements stored in the array is : 15
*/

#include <stdio.h>
#include <stdlib.h>

int main() {
	int num_elements;
	int i;

	printf("Input the number of elements to be stored in the array : ");
	scanf("%d", &num_elements);

	int* array = (int*) malloc(num_elements*sizeof(int));

	printf("Input %d elements in the array :\n", num_elements);
	for (i = 0; i < num_elements; ++i) {
		printf("element - %d : ", i);
		scanf("%d", (array+i));
	}

	// find the sum
	int sum = 0;
	for (i = 0; i < num_elements; ++i) {
		sum += *(array+i);
	}

	printf("Sum of all elements stored in the array is : %d\n", sum);
	free(array);
	return 0;
}