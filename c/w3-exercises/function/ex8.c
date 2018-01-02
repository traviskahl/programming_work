/*
8. Write a program in C to get the largest element of an array using the function. Go to the editor
Test Data :
Input the number of elements to be stored in the array :5
Input 5 elements in the array :
element - 0 : 1
element - 1 : 2
element - 2 : 3
element - 3 : 4
element - 4 : 5
Expected Output :

The largest element in the array is : 5   
*/

#include <stdio.h>
#include <stdlib.h>

int get_largest_element(int* array, int length);

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

	int largest = get_largest_element(array, length);

	printf("The largest element in the array is : %d\n", largest);

	free(array);
	return 0;
}

int get_largest_element(int* array, int length) {
	int largest_seen = array[0];
	for (int x = 1; x < length; ++x) {
		if (array[x] > largest_seen)
			largest_seen = array[x];
	}

	return largest_seen;
}