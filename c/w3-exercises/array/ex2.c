/*
2. Write a program in C to read n number of values in an array and display it in reverse order. Go to the editor
Test Data :
Input the number of elements to store in the array :3
Input 3 number of elements in the array :
element - 0 : 2
element - 1 : 5
element - 2 : 7
Expected Output :
The values store into the array are :
2 5 7
The values store into the array in reverse are :
7 5 2
*/

#include <stdio.h>
#include <stdlib.h>

int main() {
	int num_elements;

	printf("Input the number of elements to store in the array : ");
	scanf("%d", &num_elements);

	int* array = (int*) calloc(num_elements, sizeof(int));

	printf("Input %d number of elements in the array :\n", num_elements);
	for (int i = 0; i < num_elements; ++i) {
		printf("element - %d : ", i);
		scanf("%d", (array+i));
	}

	printf("The values store into the array are :\n");
	for (int i = 0; i < num_elements; ++i)
		printf("%d ", *(array+i));

	printf("\n");

	printf("The values store into the array in reverse are :\n");
	for (int i = num_elements-1; i >= 0; --i)
		printf("%d ", *(array+i));

	printf("\n");

	free(array);

	return 0;
}