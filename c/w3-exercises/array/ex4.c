/*
4. Write a program in C to copy the elements one array into another array. Go to the editor
Test Data :
Input the number of elements to be stored in the array :3
Input 3 elements in the array :
element - 0 : 15
element - 1 : 10
element - 2 : 12
Expected Output :
The elements stored in the first array are :
15 10 12
The elements copied into the second array are :
15 10 12
*/

#include <stdio.h>
#include <stdlib.h>

int main() {
	int num_elements;

	printf("Input the number of elements to be stored in the array : ");
	scanf("%d", &num_elements);

	int* first_array = (int*) malloc(num_elements*sizeof(int));
	int* second_array = (int*) malloc(num_elements*sizeof(int));

	printf("Input %d elements in the array :\n", num_elements);
	for (int i = 0; i < num_elements; ++i) {
		printf("element - %d : ", i);
		scanf("%d", &first_array[i]);
	}

	printf("The elements stored in the first array are :\n");
	for (int i = 0; i < num_elements; ++i)
		printf("%d ", first_array[i]);
	printf("\n");

	// do a deep copy
	for (int i = 0; i < num_elements; ++i)
		second_array[i] = first_array[i];
	free(first_array);

	printf("The elements copied into the second array are :\n");
	for (int i = 0; i < num_elements; ++i)
		printf("%d ", second_array[i]);

	printf("\n");
	free(second_array);
	return 0;
}