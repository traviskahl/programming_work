/*
4. Write a program in C to print the array elements using recursion. Go to the editor
Test Data :
Input the number of elements to be stored in the array :6
Input 6 elements in the array :
element - 0 : 2
element - 1 : 4
element - 2 : 6
element - 3 : 8
element - 4 : 10
element - 5 : 12
Expected Output :

The elements in the array are : 2  4  6  8  10  12 
*/

#include <stdio.h>
#include <stdlib.h>

void print_recursive(int* array, int length, int index);

int main() {
	printf("Input the number of elements to be stored in the array : ");
	int length;
	scanf("%d", &length);

	int* array = (int*) malloc(length * sizeof(int));
	printf("Input %d elements in the array :\n", length);
	for (int x = 0; x < length; ++x) {
		printf("element - %d : ", x);
		scanf("%d", &array[x]);
	}

	printf("The elements in the array are:");
	print_recursive(array, length, 0);
	printf("\n");

	free(array);
	return 0;
}

void print_recursive(int* array, int length, int index) {
	if (index == length)
		return;
	else {
		printf(" %d ", array[index]);
		print_recursive(array, length, index+1);
	}
}